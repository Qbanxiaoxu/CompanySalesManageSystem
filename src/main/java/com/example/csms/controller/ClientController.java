package com.example.csms.controller;


import com.example.csms.bean.Client;
import com.example.csms.service.ClientService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClientController {
    @Resource
    private ClientService clientService;

    @RequestMapping(value = "/ModifyClient", name = "modify",method = RequestMethod.POST)
    @ResponseBody
    public void modify(Client client)
    {
        clientService.modifyClient(client);
    }
    @RequestMapping(value = "/AddClient", name="add",method= RequestMethod.POST)
    @ResponseBody
    public String addClient(Client client){
        if (client==null)
            return "404.html";
        clientService.addClient(client);
        return null;
    }
}
