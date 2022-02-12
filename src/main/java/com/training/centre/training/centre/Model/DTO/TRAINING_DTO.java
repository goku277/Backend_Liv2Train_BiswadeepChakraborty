package com.training.centre.training.centre.Model.DTO;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
@Data

/**
 *  Same as Training_Dto class, but this is specifically created to be sent
 *  from the service layer during the GET api Action Call.
 *  Here only trainingId is added
 */

public class TRAINING_DTO {
    private long trainingId;
    private String centreName;
    private String centreCode;
    private AddressDTO address;
    private long studentCapacity;
    private List<String> coursesOffered;
    private long createdOn;
    private String contactEmail;
    private String contactPhone;
}