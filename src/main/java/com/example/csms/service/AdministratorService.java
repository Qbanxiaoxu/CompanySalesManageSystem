package com.example.csms.service;


import com.example.csms.bean.Administrator;

import java.util.List;

public interface AdministratorService {
    void addAdministrator(Administrator administrator);
    void deleteAdministrator(int administratorId);
    Administrator findAdministratorById(int administratorId);
    void modifyAdministrator(Administrator administrator);
    List<Administrator> queryAdministrators();
    Administrator verifyAdministrator(String username,String password);
}
