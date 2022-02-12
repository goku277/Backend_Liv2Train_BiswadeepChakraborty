package com.training.centre.training.centre.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;
import javax.persistence.*;
import java.util.List;
@Table(name = "training_centre")
@Entity
@Data
@ToString

/**
 *  Training Entity, which contains all the required fields
 *  which will be saved in the database, postgresql
 *  These fields are served as columns, in the db
 */
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "training_centre_id")
    private long trainingCentreId;
    private String centreName;
    private String centreCode;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    @JsonBackReference
    private Address address;
    private long studentCapacity;
    @ElementCollection(targetClass=String.class)
    private List<String> coursesOffered;
    private long createdOn= System.currentTimeMillis();
    private String contactEmail;
    private String contactPhone;
}