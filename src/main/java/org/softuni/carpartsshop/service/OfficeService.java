package org.softuni.carpartsshop.service;


import org.softuni.carpartsshop.domain.models.service.OfficeServiceModel;

import java.util.List;

public interface OfficeService {

	String addOffice(OfficeServiceModel model);

	OfficeServiceModel editOffice(OfficeServiceModel model);

	List<OfficeServiceModel> findAllOffices();

	OfficeServiceModel findOfficeByID(String id);

	void deleteOffice(OfficeServiceModel model);

}
