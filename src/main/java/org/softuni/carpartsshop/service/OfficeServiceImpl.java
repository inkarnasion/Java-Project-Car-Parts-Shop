package org.softuni.carpartsshop.service;


import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.domain.entites.Office;
import org.softuni.carpartsshop.domain.models.service.OfficeServiceModel;
import org.softuni.carpartsshop.domain.models.view.OfficeViewModel;
import org.softuni.carpartsshop.repository.OfficeRepository;
import org.softuni.carpartsshop.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.softuni.carpartsshop.config.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public OfficeServiceImpl(OfficeRepository officeRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {

        this.officeRepository = officeRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public String addOffice(OfficeServiceModel model) {
        if (!this.validationUtil.isValid(model)) {
            throw new IllegalArgumentException(Constant.TRYING_TO_ADD_INVALID_DATA);
        }
        String result;


        Office office = this.modelMapper.map(model, Office.class);
        String officeAddress = office.getAddress();

        if (this.officeRepository.findByAddress(officeAddress).orElse(null) != null) {
            throw new IllegalArgumentException(Constant.OFFICE_WITH_THIS_DATA_ALREADY_EXIST);
        }
        office = this.officeRepository.saveAndFlush(office);
        result = office.getId();


        return result;
    }

    @Override
    public OfficeServiceModel editOffice(OfficeServiceModel model) {
        if (!this.validationUtil.isValid(model)) {
            throw new IllegalArgumentException(Constant.THERE_IS_OFFICE_WITH_SAME_DATA);
        }
        Office office = this.officeRepository.findById(model.getId()).orElseThrow(() -> new NoSuchElementException(Constant.ERROR_MESSAGE));


        Office officeNew = this.modelMapper.map(model, Office.class);


        Office mappedOffice = this.officeRepository.saveAndFlush(officeNew);

        model = this.modelMapper.map(mappedOffice, OfficeServiceModel.class);

        return model;
    }

    @Override
    public List<OfficeServiceModel> findAllOffices() {
        List<Office> offices = this.officeRepository.findAll();

        List<OfficeServiceModel> officesModel = offices.stream().map(o -> this.modelMapper.map(o, OfficeServiceModel.class)).collect(Collectors.toList());

        return officesModel;
    }

    @Override
    public OfficeServiceModel findOfficeByID(String id) {
        Office office = this.officeRepository.findById(id).orElseThrow(() -> new NoSuchElementException(Constant.ERROR_MESSAGE));
        OfficeServiceModel model = this.modelMapper.map(office, OfficeServiceModel.class);

        return model;
    }

    @Override
    public OfficeServiceModel deleteOffice(OfficeServiceModel model) {
        Office office = this.officeRepository.findById(model.getId()).orElseThrow(() -> new NoSuchElementException(Constant.ERROR_MESSAGE));


         this.officeRepository.delete(office);


        return model;
    }

    @Override
    public List<OfficeViewModel> allOfficeAddresses(List<OfficeServiceModel> offices) {
        List<OfficeViewModel> result =new ArrayList<>();
        for (OfficeServiceModel m:offices) {
            OfficeViewModel officeViewModel=new OfficeViewModel();
            officeViewModel.setId(m.getId());
            officeViewModel.setAddress(m.getAddress());

            result.add(officeViewModel);

        }

        return result;
    }


}
