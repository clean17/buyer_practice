package shop.mtcoding.buyer.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.buyer.util.DateUtil;

@Setter
@Getter
public class PurchaseAllDto {
    private int id;
    private String username; // 유저이름
    private String name; // 상품이름
    private int count;
    private Timestamp createdAt;

    public String getCreatedAtToString() {
        return DateUtil.format(createdAt);
    }
}