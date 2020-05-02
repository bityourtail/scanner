package com.tian.xiaojun.scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@RestController
public class ScannerController {

    @GetMapping("/judge")
    public String judge(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("key")){
                    return cookie.getValue();
                }
            }
        }

        String res ;
        if(rand()){
            res = "恭喜你中奖了";
        }else {
            res = "对不起，没有中奖";
        }
        Cookie cookie = new Cookie("key",res);
        response.addCookie(cookie);
        return res;
    }

    private boolean rand(){
        Random random = new Random();
        return random.nextBoolean();
    }
}
