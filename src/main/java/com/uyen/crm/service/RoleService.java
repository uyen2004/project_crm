package com.uyen.crm.service;

import com.uyen.crm.model.Role;
import com.uyen.crm.repository.RoleRepository;

import javax.servlet.http.HttpServlet;
import java.util.List;

public class RoleService extends HttpServlet {
    private RoleRepository roleRepository = new RoleRepository();

    public List<Role> getAllRoles(){
        return roleRepository.getRoles();
    }

    public boolean deleteById(int id){
        int result = roleRepository.deleteRepository(id);
        return  result > 0 ? true : false;
    }

    public Role addRole(int id, String name, String description) {
        return roleRepository.addRole(name, description);
    }
}
