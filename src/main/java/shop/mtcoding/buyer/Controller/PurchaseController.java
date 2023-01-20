package shop.mtcoding.buyer.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.buyer.model.Product;
import shop.mtcoding.buyer.model.ProductRepository;
import shop.mtcoding.buyer.model.PurchaseRepository;
import shop.mtcoding.buyer.model.User;

@Controller
public class PurchaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private HttpSession session;

    @PostMapping("/purchase/{id}")
    public String purchaselist(@PathVariable int id, int count) {
        User user = (User) session.getAttribute("principal");
        if (user == null) {
            return "redirect:/loginForm";
        } else {
            Product product = productRepository.findById(id);
            String name1 = product.getName();
            int price1 = product.getPrice();
            int qty1 = product.getQty() - count;

            int result = purchaseRepository.insert(user.getId(), id, count);
            if (result != 1) {
                return "redirect:/product";
            }
            int result2 = productRepository.updateById(id, name1, price1, qty1);
            if (result2 == 1) {
                return "redirect:/product/" + id;
            } else {
                return "redirect:/product/" + id;
            }
        }
    }
}