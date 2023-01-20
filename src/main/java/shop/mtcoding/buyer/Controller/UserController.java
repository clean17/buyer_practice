package shop.mtcoding.buyer.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.buyer.model.User;
import shop.mtcoding.buyer.model.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession session;

    @GetMapping("/loginForm")
    public String loginForm(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String username="";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("remember")){
                username = cookie.getValue();
            }
        }
        request.setAttribute("remember", username);
        return "user/loginForm";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(String username, String password, String remember, HttpServletResponse response) {
        User user = userRepository.findByUsernameAndPassword(username, password);       
        if (user == null) {     // 로그인 실패시 
            return "redirect:/loginForm";
        } else {
            if( remember == null){
                remember = "";
            }
            if( remember.equals("on")){
                Cookie cookie = new Cookie("remember", username);
                response.addCookie(cookie);
                response.addHeader("Cookie",username);
            }else{
                Cookie cookie = new Cookie("remember", "");
                response.addCookie(cookie);
                cookie.setMaxAge(0);
            }
            session.setAttribute("principal", user);
            return "redirect:/";
        }
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @PostMapping("/join")
    public String join(String username, String password, String email) {
        int result = userRepository.insert(username, password, email);
        if (result == 1) {
            return "redirect:/loginForm";
        } else {
            return "redirect:/joinForm";
        }

    }

    @GetMapping("/purchase")
    public String purchase() {

        return "user/purchaseList";
    }
}
