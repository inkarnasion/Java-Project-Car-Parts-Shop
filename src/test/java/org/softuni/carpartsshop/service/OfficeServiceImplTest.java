package org.softuni.carpartsshop.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.config.Constant;
import org.softuni.carpartsshop.domain.models.service.OfficeServiceModel;
import org.softuni.carpartsshop.repository.OfficeRepository;
import org.softuni.carpartsshop.utils.ValidationUtil;
import org.softuni.carpartsshop.utils.ValidationUtilImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class OfficeServiceImplTest {
	public static final String ERROR_MESSAGE = "Can not add office with same name!";
	public static final String ERROR_EDIT_MESSAGE = "Can not edit office with empty fields!";
	public static final String INVALID_PHONE_NUMBER = "Phone number must be between 7 and 12 lenght!";
	public static final String DELETE_OFFICE_MESSAGE = "Office no exist! Can not be deleted!";

	private ModelMapper modelMapper;
	private ValidationUtil validationUtil;
	private OfficeService officeService;

	@Autowired
	private OfficeRepository officeRepository;

	@Before
	public void before() {
		this.validationUtil = new ValidationUtilImpl();
		this.modelMapper = new ModelMapper();
		this.officeService = new OfficeServiceImpl(this.officeRepository, this.modelMapper, this.validationUtil);
	}

	@Test
	public void addOffice() {

		OfficeServiceModel o = getOfficeServiceModel();

		String actualId = this.officeService.addOffice(o);

		OfficeServiceModel expected = this.officeService.findOfficeByID(actualId);

		assertEquals(expected.getId(), actualId);

	}

	@Test
	public void editOffice() {
		OfficeServiceModel o = getOfficeServiceModel();
		String actualId = this.officeService.addOffice(o);

		OfficeServiceModel toBeEdited = this.officeService.findOfficeByID(actualId);
		toBeEdited.setCity("");
		OfficeServiceModel actual = this.officeService.editOffice(toBeEdited);
		OfficeServiceModel expected = this.officeService.findOfficeByID(actual.getId());

		assertEquals(expected.getId(),actual);
	}

	@Test
	public void findAllOffices() {
		OfficeServiceModel officeServiceModel = getOfficeServiceModel();
		 String actualId = this.officeService.addOffice(officeServiceModel);

		int expected = this.officeService.findAllOffices().size();

		assertEquals(1,expected);
	}

	@Test
	public void findOfficeByID() {

		OfficeServiceModel officeServiceModel = getOfficeServiceModel();
		String actualId = this.officeService.addOffice(officeServiceModel);

		OfficeServiceModel expected = this.officeService.findOfficeByID(actualId);

		assertEquals(expected.getId(),actualId);
	}

	@Test
	public void deleteOffice() {
		OfficeServiceModel officeServiceModel = getOfficeServiceModel();
		String actualId = this.officeService.addOffice(officeServiceModel);

		OfficeServiceModel expected = this.officeService.deleteOffice(officeServiceModel);

		assertEquals(expected.getId(),actualId);
	}

	@Test
	public void allOfficeAddresses() {
	}

	private OfficeServiceModel getOfficeServiceModel() {

		OfficeServiceModel testOffice = new OfficeServiceModel();

		testOffice.setCity("Sofia");
		testOffice.setAddress("Nadejda-2");
		testOffice.setPhoneNumber("0898630433");
		testOffice.setEmail("valid@abv.bg");
		testOffice.setImageUrl("validUrl");

		return testOffice;
	}


}