package com.mhj.config;

/**
 * @author mahuijian
 * @date 2019-09-11 13:00
 */
public class AlipayConfig {
    public static String app_id = "2016092600601654";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmX9AXX6ZzjGcFuLWnUPfDiZs19AGS6jE9q68c0GfoGFOhMPu2puVUdcwe53OrUMhkc11LtgmvdD0xJDLF51ZJvEPGIqNmOz7qzW06A5CptKZZUMKyYF8psTZsvksNdDOC1feRuNDwIkvsYPsyEQqciZy/Q7uD8O+KQ2ucLwgL4r2WR+lBgBONoSTYsuv1m9wTgrqXDYzRafshimuP5t9ayY18BK+xbT/cgKmMVUmuGlYi/5tETQ/gI2nwFzVKImDW1niEX9nVvyHGNRuX45E/Rhz7QYSH0H2i9TlW+bz1GQGv8WOhzBqKufvv/3uP9vzFq6M1wIceEdn9gYIAQ9qWwIDAQAB";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";
}
