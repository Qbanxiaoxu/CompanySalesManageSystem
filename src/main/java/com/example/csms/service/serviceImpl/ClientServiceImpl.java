package com.example.csms.service.serviceImpl;


import com.example.csms.bean.Client;
import com.example.csms.mapper.ClientMapper;
import com.example.csms.service.ClientService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Resource
    private com.example.csms.mapper.ClientMapper ClientMapper;
    public void addClient(Client Client){
        ClientMapper.addClient(Client);
    }

    public void deleteClient(int ClientId){
        ClientMapper.deleteClient(ClientId);
    }

    public Client findClientById(int ClientId){
        return ClientMapper.findClientById(ClientId);
    }
    public Client verifyClient(String username, String password){
        return ClientMapper.findClient(username,password);
    }

    public void modifyClient(Client Client){
        ClientMapper.modifyClient(Client);
    }

    public List<Client> queryClients(){
        return ClientMapper.queryClients();
    }
}
