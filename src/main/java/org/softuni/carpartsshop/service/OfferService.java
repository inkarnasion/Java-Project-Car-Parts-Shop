package org.softuni.carpartsshop.service;



import org.softuni.carpartsshop.domain.models.service.OfferServiceModel;

import java.util.List;

public interface OfferService {

    List<OfferServiceModel> findAllOffers();
}
