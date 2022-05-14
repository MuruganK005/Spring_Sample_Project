package com.newProjectForSheela.ShellaProject.Service;

import com.newProjectForSheela.ShellaProject.Entity.Address;

import java.util.List;

public interface AddressService {
    public List<Address> getAllAddress();

    public Address createAddress(Address address);

    public Address updateAddress(Long id, Address addressRequest)throws Exception;

   public  void deleteAddress(Long id) throws Com.Team.Creation.demo.Exception.EmployeeException;

    public Address getByAddressId(Long id) throws Com.Team.Creation.demo.Exception.EmployeeException;
}
