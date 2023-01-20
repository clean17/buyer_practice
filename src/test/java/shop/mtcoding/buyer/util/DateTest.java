package shop.mtcoding.buyer.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class DateTest {

    @Test
    public void parse_test() {
        // given
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        LocalDateTime nowTime = timestamp.toLocalDateTime();
        String nowStr = nowTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(nowStr);
    }
}
