package shop.mtcoding.buyer.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    
    @GetMapping("/notfound")
    public String error(){
        System.out.println("테스트 에러");
        return "error/error";
    }
}
