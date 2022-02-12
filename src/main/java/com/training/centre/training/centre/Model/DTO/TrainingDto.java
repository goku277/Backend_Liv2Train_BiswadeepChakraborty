package com.training.centre.training.centre.Model.DTO;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
@Data

/**
 * TrainingDto model is the response model
 * which is sent from the service layer to the controller
 * then from controller to the client-side, after
 * being populated in the converter package
 */
public class TrainingDto {
    private String centreName;
    private String centreCode;
    private AddressDTO address;
    private long studentCapacity;
    private List<String> coursesOffered;
    private long createdOn;
    private String contactEmail;
    private String contactPhone;
}