package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * packageName    : hello.hellospring.controller
 * fileName       : HomeController
 * author         : hyunc
 * date           : 2022-11-13
 * description    : HomeController
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-11-13        hyunc       최초 생성
 */

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

}
