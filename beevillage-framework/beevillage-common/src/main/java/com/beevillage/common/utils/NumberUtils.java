package com.beevillage.common.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 数字工具类
 *
 * @author Jason Feng
 * @since 2026-03-22 16:25
 */
public class NumberUtils {

    /**
     * 数字转换字符串
     *
     * @param number
     * @return
     */
    public static String formatNumberString(Long number) {
        if (number == null) {
            return "0";
        } else if (number < 10000) {
            return String.valueOf(number);  // 小于 1 万显示原始数字
        } else if (number < 100000000) {
            // 小于 1 亿，显示万单位
            double result = number / 10000.0;
            DecimalFormat df = new DecimalFormat("#.#"); // 保留 1 位小数
            df.setRoundingMode(RoundingMode.DOWN); // 禁用四舍五入
            String formatted = df.format(result);
            return formatted + "万";
        } else {
            return "9999万";  // 超过 1 亿，统一显示 9999万
        }
    }

    public static void main(String[] args) {
        // 测试
        System.out.println(formatNumberString(1000L));         // 1000
        System.out.println(formatNumberString(11130L));        // 1.1万
        System.out.println(formatNumberString(26719300L));     // 2671.9万
        System.out.println(formatNumberString(10000000L));    // 1000万
        System.out.println(formatNumberString(999999L));       // 99.9万
        System.out.println(formatNumberString(150000000L));    // 超过一亿，展示9999万
        System.out.println(formatNumberString(99999L));        // 9.9万
    }
}