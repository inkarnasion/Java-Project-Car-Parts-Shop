package org.softuni.carpartsshop.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    }


    @Test
    public void seedRolesInDb() {
    }

    @Test
    public void findAllRoles() {
    }

    @Test
    public void findByAuthority() {
    }
}
