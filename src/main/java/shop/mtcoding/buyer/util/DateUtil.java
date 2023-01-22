package shop.mtcoding.buyer.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static String format(Timestamp stamp) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}

// LocalDateTime nowTime = stamp.toLocalDateTime();
// String nowStr = nowTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
// return nowStr;