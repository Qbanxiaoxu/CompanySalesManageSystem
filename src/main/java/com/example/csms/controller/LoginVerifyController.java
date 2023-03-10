package com.example.csms.controller;


import com.example.csms.bean.Administrator;
import com.example.csms.bean.Client;
import com.example.csms.bean.SalesStaff;
import com.example.csms.service.AdministratorService;
import com.example.csms.service.ClientService;
import com.example.csms.service.SalesStaffService;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class LoginVerifyController {
    @Resource
    private AdministratorService administratorService;
    @Resource
    private ClientService clientService;
    @Resource
    private SalesStaffService salesStaffService;


    @RequestMapping(value = "/LoginVerify",name = "登录验证",method = RequestMethod.POST)
    public String loginMethod(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // 获取用户名
        String username = request.getParameter("username");
        // 获取密码
        String password = request.getParameter("password");
        // 获取身份
        String identity = request.getParameter("identity");
        if (("".equals(password)) || identity==null ||("".equals(username))) {
            return "redirect:/loginView?empty=yes";
        }else {
            Administrator administrator = null;
            Client client = null;
            SalesStaff salesStaff = null;
            switch (identity) {
                case "manager" -> {
                    administrator = administratorService.verifyAdministrator(username, password);
                    break;
                }
                case "client" -> {
                    client = clientService.verifyClient(username, password);
                    break;
                }
                case "sales staff" -> {
                    salesStaff = salesStaffService.verifySalesStaff(username, password);
                    break;
                }
                default -> {}
            }
            if (administrator == null && client == null && salesStaff == null) {
                //response.sendRedirect("loginView?error=yes");
                return "redirect:/loginView?error=yes";
            }
            else if(administrator!=null) {
                request.setAttribute("username",username);
                request.setAttribute("password",password);
                //request.getRequestDispatcher("/administratorInterface").forward(request,response);
                return "redirect:/administratorInterface?username="+username+"&"+"password="+password;
            }

            else if(client!=null) {
                request.setAttribute("username",username);
                request.setAttribute("password",password);
                //request.getRequestDispatcher("/clientInterface.html").forward(request,response);
                return "redirect:/clientInterface?username="+username+"&"+"password="+password;
            }
            else {
                request.setAttribute("username",username);
                request.setAttribute("password",password);
                //request.getRequestDispatcher("/salesStaffInterface").forward(request,response);
                return "redirect:/salesStaffInterface?username="+username+"&"+"password="+password;
            }
        }
    }
    @GetMapping("/administratorInterface")
    public String administratorLogin(){
        return "administratorInterface";
    }
    @GetMapping("/clientInterface")
    public String clientLogin(){
        return "clientInterface";
    }
    @GetMapping("/salesStaffInterface")
    public String salesStaffLogin(){
        return "salesStaffInterface";
    }
}
