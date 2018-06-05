package xyz.northsky.shop.config;

public interface AlipayConfig {

    String APPID = "2016090900469767";

    String PRIVATE_KEY = "";

    String ALIPAY_PUBLIC_KEY = "";

    /*String NOTIFY_URL = "http://9jb6s3.natappfree.cc/order/process";

    String USER_RETURN_URL = "http://9jb6s3.natappfree.cc/order/success";*/

    String NOTIFY_URL = "http://www.northsky.xyz:8080/order/process";

    String USER_RETURN_URL = "http://www.northsky.xyz:8080/order/success";

    String SIGN_TYPE = "RSA2";

    String CHARSET = "UTF-8";

    String GATEWAY_URL = "https://openapi.alipaydev.com/gateway.do";

}
