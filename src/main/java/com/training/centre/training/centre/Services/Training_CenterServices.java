package com.training.centre.training.centre.Services;
import com.training.centre.training.centre.Converter.DAOToEntity;
import com.training.centre.training.centre.Converter.EntityToDAO;
import com.training.centre.training.centre.Converter.EntityToDTO;
import com.training.centre.training.centre.Entity.Address;
import com.training.centre.training.centre.Entity.Training;
import com.training.centre.training.centre.Model.DAO.TrainingDao;
import com.training.centre.training.centre.Model.DTO.ErrorResponseHandler;
import com.training.centre.training.centre.Model.DTO.TRAINING_DTO;
import com.training.centre.training.centre.Repo.TrainingCenterRepo;
import lombok.Lombok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Training_CenterServices {
    @Autowired
    TrainingCenterRepo trainingCenterRepo;
    @Autowired
    DAOToEntity daoToEntity;
    @Autowired
    EntityToDTO entityToDTO;
    @Autowired
    EntityToDAO entityToDAO;

    /**
     * @param training
     * @return
     *
     * save() method to save the Training centers, with the necessary non-empty fields
     */
    public ResponseEntity<?> save(TrainingDao training) {
        Training trainingCentre1= new Training();
        trainingCentre1.setAddress(entityToDAO.EntityToDAO(training.getAddress()));
        trainingCentre1= trainingCenterRepo.save(daoToEntity.DAOToEntity(training));
        long Id= trainingCentre1.getAddress().getAddressId();
        return ResponseEntity.status(HttpStatus.OK).body(entityToDTO.EntityToDTO(trainingCentre1, Id));
    }

    /**
     * @return
     * retrieveALl() method to retrieve all the saved training centers
     * from the db, including empty training centers list and display
     * as json array.
     */

    public ResponseEntity<?> retrieveAll() {
        List<Training> trainingSet= trainingCenterRepo.findAll(Sort.by("trainingCentreId").ascending());
        List<TRAINING_DTO> trainingDtoList= new ArrayList<>();
        long Id=0;
        for (Training training : trainingSet) {
            if (training.getAddress()!=null) {
                Id = training.getAddress().getAddressId();
                trainingDtoList.add(entityToDTO.EntityTo_DTO(training, Id));
            }
            else {
                trainingDtoList.add(entityToDTO.EntityTo_DTO(training));
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(trainingDtoList);
    }

    /**
     * @param training_centre
     * @param b
     * @return
     * save() method to save any empty training list
     */

    public ResponseEntity<?> save(TrainingDao training_centre, boolean b) {
        Training training= new Training();
        training= trainingCenterRepo.save(training);
        return ResponseEntity.status(HttpStatus.OK).body(training);
    }

    /**
     * @param dataLimit
     * @return
     * Filter features implementation starts from here
     */

    public ResponseEntity<?> paginated(Long dataLimit) {
        List<Training> trainingList= trainingCenterRepo.findAll();
        List<Training> paginated= new ArrayList<>();
        long count=0;
        for (Training training : trainingList) {
            paginated.add(training);
            count++;
            if (count==dataLimit) break;
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(entityToDTO.EntityTO_DTOList(paginated));
    }

    /**
     * @param offset
     * @param limit
     * @return
     *
     * Based on the starting index and the end index (offset and limit), the filter of the training centers will be displayed
     * to the client's side.
     */

    public ResponseEntity<?> offset(Long offset, Long limit) {
        List<Training> trainingList= trainingCenterRepo.findAll();
        List<Training> paginated= new ArrayList<>();
        long count=0;
        for (Training training : trainingList) {
            count++;
            if (count>=offset) {
                paginated.add(training);
            }
            if (count>=limit) break;
        }
        if (limit < trainingList.size()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(entityToDTO.EntityTO_DTOList(paginated));
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseHandler(404, "HttpStatus.NOT_FOUND", "limit is larger than data table size"));
    }

    /**
     * @param trainingName
     * @return
     * Given a training center name, then this method will retrieve the necessary related data
     * then will be sent to the client's side
     */

    public ResponseEntity<?> findByTrainingCenterName(String trainingName) {
        Training training = trainingCenterRepo.findByCentreName(trainingName);
        return ResponseEntity.status(HttpStatus.FOUND).body(entityToDTO.EntityTo_DTO(training));
    }

    /**
     * @param id
     * @return
     * Given an id, then the data will be fetched from the db
     */

    public ResponseEntity<?> findByTrainingCenterId(long id) {
        System.out.println("training : " + id);
        Training training= trainingCenterRepo.findById(id).orElse(null);
        System.out.println("training : " + training.getCentreName());
        return ResponseEntity.status(HttpStatus.OK).body(entityToDTO.EntityTo_DTO(training));
    }
}