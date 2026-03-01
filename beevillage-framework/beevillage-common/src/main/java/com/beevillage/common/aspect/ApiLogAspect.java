package com.beevillage.common.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Common 模块通用接口日志切面
 * <p>
 * 记录请求信息、响应信息、执行耗时、异常信息
 * </p>
 *
 * @author Jason Feng
 * @since 2026-01-31 18:36
 */
@Slf4j
@Aspect
public class ApiLogAspect {

    /**
     * 定义切点：匹配所有Controller层的接口
     * 格式：execution(返回值 包名.类名.方法名(参数))
     * *：通配符，代表所有；..：代表任意参数/子包
     */
    @Pointcut("execution(* com.beevillage..controller..*.*(..))")
    public void apiLogPointcut() {}

    /**
     * 环绕通知：在方法执行前后做处理，可获取执行耗时、控制方法执行
     * ProceedingJoinPoint：仅环绕通知可用，可执行目标方法
     */
    @Around("apiLogPointcut()")
    public Object aroundApiLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1. 前置处理：获取请求信息，记录开始时间
        long startTime = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        // 构建请求日志信息
        Map<String, Object> requestLog = new HashMap<>();
        requestLog.put("接口路径", request.getRequestURI());
        requestLog.put("请求方式", request.getMethod());
        requestLog.put("调用类方法", method.getDeclaringClass().getName() + "." + method.getName());
        requestLog.put("请求IP", request.getRemoteAddr());
        requestLog.put("请求头", getRequestHeaders(request));
        requestLog.put("请求参数", getSerializableArgs(joinPoint.getArgs()));

        // 安全序列化请求日志
        log.info("【接口请求】>>{}", safeSerialize(requestLog));

        Object result = null;
        try {
            result = joinPoint.proceed();
            return result;
        } catch (Throwable e) {
            // 2. 抛出异常，让全局异常处理器继续捕获（不吞异常）
            long costTime = System.currentTimeMillis() - startTime;
            log.error("【接口异常】接口执行失败，耗时：{}ms，异常信息：{}", costTime, e.getMessage(), e);
            throw e;
        } finally {
            // 3. 后置处理：记录结束时间，计算执行耗时，打印响应日志
            long costTime = System.currentTimeMillis() - startTime;
            Map<String, Object> responseLog = new HashMap<>();
            responseLog.put("接口路径", request.getRequestURI());
            responseLog.put("执行耗时", costTime + "ms");
            responseLog.put("响应结果", safeSerialize(result));

            // 打印响应日志
            log.info("【接口响应】<<{}", safeSerialize(responseLog));
        }
    }

    /**
     * 安全序列化对象：处理循环引用、不可序列化对象，避免报错
     * @param obj 待序列化的对象
     * @return 序列化后的字符串，失败则返回提示信息
     */
    private String safeSerialize(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            // 配置FastJSON序列化规则：
            // WriteNullStringAsEmpty：null字符串转空串
            // WriteNullListAsEmpty：null集合转空集合
            // DisableCircularReferenceDetect：禁用循环引用检测
            return JSON.toJSONString(obj,
                    SerializerFeature.WriteNullStringAsEmpty,
                    SerializerFeature.WriteNullListAsEmpty,
                    SerializerFeature.DisableCircularReferenceDetect);
        } catch (Exception e) {
            // 序列化失败时返回对象的基本信息，避免日志报错
            log.warn("对象序列化失败，类型：{}，原因：{}", obj.getClass().getName(), e.getMessage());
            return String.format("[序列化失败] 类型：%s，toString：%s", obj.getClass().getName(), obj.toString());
        }
    }

    /**
     * 处理请求参数：过滤不可序列化的对象（如MultipartFile），返回可序列化的参数列表
     * @param args 原始请求参数
     * @return 处理后的可序列化参数
     */
    private Object getSerializableArgs(Object[] args) {
        if (args == null || args.length == 0) {
            return Collections.emptyList();
        }
        List<Object> serializableArgs = new ArrayList<>();
        for (Object arg : args) {
            if (arg == null) {
                serializableArgs.add(null);
                continue;
            }
            // 过滤常见的不可序列化对象（如文件上传的MultipartFile）
            Class<?> argClass = arg.getClass();
            if (MultipartFile.class.isAssignableFrom(argClass)) {
                MultipartFile file = (MultipartFile) arg;
                // 只记录文件基本信息，不记录文件内容
                Map<String, String> fileInfo = new HashMap<>();
                fileInfo.put("文件名", file.getOriginalFilename());
                fileInfo.put("文件大小", file.getSize() + "bytes");
                fileInfo.put("文件类型", file.getContentType());
                serializableArgs.add(fileInfo);
            } else if (argClass.isArray() || Collection.class.isAssignableFrom(argClass)) {
                // 数组/集合递归处理
                serializableArgs.add(getSerializableCollection(arg));
            } else if (argClass.isPrimitive() || arg instanceof String || arg instanceof Number || arg instanceof Boolean) {
                // 基本类型/字符串直接保留
                serializableArgs.add(arg);
            } else {
                // 自定义对象尝试安全序列化后再转回，确保可打印
                try {
                    serializableArgs.add(JSON.parse(safeSerialize(arg)));
                } catch (Exception e) {
                    // 仍序列化失败则记录对象基本信息
                    serializableArgs.add(String.format("[不可序列化对象] 类型：%s", argClass.getName()));
                }
            }
        }
        return serializableArgs;
    }

    /**
     * 递归处理集合/数组中的不可序列化元素
     */
    private Object getSerializableCollection(Object obj) {
        if (obj == null) {
            return null;
        }
        // 处理数组
        if (obj.getClass().isArray()) {
            Object[] array = (Object[]) obj;
            List<Object> list = new ArrayList<>();
            for (Object o : array) {
                list.add(getSerializableArgs(new Object[]{o}).toString());
            }
            return list;
        }
        // 处理集合
        if (obj instanceof Collection) {
            Collection<?> collection = (Collection<?>) obj;
            List<Object> list = new ArrayList<>();
            for (Object o : collection) {
                list.add(getSerializableArgs(new Object[]{o}).toString());
            }
            return list;
        }
        return obj;
    }

    /**
     * 辅助方法：获取请求头信息
     */
    private Map<String, String> getRequestHeaders(HttpServletRequest request) {
        Map<String, String> headerMap = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            headerMap.put(key, value);
        }
        return headerMap;
    }
}