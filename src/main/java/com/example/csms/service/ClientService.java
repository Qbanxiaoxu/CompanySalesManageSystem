package com.example.csms.service;


import com.example.csms.bean.Client;

import java.util.List;

public interface ClientService {
    Client verifyClient(String username, String password);
    void addClient(Client client);
    void deleteClient(int clientId);
    Client findClientById(int clientId);
    void modifyClient(Client client);
    List<Client> queryClients();
}
