package it.euris.javaacademy.centrosportivocv.utility;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class DataConversionUtils {

    private DataConversionUtils() {
    }

    public static String bigIntToString(Number value) {
        return value == null ? null : value.toString();
    }

    public static BigInteger stringToBigInt(String value) {
        return value == null ? null : new BigInteger(value);
    }

    public static LocalDateTime stringToLocalDateTime(String value) {
        return value == null ? null : LocalDateTime.parse(value);
    }

    public static String localDateTimeToString(LocalDateTime value) {
        return value == null ? null : String.valueOf(value);
    }
}
