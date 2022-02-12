package com.training.centre.training.centre.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.validator.internal.properties.Getter;

import javax.persistence.*;

@Table(name = "address_table")
@Entity
@Data
@ToString

/**
 *  Address is an entity with these different fields as columns
 *  having one-to-one relational mapping with the Training Entity
 */

public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long addressId;
    private String detailedAddress;
    private String city;
    private String state;
    private String pinCode;
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Training training;
}