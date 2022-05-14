package com.newProjectForSheela.ShellaProject.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long addressId;
    private Long houseNumber;
    private String street;
    private String city;
    private String state;
    private String country;
    private Long pinCode;

    public AddressDto(Boolean True, String DeleteStatus, HttpStatus ok) {

    }
}
