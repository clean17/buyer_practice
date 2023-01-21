package shop.mtcoding.buyer.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PurchaseAllDto {
    private int id;
    private String username; // 유저이름
    private String name; // 상품이름
    private int count;
}