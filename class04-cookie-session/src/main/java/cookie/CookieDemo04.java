package cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * @author 11448
 * @description: TODO
 * @date 2024/10/19 14:03
 */
@WebServlet("/cookieDemo04")
public class CookieDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取Cookie 数组
        Cookie[] cookies = req.getCookies();
//        2.遍历 Cookie 数组
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("chineseName".equals(name)){
                String value = cookie.getValue();
                String decode = URLDecoder.decode(value, StandardCharsets.UTF_8);
                System.out.println("用户名："+ decode);
                break;
            }
        }
    }
}