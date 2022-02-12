package com.training.centre.training.centre.Converter;

import com.training.centre.training.centre.Entity.Address;
import com.training.centre.training.centre.Entity.Training;
import com.training.centre.training.centre.Model.DAO.TrainingDao;
import com.training.centre.training.centre.Model.DTO.TrainingDto;
import org.springframework.stereotype.Component;

@Component
public class DAOToEntity {
    public Training DAOToEntity(TrainingDao trainingDao) {
        Training training= new Training();
        Address address= new Address();
        address.setPinCode(trainingDao.getAddress().getPinCode());
        address.setCity(trainingDao.getAddress().getCity());
        address.setState(trainingDao.getAddress().getState());
        address.setDetailedAddress(trainingDao.getAddress().getDetailedAddress());
        training.setAddress(address);
        training.setCentreCode(trainingDao.getCentreCode());
        training.setCentreName(trainingDao.getCentreName());
        training.setContactEmail(trainingDao.getContactEmail());
        training.setContactPhone(trainingDao.getContactPhone());
        training.setCreatedOn(trainingDao.getCreatedOn());
        training.setCoursesOffered(trainingDao.getCoursesOffered());
        training.setStudentCapacity(Long.valueOf(trainingDao.getStudentCapacity()));
        return training;
    }
}