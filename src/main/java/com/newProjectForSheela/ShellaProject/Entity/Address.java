package com.newProjectForSheela.ShellaProject.Entity;

import com.newProjectForSheela.ShellaProject.Dto.AddressDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
    @Column(name = "House.No")
    private Long houseNumber;
    @Column(name = "Street")
    private String street;
    @Column(name = "City")
    private String city;
    @Column(name = "State")
    private String state;
    @Column(name = "Country")
    private String country;
    @Column(name = "PinCode")
    private Long pinCode;



}
