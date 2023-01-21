package shop.mtcoding.buyer.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import shop.mtcoding.buyer.dto.PurchaseAllDto;

@Mapper
public interface PurchaseRepository {

    public List<Purchase> findAll();

    public Purchase findById(int id);

    public List<PurchaseAllDto> finebyUserId(int id);

    public int insert(@Param("userId") int userId, @Param("productId") int productId,
            @Param("count") int count);

    public int deleteById(@Param("id") int id);

    public int updateById(@Param("id") int id, @Param("userId") int userId,
            @Param("productId") int productId, @Param("count") int count);
}
