package xyz.northsky.shop.utils;

import com.google.common.collect.Collections2;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtil {

    private StringUtil(){}

    public static List<Integer> ConvertIdsToIntegerList(String ids) {
        List<Integer> list = Collections.emptyList();
        if (isNotBlank(ids)) {
            list = Arrays.stream(ids.split(",")).map(s -> {
                return Integer.valueOf(s);
            }).collect(Collectors.toList());
        }
        return list;
    }

    public static void print(Object...objects) {
        Stream.of(objects).forEach(System.out::println);
    }

    public static boolean isNotBlank(String str){
        return str != null && !"".equals(str);
    }

    public static String convertRequestParamCharset(String source ,ConvertType convertType) throws UnsupportedEncodingException {
        if (!StringUtil.isNotBlank(source)) {
            throw new RuntimeException("source string can not be null!");
        }
        return new String(source.getBytes(convertType.from), convertType.to);
    }

    public enum ConvertType{
        ISO_TO_GBK("ISO-8859-1", "GBK"),
        ISO_TO_UTF8("ISO-8859-1", "UTF-8");
        private String from;
        private String to;

        ConvertType(String from, String to) {
            this.from = from;
            this.to = to;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }
    }

}
