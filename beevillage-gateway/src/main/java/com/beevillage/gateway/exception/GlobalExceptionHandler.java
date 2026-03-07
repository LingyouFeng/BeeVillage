package com.beevillage.gateway.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import com.alibaba.fastjson.JSON;
import com.beevillage.common.response.Result;
import com.beevillage.gateway.enums.GatewayResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 *
 * @author Jason Feng
 * @since 2026-02-07 16:28
 */
@Slf4j
@Component
public class GlobalExceptionHandler implements ErrorWebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        // 获取响应对象
        ServerHttpResponse response = exchange.getResponse();

        log.error("==> 全局异常捕获: ", ex);

        // 响参
        Result<?> result;
        // 根据捕获的异常类型，设置不同的响应状态码和响应消息
        // Sa-Token 异常
        // 根据捕获的异常类型，设置不同的响应状态码和响应消息
        // 未登录异常
        if (ex instanceof NotLoginException) {
            // 设置 401 状态码
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            // 构建响应结果
            result = Result.fail(GatewayResultCodeEnum.UNAUTHORIZED, ex.getMessage());
        }
        // 无权限异常
        else if (ex instanceof NotPermissionException) {
            // 权限认证失败时，设置 401 状态码
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            result = Result.fail(GatewayResultCodeEnum.UNAUTHORIZED);
        }
        // 其他异常，则统一提示 “系统繁忙” 错误
        else {
            result = Result.fail(GatewayResultCodeEnum.SYSTEM_ERROR);
        }

        // 设置响应头的内容类型为 application/json;charset=UTF-8，表示响应体为 JSON 格式
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        // 设置 body 响应体
        // 使用 Mono.fromSupplier 创建响应体
        return response.writeWith(Mono.fromSupplier(() -> {
            DataBufferFactory bufferFactory = response.bufferFactory();
            try {
                return bufferFactory.wrap(JSON.toJSONBytes(result));
            } catch (Exception e) {
                // 如果转换过程中出现异常，则返回空字节数组
                return bufferFactory.wrap(new byte[0]);
            }
        }));
    }
}
