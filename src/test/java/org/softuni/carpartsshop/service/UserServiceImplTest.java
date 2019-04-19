package org.softuni.carpartsshop.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.domain.models.service.UserServiceModel;
import org.softuni.carpartsshop.repository.RoleRepository;
import org.softuni.carpartsshop.repository.UserRepository;
import org.softuni.carpartsshop.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)

public class UserServiceImplTest {

    private UserService userService;
    private UserServiceModel testUser;
    private ModelMapper modelMapper;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private RoleService roleService;
    private ValidationUtil validationUtil;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Before
    public void UserServiceImpl() {
        this.modelMapper = new ModelMapper();
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
        this.roleService = new RoleServiceImpl(this.roleRepository, this.modelMapper);
        this.userService = new UserServiceImpl(this.userRepository,this.roleService,this.modelMapper,this.bCryptPasswordEncoder,this.validationUtil);
        this.testUser = createTestUser();
    }

    @Test
    public void registerUser() {
        this.userService.registerUser(testUser);
        long expected = this.userRepository.findAll().size();

        Assert.assertEquals(1, expected);
    }


    @Test
    public void loadUserByUsername() {
        this.userService.registerUser(testUser);
        UserServiceModel expected = this.userService.findUserByUserName(testUser.getUsername());
        Assert.assertEquals(testUser.getUsername(), expected.getUsername());
    }

    @Test
    public void findUserByUserName() {
        this.userService.registerUser(testUser);
        UserServiceModel expected = this.userService.findUserByUserName(testUser.getUsername());

        Assert.assertEquals(testUser.getUsername(), expected.getUsername());
    }

    @Test
    public void editUserProfile() {
        this.userService.editUserProfile();
    }

    @Test
    public void findAllUsers() {
        this.userService.registerUser(testUser);
        long expected = this.userService.findAllUsers().size();

        Assert.assertEquals(1, expected);
    }


    private UserServiceModel createTestUser() {

        UserServiceModel testUser = new UserServiceModel();
        testUser.setUsername("aaaaaa");
        testUser.setPassword("1234567");
        testUser.setEmail("valid@mail.com");
        testUser.setFirstName("ivanka");
        testUser.setLastName("ivankova");
        testUser.setPhoneNumber("1234567890");
        testUser.setCreditCardNumber("12345678910");

        return testUser;
    }

}
