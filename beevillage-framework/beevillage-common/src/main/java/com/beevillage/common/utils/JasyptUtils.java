package com.beevillage.common.utils;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

/**
 * Jasypt 加密解密工具类
 * <p>
 * 用于计算项目配置文件中的敏感信息（如数据库密码、接口密钥等）
 * </p>
 *
 * @author Jason Feng
 * @since 2026-01-31 10:16
 */
public class JasyptUtils {

    private static final String ALGORITHM       = "PBEWithMD5AndDES";
    private static final String ITERATIONS      = "1000";
    private static final String POOL_SIZE       = "1";
    private static final String PROVIDER_NAME   = "SunJCE";
    private static final String SALT_GENERATOR  = "org.jasypt.salt.RandomSaltGenerator";
    private static final String IV_GENERATOR    = "org.jasypt.iv.RandomIvGenerator";
    private static final String OUTPUT_TYPE     = "base64";

    /**
     * 加密
     *
     * @param password  加密盐值
     * @param text      需要加密的字符串
     * @return          加密后的字符串
     */
    public static String encrypt(String password, String text) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(config(password));
        return encryptor.encrypt(text);
    }

    /**
     * 解密
     *
     * @param password  加密盐值
     * @param text      需要解密的字符串
     * @return          解密后的字符串
     */
    public static String decrypt(String password, String text) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(config(password));
        return encryptor.decrypt(text);
    }

    /**
     * 配置
     *
     * @param password  加密盐值
     * @return          PBE 配置对象
     *
     */
    public static SimpleStringPBEConfig config(String password) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        // 设置加密盐值
        config.setPassword(password);
        // 设置算法配置信息
        config.setAlgorithm(ALGORITHM);
        config.setKeyObtentionIterations(ITERATIONS);
        config.setPoolSize(POOL_SIZE);
        config.setProviderName(PROVIDER_NAME);
        config.setIvGeneratorClassName(SALT_GENERATOR);
        config.setSaltGeneratorClassName(IV_GENERATOR);
        config.setStringOutputType(OUTPUT_TYPE);
        return config;
    }


    public static void main(String[] args) {
        String encryptStr = encrypt("686cc206aa8345f3a7bfc5585b06e97b", "2919");
        String decryptStr = decrypt("686cc206aa8345f3a7bfc5585b06e97b", encryptStr);
        System.out.println("加密后:" + encryptStr);
        System.out.println("解密后:" + decryptStr);
    }
}
