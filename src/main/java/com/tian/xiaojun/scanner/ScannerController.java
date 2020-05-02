package com.tian.xiaojun.scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        Cookie cookie = new Cookie("key","txj");
        response.addCookie(cookie);
        return "txj";
    }
}
