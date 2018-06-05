package xyz.northsky.shop.config;

public interface AlipayConfig {

    String APPID = "2016090900469767";

    String PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCG+iF314ivznrI6aA4sLgYrzjlJ3Ogz1QbzMGw3x4wxhVr2hu7N1aT2bI1Fm+fBJP3SYOkDwuHJgh2a2NeWsK5lF844om3VUwaT74TzUUIBcx4y/9rTn/EFIO9EblgYsnsaXvDiiCzpHoElkXOMnryGzfVd0zlxNgB38rNBf9VJ1lJwQ22XzbdctLBINAXAOVzhRO2rnu8W0kGPyhP5ro0haE5Kikptw101oo2OThLi9IOf6xzL/zfscTDS0NTKeN/uX6i6OG7qXIXXoSDv/QZk0wq4EG3OleCASmPGSNz0G5nD9b+HuUaiez4/UBvbfUnlaSCJSLZkl/h5lK4Ue27AgMBAAECggEAPQQxwPUkCyVyCATksvvgHPiI5b5R3O4cfXywSn5yLWY+JMUyKA26C5groSgFSYNOSElpQu6yLWQaCz48a1joEfBqo1J1IvViM7q8mEMA48GLT0gYrK+NvlvvubabcGD4GvEMS7bTVaISrqQn5jCXt35qXQtTLcMwSpiaGtiNNjatUs9xiibQ9f0k+C2FXQV/QHzI4aP98+EvApL6OmdjPB797hZGZplMo8IELH8b48BLB2slw0snKu3cHm3KVJiXKXhm4IVTiBMEwkW0KGeBVmVytl9tKRk90hFTkBdsqXg3m6p38Pl8N7pF6R7ZkSYiPtYQLH6gB+qFiZuj52R1AQKBgQDAXy+hyfg8NKU0Vzr/tHzaaYYNNfFgaIyKMMk/38z0Cgo1ryd3joZRrrycuv8U3OlDaCgOhvc1B3GeCIgK+b8C+1IdhYovv3NT/kJmexkVg3WIzuiSNMouVrVeFUpFbSGms297WW9KIYLPw7aMUVikycg88/YkOlpwG0UMZ2eLQQKBgQCznx/++wCozegwv0jPV9zRqZ0O/BdFZKXZKBYkDJxgz4HQY2IaqBpKZN3Nw6U3DqYGMVLRzMKrsQLk9/WXRtBggg6mZAjjm3qHv/KIZ3++uBGfGliblCYZWDyorLZw7wQTRwH0F/rb0nMqPnshr6cykExMYhKc4wvJGO89D6wl+wKBgFnAz2dr5R6p7V5TSJqfKhV5YGrvfRPfE5syEeN0VpqRyJutgft9Ctw3a5awhGzGeSrTAMVuYQ5jz7XNAzQju+P3QCO393Y5m+RXX8GSs2xfLkpLRyVX7fDa0bn4svNbbHTriRsC6jKrGe43wQcMuRABeSQ/KttSQnnFr1yPLjdBAoGAAVk0eEmSG7JQB+2nskbKlZhcYXxrAE5dIGA4qlSd5+wm4VWdqu2QJPbU43KQjvVBMdK0+HY9D+ToTKe/5D7X2aGgUod1uZ+1L8e1HmkIgHoJR9R+zcwy7QXIjsudIwPoV+y0iwyTCYtu6eZGLl6PNsX2jKw/z4W01PGm+iJf/HkCgYBkO9vApRip6aG8vJzMtOly1bIdGc0vAud+t5k1xSLnWO7jCvtsAYajM3xU5yhCJWbHmrzLme2rc+B5iF2kTGtmFHS8pMMyXOQ4jAOFU41rhSeDIMig/eML9JV5g6HaUYYO5j+Q1YfOhvV7hvKgJ0gmUbNhLpEDUT3eQQv9E30Tfg==";

    String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1g+A1dohEmHuwyh6LYI5z9+NsTg6SPXK/WSM9eabdEPCdRtl7gUnPOZ88RsMVbyYjbGyr5vUvf99+rXKG1r3DRYOWQ1o+RR+dMqHomt/2LGKz4jxqzKAuUYw7xcSDsz6IhtBofIo+T6kSJ0TTs5KPIzwRdnnJts/urciSYLMmWfcvnNLKuv3ppnBRu978C+oc6SnObl0P1ni1vFTum62hga1rzW20ucAhx2VwC/MK57rTadYsPZf/12yLK3fokArWdLjXjS/iRcSE1tZ12AS89rv357ryfPqbU4EalrImCPPrqCkHLgpeRghgetXle3sEY9tFh6mnochOQ1GVDAbUwIDAQAB";

    /*String NOTIFY_URL = "http://9jb6s3.natappfree.cc/order/process";

    String USER_RETURN_URL = "http://9jb6s3.natappfree.cc/order/success";*/

    String NOTIFY_URL = "http://www.northsky.xyz:8080/order/process";

    String USER_RETURN_URL = "http://www.northsky.xyz:8080/order/success";

    String SIGN_TYPE = "RSA2";

    String CHARSET = "UTF-8";

    String GATEWAY_URL = "https://openapi.alipaydev.com/gateway.do";

}
