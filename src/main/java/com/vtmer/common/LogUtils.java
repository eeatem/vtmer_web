package com.vtmer.common;

import java.util.List;

public class LogUtils {

    public static String UpdateProfileLog(String field, Object originalData, Object newData) {
        return field + ": " + originalData + " ----> " + newData;
    }

    public static void addUpdateProfileLog(List<String> updateLog, String field, Object originalData, Object newData) {
        if (newData != null && !newData.equals(originalData)) {
            updateLog.add(LogUtils.UpdateProfileLog(field, originalData, newData));
        }
    }

}
