package com.newProjectForSheela.ShellaProject.Service;

import Com.Team.Creation.demo.Exception.EmployeeException;
import com.newProjectForSheela.ShellaProject.Entity.Address;
import com.newProjectForSheela.ShellaProject.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<Address> getAllAddress(){
    return addressRepository.findAll();
    }
    @Override
    public Address createAddress(Address address){
        return addressRepository.save(address);
    }
    @Override
    public Address updateAddress(Long id, Address addressRequest)throws Exception{
        Address address=addressRepository.findById(id)
                .orElseThrow(()->new Com.Team.Creation.demo.Exception.EmployeeException(HttpStatus.BAD_REQUEST,"Address Id has Not Found"));
        address.setHouseNumber(addressRequest.getHouseNumber());
        address.setStreet(addressRequest.getStreet());
        address.setCity(addressRequest.getCity());
        address.setState(addressRequest.getState());
        address.setCountry(addressRequest.getCountry());
        address.setAddressId(addressRequest.getAddressId());
        return addressRepository.save(address);
    }
    @Override
    public void deleteAddress(Long id) throws Com.Team.Creation.demo.Exception.EmployeeException {
        Address address=addressRepository.findById(id)
                .orElseThrow(()->new Com.Team.Creation.demo.Exception.EmployeeException(HttpStatus.BAD_REQUEST,"Address ID Not Found"));
                addressRepository.delete(address);
    }
    @Override
    public Address getByAddressId(Long id) throws EmployeeException {
        Optional<Address> address=addressRepository.findById(id);
        if(address.isPresent()){
            return address.get();
        }
        else {
            throw new EmployeeException(HttpStatus.BAD_REQUEST,"Address not Present in Database");
        }

    }


}
