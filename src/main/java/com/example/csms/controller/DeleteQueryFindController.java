package com.example.csms.controller;


import com.example.csms.bean.*;
import com.example.csms.service.*;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class DeleteQueryFindController {
    @Resource
    private AdministratorService administratorService;
    @Resource
    private ClientService clientService;
    @Resource
    private SalesStaffService salesStaffService;

    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private OrderDetailService orderDetailService;
    @Resource
    private ProductService productService;
    /**
     * 删除管理人员、客户、销售人员、订单、订单明细、产品
     */
    @RequestMapping(value = "/Delete", name = "delete")
    @ResponseBody
    public void delete(HttpServletRequest request){
        int ID= Integer.parseInt(request.getParameter("ID"));
        String object=request.getParameter("object");
        if(object.equals("Administrator"))
            administratorService.deleteAdministrator(ID);
        if (object.equals("Client"))
            clientService.deleteClient(ID);
        if (object.equals("SalesStaff"))
            salesStaffService.deleteSalesStaff(ID);
        if (object.equals("Order")){
            String url="http://orderserver/order/delete/"+ String.valueOf(ID);
            String string =restTemplate.getForObject(url,String.class);
            System.out.println(string);
        }
        if (object.equals("OrderDetail"))
            orderDetailService.deleteOrderDetailById(ID);
        if (object.equals("Product"))
            productService.deleteProduct(ID);
    }
    /**
     * 查询客户信息、产品信息、销售人员信息、订单信息
     *
     * @return {@link String}
     */
    @RequestMapping(value = "/Query", name = "query")
    @ResponseBody
    public String query(HttpServletRequest request){
        String object=request.getParameter("object");
        Gson gson=new Gson();
        if(object.equals("Administrator")){
            List<Administrator> administrators=administratorService.queryAdministrators();
            return gson.toJson(administrators);
        }
        if(object.equals("Client")){
            List<Client> clients=clientService.queryClients();
            return gson.toJson(clients);
        }
        if(object.equals("SalesStaff")){
            List<SalesStaff> salesStaffs=salesStaffService.querySalesStaffs();
            return gson.toJson(salesStaffs);
        }
        if(object.equals("Product")){
            List<Product> products=productService.queryProducts();
            return gson.toJson(products);
        }
        if(object.equals("Order")){
            String url="http://orderserver/order/query";
            //System.out.println(restTemplate.getForObject(url, String.class));
            return restTemplate.getForObject(url, String.class);
        }
        if(object.equals("orderDetail")){
            List<OrderDetail> orderDetails=orderDetailService.queryOrderDetails();
            return gson.toJson(orderDetails);
        }
        return "404.html";
    }

    /**
     * 查找客户、销售人员、管理人员、订单、订单明细、产品
     *
     * @return {@link String}
     */
    @RequestMapping(value = "/Find", name = "find")
    @ResponseBody
    public String findById(HttpServletRequest request) {
        String object = request.getParameter("object");
        int id = Integer.parseInt(request.getParameter("ID"));
        Gson gson=new Gson();
        if (object.equals("Administrator")) {
            Administrator administrator = administratorService.findAdministratorById(id);

            return gson.toJson(administrator);
        }
        if (object.equals("Client")) {
            Client client = clientService.findClientById(id);

            return gson.toJson(client);
        }
        if (object.equals("SalesStaff")) {
            SalesStaff salesStaff = salesStaffService.findSalesStaffById(id);

            return gson.toJson(salesStaff);
        }
        if (object.equals("Product")) {
            Product product = productService.findProduct(id);

            return gson.toJson(product);
        }
        if (object.equals("Order")) {
            String url="http://orderserver/order/find/"+String.valueOf(id);
            //System.out.println(result);
            return restTemplate.getForObject(url,String.class);
        }
        if (object.equals("orderDetail")) {
            OrderDetail orderDetail = orderDetailService.findOrderDetail(id);

            return gson.toJson(orderDetail);
        }
        return "404.html";
    }
}
