package com.training.centre.training.centre.Converter;
import com.training.centre.training.centre.Entity.Training;
import com.training.centre.training.centre.Model.DTO.AddressDTO;
import com.training.centre.training.centre.Model.DTO.TRAINING_DTO;
import com.training.centre.training.centre.Model.DTO.TrainingDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntityToDTO {
    public TrainingDto EntityToDTO(Training training, long Id) {
        TrainingDto trainingDto= new TrainingDto();
        AddressDTO addressDTO= new AddressDTO();
        addressDTO.setAddressId(Id);
        addressDTO.setDetailedAddress(training.getAddress().getDetailedAddress());
        addressDTO.setCity(training.getAddress().getCity());
        addressDTO.setPinCode(training.getAddress().getPinCode());
        addressDTO.setState(training.getAddress().getState());
        trainingDto.setAddress(addressDTO);
        trainingDto.setCentreCode(training.getCentreCode());
        trainingDto.setCentreName(training.getCentreName());
        trainingDto.setContactEmail(training.getContactEmail());
        trainingDto.setContactPhone(training.getContactPhone());
        trainingDto.setCoursesOffered(training.getCoursesOffered());
        trainingDto.setCreatedOn(training.getCreatedOn());
        trainingDto.setStudentCapacity(training.getStudentCapacity());
        return trainingDto;
    }
    public TRAINING_DTO EntityTo_DTO(Training training, long Id) {
        TRAINING_DTO trainingDto= new TRAINING_DTO();
        trainingDto.setTrainingId(training.getTrainingCentreId());
        AddressDTO addressDTO= new AddressDTO();
        addressDTO.setAddressId(Id);
        addressDTO.setDetailedAddress(training.getAddress().getDetailedAddress());
        addressDTO.setCity(training.getAddress().getCity());
        addressDTO.setPinCode(training.getAddress().getPinCode());
        addressDTO.setState(training.getAddress().getState());
        trainingDto.setAddress(addressDTO);
        trainingDto.setCentreCode(training.getCentreCode());
        trainingDto.setCentreName(training.getCentreName());
        trainingDto.setContactEmail(training.getContactEmail());
        trainingDto.setContactPhone(training.getContactPhone());
        trainingDto.setCoursesOffered(training.getCoursesOffered());
        trainingDto.setCreatedOn(training.getCreatedOn());
        trainingDto.setStudentCapacity(training.getStudentCapacity());
        return trainingDto;
    }

    public TRAINING_DTO EntityTo_DTO(Training training) {
        TRAINING_DTO trainingDto= new TRAINING_DTO();
        trainingDto.setTrainingId(training.getTrainingCentreId());
        AddressDTO addressDTO= new AddressDTO();
        trainingDto.setAddress(addressDTO);
        trainingDto.setCentreCode(training.getCentreCode());
        trainingDto.setCentreName(training.getCentreName());
        trainingDto.setContactEmail(training.getContactEmail());
        trainingDto.setContactPhone(training.getContactPhone());
        trainingDto.setCoursesOffered(training.getCoursesOffered());
        trainingDto.setCreatedOn(training.getCreatedOn());
        trainingDto.setStudentCapacity(training.getStudentCapacity());
        return trainingDto;
    }

    public List<TRAINING_DTO> EntityTO_DTOList(List<Training> training) {
        List<TRAINING_DTO> trainingDtoList= new ArrayList<>();
        for (Training training1 : training) {
            TRAINING_DTO trainingDto= new TRAINING_DTO();
            trainingDto.setTrainingId(training1.getTrainingCentreId());
            AddressDTO addressDTO= new AddressDTO();
            addressDTO.setAddressId(training1.getAddress().getAddressId());
            addressDTO.setDetailedAddress(training1.getAddress().getDetailedAddress());
            addressDTO.setCity(training1.getAddress().getCity());
            addressDTO.setPinCode(training1.getAddress().getPinCode());
            addressDTO.setState(training1.getAddress().getState());
            trainingDto.setAddress(addressDTO);
            trainingDto.setCentreCode(training1.getCentreCode());
            trainingDto.setCentreName(training1.getCentreName());
            trainingDto.setContactEmail(training1.getContactEmail());
            trainingDto.setCoursesOffered(training1.getCoursesOffered());
            trainingDto.setCreatedOn(training1.getCreatedOn());
            trainingDto.setStudentCapacity(training1.getStudentCapacity());
            trainingDto.setContactPhone(training1.getContactPhone());
            trainingDtoList.add(trainingDto);
        }
        return trainingDtoList;
    }
}