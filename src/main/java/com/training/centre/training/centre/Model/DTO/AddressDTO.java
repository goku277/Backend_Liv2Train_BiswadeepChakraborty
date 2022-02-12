package com.training.centre.training.centre.Model.DTO;
import lombok.Data;
import org.springframework.stereotype.Component;
@Component
@Data
public class AddressDTO {
    private long addressId;
    private String detailedAddress;
    private String city;
    private String state;
    private String pinCode;
}