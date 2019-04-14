package org.mk.mkvue2backend.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController {

    @PostMapping("/loginCheck")
    public void loginCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Map<String,String> respMap = new HashMap<>();
        if ("limk".equals(username)&&"8080".equals(password)){
            HttpSession session = request.getSession(true);
            session.setAttribute("username","limk");
            session.setMaxInactiveInterval(30);
            respMap.put("login","true");
            PrintWriter printWriter = response.getWriter();
            printWriter.print(JSON.toJSONString(respMap));
            //response.sendRedirect("#/");
        }else {
            respMap.put("login","false");
            PrintWriter printWriter = response.getWriter();
            printWriter.print(JSON.toJSONString(respMap));
        }
    }
}
