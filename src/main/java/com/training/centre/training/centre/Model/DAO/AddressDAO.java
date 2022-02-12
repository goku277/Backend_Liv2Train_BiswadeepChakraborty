package com.training.centre.training.centre.Model.DAO;
import lombok.Data;
import org.springframework.stereotype.Component;
@Component
@Data

/**
 *  AddressDAO serves as the request body, or even input to the
 *  setters and getters method which ever been used in the service class,
 *  during the conversion from Entity to Dao , vice-versa, Entity to DTO, vice-versa
 */
public class AddressDAO {
    private String detailedAddress;
    private String city;
    private String state;
    private String pinCode;
}