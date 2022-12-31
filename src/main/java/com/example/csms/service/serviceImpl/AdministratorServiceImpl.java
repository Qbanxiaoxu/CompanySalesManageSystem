package com.example.csms.service.serviceImpl;


import com.example.csms.bean.Administrator;
import com.example.csms.mapper.AdministratorMapper;
import com.example.csms.service.AdministratorService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdministratorServiceImpl implements AdministratorService {
    @Resource
    private AdministratorMapper administratorMapper;
    public void addAdministrator(Administrator administrator){
        administratorMapper.addAdministrator(administrator);
    }

    public void deleteAdministrator(int administratorId){
        administratorMapper.deleteAdministrator(administratorId);
    }

    public Administrator findAdministratorById(int administratorId){
        return administratorMapper.findAdministratorById(administratorId);
    }
    public Administrator verifyAdministrator(String username, String password){
        return administratorMapper.findAdministrator(username,password);
    }

    public void modifyAdministrator(Administrator administrator){
        administratorMapper.modifyAdministrator(administrator);
    }

    public List<Administrator> queryAdministrators(){
        return administratorMapper.queryAdministrators();
    }
}
