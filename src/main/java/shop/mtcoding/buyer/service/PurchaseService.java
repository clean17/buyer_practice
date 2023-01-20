package shop.mtcoding.buyer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.buyer.model.Product;
import shop.mtcoding.buyer.model.ProductRepository;
import shop.mtcoding.buyer.model.PurchaseRepository;

/*  @Controller , @RestController , @Mapper , @Service , @Component -- IoC 에 생성 */

@Service
public class PurchaseService {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Transactional
    public int 구매하기(int principalId, int productId, int count){
        // 1. 상품 존재 확인
        Product product = productRepository.findById(productId);
        if ( product == null ) return -1;
        // 2. 수량 체크
        if ( product.getQty() < count ) return -1; 
        // 3. 재고 수량 변경
        int result2 = productRepository.updateById(
                        product.getId(), 
                        product.getName(), 
                        product.getPrice(), 
                        product.getQty() - count);

        if ( result2 != 1 ) return -1;
        // 4. 구매 이력 남기기 ( 구매 테이블은 마지막에 )
        int result = purchaseRepository.insert(principalId, productId, count);
        if ( result != 1 ) return -1;
        // 이러한 과정 (2,3,4,5) 을 '비즈니스 로직'이라고 한다.
        // 컨트롤러의 책임은 요청을 중개해줄분 원래는 모델에서 처리
        // 비즈니스 로직은 트랙잰셕 관리( 원자성 지켜 )가 필요 ( 서비스 객체 )
        return 1;
        // 커밋
    }
}
