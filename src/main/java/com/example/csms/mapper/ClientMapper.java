package com.example.csms.mapper;


import com.example.csms.bean.Client;

import java.util.List;

public interface ClientMapper {
    void addClient(Client client);
    void deleteClient(int clientId);
    Client findClient(String username, String password);
    Client findClientById(int clientId);
    void modifyClient(Client client);
    List<Client> queryClients();
}
