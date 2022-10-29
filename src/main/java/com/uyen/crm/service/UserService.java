package com.uyen.crm.service;

import com.uyen.crm.model.Users;
import com.uyen.crm.repository.UsersRepository;

import java.util.List;

public class UserService {
    UsersRepository usersRepository = new UsersRepository();
    public List<Users> getAllUsers(){
        return usersRepository.getUsers();
    }
}
