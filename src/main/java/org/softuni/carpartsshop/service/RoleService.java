package org.softuni.carpartsshop.service;

import org.softuni.carpartsshop.domain.models.service.RoleServiceModel;


import java.util.Set;

public interface RoleService {

    void seedRolesInDb();

//    void assignUserRoles(UserServiceModel userServiceModel, long numberOfUsers);

    Set<RoleServiceModel> findAllRoles();

    RoleServiceModel findByAuthority(String authority);

}
