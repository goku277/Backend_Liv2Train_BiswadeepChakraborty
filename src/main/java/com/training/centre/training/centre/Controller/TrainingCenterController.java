package com.training.centre.training.centre.Controller;
import com.training.centre.training.centre.Entity.Training;
import com.training.centre.training.centre.Model.DAO.TrainingDao;
import com.training.centre.training.centre.Model.DTO.ErrorResponseHandler;
import com.training.centre.training.centre.Repo.TrainingCenterRepo;
import com.training.centre.training.centre.Services.Training_CenterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.Set;

@RestController
@RequestMapping("/training/")
public class TrainingCenterController {
    @Autowired
    Training_CenterServices training_centreServices;
    @Autowired
    ErrorResponseHandler errorResponseHandler;
    @Autowired
    TrainingCenterRepo trainingCenterRepo;
    Set<String> fieldSet;
    private String fields="";
    private boolean nullBug;

    /**
     * @param training_centre
     * @param errors
     * @return
     *
     * Before entering to the service layer, the validation is done in the saveTrainingCenter()
     * if-else construct has been used here to create the error messages, to be sent to the
     * client-side for displaying the relevant error messages.
     *
     * if-else are constructed here in order to fetch the in-validated values and to
     * further process them and to generate custom and system generated Spring Exception Handling
     *
     * Also the spring Exception handler annotation is used here, for NumberFormatException,
     * InputMismatchException, Custom_Exception_Handler (ErrorResponseHandler)
     *
     * NullPointerException is avoided to meet the instruction's requirements.
     *
     * Errors class is linked the spring validation, so in the TrainingDAO whichever fields
     * are validated with the validation annotations, can trace errors in each fields, in case
     * any field is invalidated so the field name, and the error_response_message is formed using the
     * if-else constructs.
     */


    @PostMapping("save/")
    public ResponseEntity<?> saveTrainingCenter(@Valid @RequestBody TrainingDao training_centre, Errors errors) {
        System.out.println("Training_Centre : " + training_centre.toString());
        if (training_centre.isTrainingDAOEmpty()) {
            System.out.println("------- training_centre.isTrainingDAOEmpty() -------" + training_centre.isTrainingDAOEmpty());
            return training_centreServices.save(training_centre, true);
        }

        // Checking if the user input is provided for the createdOn, then
        // disabling the createdOn and then setting up the System generated time

        if (String.valueOf(training_centre.getCreatedOn())!= null) {
            training_centre.setCreatedOn(System.currentTimeMillis());
        }
        if (errors.hasErrors()) {
            fieldSet= new LinkedHashSet<>();
            System.out.println("Errors are : " + errors.getFieldErrors());
            for (FieldError error : errors.getFieldErrors()) {
                String strError= error.toString();
                if (strError.contains("centreName")) {
                    if (strError.contains("rejected value [null]")) {
                        fieldSet.add("centreName IS NULL");
                    }
                    if (strError.contains("rejected value []")) {
                        fieldSet.add("centreName IS EMPTY");
                    }
                    else {
                        fieldSet.add("centreName IS NOT VALID");
                    }
                }
                if (strError.contains("centreCode")) {
                    if (strError.contains("rejected value [null]")) {
                        fieldSet.add("centreCode IS NULL");
                    }
                    if (strError.contains("rejected value []")) {
                        fieldSet.add("centreCode IS EMPTY");
                    }
                    if (strError.contains("rejected value []")) {
                        fieldSet.add("centreCode IS EMPTY");
                    }
                    else {
                        fieldSet.add("centreCode IS NOT VALID");
                    }
                }
                if (strError.contains("contactEmail")) {
                    if (strError.contains("rejected value [null]")) {
                        fieldSet.add("contactEmail IS NULL");
                    }
                    if (strError.contains("rejected value []")) {
                        fieldSet.add("contactEmail IS EMPTY");
                    }
                    else {
                        fieldSet.add("contactEmail IS NOT VALID");
                    }
                }
                if (strError.contains("contactPhone")) {
                    if (strError.contains("rejected value [null]")) {
                        fieldSet.add("contactPhone IS NULL");
                    }
                    if (strError.contains("rejected value []")) {
                        fieldSet.add("contactPhone IS EMPTY");
                    }
                    else {
                        fieldSet.add("contactPhone IS NOT VALID");
                    }
                }
            }
            System.out.println("fieldSet : " + fieldSet);
            for (String s : fieldSet) {
                if (!s.trim().isEmpty()) {
                    fields += " " + s;
                }
            }
            errorResponseHandler = new ErrorResponseHandler(400, "400 BAD REQUEST", fields);
            System.out.println("errorResponseHandler : " + errorResponseHandler);
            fields="";
            return ResponseEntity.status(400).body(errorResponseHandler);
        }
        //if the validation is successful, ie. no error has come up then,
        //calling the service layer
        return training_centreServices.save(training_centre);
    }

    /**
     * @return
     * Retrieve all the stored training centers,
     * in ascending order of all the training centers.
     */

    @GetMapping("/retrieve/all")
    public ResponseEntity<?> retrieveAll() {
        return training_centreServices.retrieveAll();
    }

    /**
     * Filter
     * Filter feature contains pagination, offset, filter by training_center_name,
     * Filter by training_center_id.
     */
    @GetMapping("paginated/{dataLimit}")
    public ResponseEntity<?> pagination(@PathVariable(value = "dataLimit") Long dataLimit) {
        return training_centreServices.paginated(dataLimit);
    }

    @GetMapping("offset/{offset}/{limit}")
    public ResponseEntity<?> offset(@PathVariable(value = "offset") Long offset,
                                    @PathVariable(value = "limit") Long limit) {
        return training_centreServices.offset(offset,limit);
    }

    @GetMapping("center/{trainingName}")
    public ResponseEntity<?> findByTrainingCenterName(@PathVariable(value = "trainingName") String trainingName) {
        return training_centreServices.findByTrainingCenterName(trainingName);
    }

    @GetMapping("centerId/{id}")
    public ResponseEntity<?> findByTrainingCenterId(@PathVariable(value = "id") long id) {
        System.out.println("trainingId is : " + id);
        return training_centreServices.findByTrainingCenterId(id);
    }

    /**
     * @return
     * Exception Handling starts from here
     */

    @ExceptionHandler(value = ErrorResponseHandler.class)
    public ResponseEntity<?> ThrowException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @ExceptionHandler(value = NumberFormatException.class)
    public ResponseEntity<?> CheckNumberFormat(Model m) {
        m.addAttribute("msg", "Number format exception has occurred");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(m);
    }
    @ExceptionHandler(value = InputMismatchException.class)
    public ResponseEntity<?> CheckInputMismatch(Model m) {
        m.addAttribute("msg", "Input Mismatch Exception has occurred");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(m);
    }
    @ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<?> CheckArrayIndexOutOfBoundsException(Model m) {
        m.addAttribute("msg", "Array Index Out Of Bounds Exception");
        return ResponseEntity.status(HttpStatus.FOUND).body(m);
    }
}