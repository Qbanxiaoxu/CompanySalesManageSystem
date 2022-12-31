package com.example.csms.controller;


import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/ModifyOrder", name = "modify",method = RequestMethod.POST)
    public void modifyOrder(@RequestParam("orderId")String orderId, @RequestParam("orderTime")String orderTime, @RequestParam("clientId")String clientId, @RequestParam("salesStaffId")String salesStaffId, @RequestParam("consumption")String consumption){
        if (orderTime==null || clientId==null ||salesStaffId==null)return;
        String url="http://orderserver/modify/"+orderId+"/"+orderTime+"/"+clientId+"/"+salesStaffId+"/"+consumption;
        restTemplate.getForObject(url,String.class);
    }


    @RequestMapping(value = "/AddOrder", name="add",method= RequestMethod.POST)
    public void addOrder(@RequestParam("orderId")String orderId,@RequestParam("orderTime")String orderTime,@RequestParam("clientId")String clientId,@RequestParam("salesStaffId")String salesStaffId,@RequestParam("consumption")String consumption){
        if (orderTime==null || clientId==null ||salesStaffId==null)return;
        String url="http://orderserver/add/"+orderId+"/"+orderTime+"/"+clientId+"/"+salesStaffId+"/"+consumption;
        restTemplate.getForObject(url,String.class);
    }

    /**
     * 获得营业额
     *
     * @return {@link String}
     */
    @RequestMapping(value = "/CheckTurnover", name = "查看公司营业额")
    public String getTurnover(){
        StringBuilder json=new StringBuilder();
        json.append("[");
        String jsonStr="";
        String url="http://orderserver/order/query";
        String ordersJson=restTemplate.getForObject(url,String.class);

        JSONArray orders= JSONArray.parseArray(ordersJson);


        long turnover=0;
        //TODO
        //if (orders != null) {
        //    for(int i=0;i<orders.size();i++){
        //        Object j=orders.get(i);
        //    }
        //}
        json.append("{\"turnover\":");
        json.append(turnover);
        json.append("}");
        jsonStr=json.substring(0,json.length())+"]";
        return jsonStr;
    }
}
