package org.softuni.carpartsshop.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.domain.models.service.RoleServiceModel;
import org.softuni.carpartsshop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RoleServiceImplTest {

    public static final String VALID_ROLE_NAME = "Valid name";
    public static final String INVALID_ROLE_NAME = "Invalid name";
    public static final String ROLE_ERROR_MASSAGE = "Can not delete role, not exist!";
    @Autowired
    private RoleRepository roleRepository;

    private RoleService roleService;

    private ModelMapper modelMapper;

    @Before
    public void init() {
        this.modelMapper = new ModelMapper();
        this.roleService = new RoleServiceImpl(this.roleRepository, this.modelMapper);
        RoleServiceModel r = getRoleServiceModel();
        this.roleService.seedRolesInDb();

    }

    @Test
    public void findAllRoles() {
        Set<RoleServiceModel> allRoles = this.roleService.findAllRoles();
        assertEquals(4, allRoles.size());
    }

    @Test
    public void findByAuthority() {
        RoleServiceModel admin = this.roleService.findByAuthority("ROLE_ADMIN");
        assertEquals("ROLE_ADMIN", admin.getAuthority());
    }

    private RoleServiceModel getRoleServiceModel() {
        RoleServiceModel testRoles = new RoleServiceModel();

        testRoles.setAuthority("Admin");

        return testRoles;
    }
}
