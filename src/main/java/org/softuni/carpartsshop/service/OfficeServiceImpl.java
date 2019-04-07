package org.softuni.carpartsshop.service;


import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.domain.entites.Office;
import org.softuni.carpartsshop.domain.models.service.OfficeServiceModel;
import org.softuni.carpartsshop.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.softuni.carpartsshop.config.Constant;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OfficeServiceImpl(OfficeRepository officeRepository, ModelMapper modelMapper) {

        this.officeRepository = officeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String addOffice(OfficeServiceModel model) {
        String result;


        Office office = this.modelMapper.map(model, Office.class);
        office = this.officeRepository.saveAndFlush(office);
        result = office.getId();


        return result;
    }

    @Override
    public OfficeServiceModel editOffice(OfficeServiceModel model) {
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


}
