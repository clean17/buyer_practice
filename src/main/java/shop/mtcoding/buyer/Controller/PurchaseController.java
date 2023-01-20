package shop.mtcoding.buyer.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.buyer.dto.PurchaseAllDto;
import shop.mtcoding.buyer.model.ProductRepository;
import shop.mtcoding.buyer.model.PurchaseRepository;
import shop.mtcoding.buyer.model.User;
import shop.mtcoding.buyer.service.PurchaseService;

@Controller
public class PurchaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    // @Autowired
    // private ProductRepository productRepository;

    @Autowired
    private HttpSession session;

    @Autowired
    private PurchaseService purchaseService;

    /* 
     * 메소드의 목적 : 세션이 있는지 체크, 구매 히스토리 남기기, 재고 수량변경
     * 파라미터로 입력받은 데이터(변수)는 검증부터 해야한다.. 
     * 누가 공격하면 그대로 수행할거야 ?
     * 
     * 코드 작성은 필터링 방식으로 작성해야한다.. 무한 IF ELSE 에 빠지면 끔찍한 가독성
     */

    @GetMapping("/purchase")
    public String purchase(Model model) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) { return "redirect:/notfound"; }
        List<PurchaseAllDto> purchaseList = purchaseRepository.finebyUserId();
        model.addAttribute("purchaseList", purchaseList);

        return "purchase/list";
    }
   
    @PostMapping("/purchase/insert")
    public String purchaselist(int productId, int count) {
        // 1. 세션 체크 ( 유저 확인 ) - 이건 컨트롤러의 책임
        User principal = (User) session.getAttribute("principal");
        if (principal == null) { return "redirect:/notfound"; } 

        // 2.서비스 호출
        int result = purchaseService.구매하기(principal.getId(), productId, count);
        if ( result == -1 ){
            return "redirect:/notfound";
        }
        return "redirect:/";
    }
}