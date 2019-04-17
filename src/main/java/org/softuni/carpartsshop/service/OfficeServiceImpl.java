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
            throw new IllegalArgumentException("Trying to add invalid data!");
        }
        String result;


        Office office = this.modelMapper.map(model, Office.class);

        if (office != null) {
            throw new IllegalArgumentException("Office already exists");
        }
        office = this.officeRepository.saveAndFlush(office);
        result = office.getId();


        return result;
    }

    @Override
    public OfficeServiceModel editOffice(OfficeServiceModel model) {
        if (!this.validationUtil.isValid(model)) {
            throw new IllegalArgumentException("There is office with same data!");
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
    public void deleteOffice(OfficeServiceModel model) {
        Office office = this.officeRepository.findById(model.getId()).orElseThrow(() -> new NoSuchElementException(Constant.ERROR_MESSAGE));


         this.officeRepository.delete(office);


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
