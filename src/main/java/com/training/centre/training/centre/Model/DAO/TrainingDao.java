package com.training.centre.training.centre.Model.DAO;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import javax.validation.constraints.*;
import java.util.List;
@Component
@Data

/**
 * Here in this TrainingDao,
 * validations are done through the spring mvc annotations
 * like @Pattern, @Length, @NotNull, @Email
 */

public class TrainingDao {
    @Pattern(regexp = "^[A-Za-z0-9\\s+\\_]{1,39}$")
    private String centreName;
    @Length(min=12, max=12)
    @NotNull(message = "Center code should not be null")
    @Pattern(regexp = "^[A-Za-z0-9]+")
    private String centreCode;
    private AddressDAO address;
    @Pattern(regexp = "^[0-9]+$")
    private String studentCapacity;
    private List<String> coursesOffered;
    private long createdOn= System.currentTimeMillis();
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String contactEmail;
    /**
        Different regex expressions to validate phone number with different format.
        String ten_digit_number= "^\\d{10}$";
        String Whitespaces_Dots_or_Hyphens= "^(\\d{3}[- .]?){2}\\d{4}$";
        String phone_number_with_parenthesis= "((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$";
        String phone_number_with_international_prefix= "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$";
     */
    @Pattern(regexp = "^\\d{10}$")
    private String contactPhone;

    /**
     * @return
     * isTrainingDAOEmpty() method is verifying that all the Fields are null
     */

    public boolean isTrainingDAOEmpty() {
       return centreName==null && centreCode==null && address==null && studentCapacity==null
               && contactEmail==null && contactPhone==null && coursesOffered==null;
    }
}