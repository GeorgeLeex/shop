package xyz.northsky.shop.utils;

import java.util.Collection;

public class CollectionUtil {

    private CollectionUtil(){}

    public static boolean isNotEmpty(Collection collection) {
        return collection != null && collection.size() > 0;
    }

}
