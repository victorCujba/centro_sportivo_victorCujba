package it.euris.javaacademy.centrosportivocv.utility;

import java.time.LocalDateTime;

public class DataConversionUtils {

    private DataConversionUtils() {
    }

    public static String longToString(Long value) {
        return value == null ? null : value.toString();
    }

    public static Long stringToLong(String value) {
        return value == null ? null : Long.parseLong(value);
    }

    public static LocalDateTime stringToLocalDateTime(String value) {
        return value == null ? null : LocalDateTime.parse(value);
    }

    public static String localDateTimeToString(LocalDateTime value) {
        return value == null ? null : String.valueOf(value);
    }
}
