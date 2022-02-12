package com.training.centre.training.centre.Converter;

import com.training.centre.training.centre.Entity.Address;
import com.training.centre.training.centre.Entity.Training;
import com.training.centre.training.centre.Model.DAO.AddressDAO;
import com.training.centre.training.centre.Model.DAO.TrainingDao;
import org.springframework.stereotype.Component;

@Component
public class EntityToDAO {
    public Address EntityToDAO(AddressDAO addressDAO) {
        Address address= new Address();
        address.setDetailedAddress(addressDAO.getDetailedAddress());
        address.setCity(addressDAO.getCity());
        address.setState(addressDAO.getState());
        address.setPinCode(addressDAO.getPinCode());
        return address;
    }
}