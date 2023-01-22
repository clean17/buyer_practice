package shop.mtcoding.buyer.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.buyer.dto.PurchaseAllDto;
import shop.mtcoding.buyer.model.PurchaseRepository;
import shop.mtcoding.buyer.model.User;
import shop.mtcoding.buyer.service.PurchaseService;

@Controller
public class PurchaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private HttpSession session;

    @Autowired
    private PurchaseService purchaseService;

    /*
     * 메소드의 목적 : 세션이 있는지 체크, 구매 히스토리 남기기, 재고 수량변경
     * 파라미터로 입력받은 데이터(변수)는 입력가능한 데이터인지 검증부터 해야한다
     * 코드 작성은 필터링 방식으로 작성해야한다.. 무한 IF ELSE 에 빠지면 끔찍한 가독성
     */

    @GetMapping("/purchase") // nav - 구매목록
    public String purchase(Model model) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/notfound";
        }
        List<PurchaseAllDto> purchaseList = purchaseRepository.finebyUserId(principal.getId());
        // 필요한 데이터만 테이블에서 꺼내온다 ( PurchaseAllDto )
        model.addAttribute("purchaseList", purchaseList);
        return "purchase/list";
    }

    @PostMapping("/purchase/insert") // 상품페이지 - 구매하기 버튼
    public String purchaselist(int productId, int count) {
        // 1. 세션 체크 ( 유저 확인 ) - 이건 컨트롤러의 책임
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/notfound";
        }

        // 2.서비스 호출
        int result = purchaseService.구매하기(principal.getId(), productId, count);
        if (result == -1) {
            return "redirect:/notfound";
        }
        return "redirect:/";
    }

    @PostMapping("/purchase/delete") // 구매목록 - 구매취소 버튼
    public String purchaseDelete(int purchaseId) {
        // 1. 세션 체크 ( 유저 확인 ) - 이건 컨트롤러의 책임
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/notfound";
        }

        int result = purchaseService.구매취소하기(purchaseId);
        if (result == -1)
            return "redirect:/notfound";

        return "redirect:/";
    }
}