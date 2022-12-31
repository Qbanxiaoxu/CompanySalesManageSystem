package com.example.csms.controller;


import com.example.csms.bean.Administrator;
import com.example.csms.service.AdministratorService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdministratorController {
    @Resource
    private AdministratorService administratorService;

    /**
     * 添加客户、产品、销售人员、管理人员
     *
     */
    @RequestMapping(value = "/AddAdministrator", name="add",method= RequestMethod.POST)
    @ResponseBody
    public String addAdmin(Administrator administrator){
        if (administrator==null)
            return "404.html";
        administratorService.addAdministrator(administrator);
        return null;
    }


    @RequestMapping(value = "/ModifyAdministrator", name = "modify")
    public String modifyAdmin(HttpServletRequest request, Administrator administrator){
        //String refererUrl = request.getHeader("Referer");//当没有跳转参数时，根据Referer返回
        //System.out.println("redirect:/administratorInterface?username="+administrator.getAdministratorName()+"&password="+administrator.getAdministratorPassword());
        administratorService.modifyAdministrator(administrator);

        request.setAttribute("username",administrator.getAdministratorName());
        request.setAttribute("password",administrator.getAdministratorPassword());

        return "redirect:/administratorInterface?username="+administrator.getAdministratorName()+"&password="+administrator.getAdministratorPassword();
    }
}
