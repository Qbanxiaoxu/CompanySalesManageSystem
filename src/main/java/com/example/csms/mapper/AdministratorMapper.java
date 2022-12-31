package com.example.csms.mapper;


import com.example.csms.bean.Administrator;

import java.util.List;

public interface AdministratorMapper {
    void addAdministrator(Administrator administrator);
    void deleteAdministrator(int administratorId);
    Administrator findAdministrator(String username, String password);
    Administrator findAdministratorById(int administratorId);
    void modifyAdministrator(Administrator administrator);
    List<Administrator> queryAdministrators();

}
