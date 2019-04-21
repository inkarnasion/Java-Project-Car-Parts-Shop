package org.softuni.carpartsshop.service;


import org.softuni.carpartsshop.domain.models.service.OfficeServiceModel;
import org.softuni.carpartsshop.domain.models.view.OfficeViewModel;

import java.util.List;

public interface OfficeService {

	String addOffice(OfficeServiceModel model);

	OfficeServiceModel editOffice(OfficeServiceModel model);

	List<OfficeServiceModel> findAllOffices();

	OfficeServiceModel findOfficeByID(String id);

	OfficeServiceModel deleteOffice(OfficeServiceModel model);

	List<OfficeViewModel> allOfficeAddresses(List<OfficeServiceModel> offices);

}
