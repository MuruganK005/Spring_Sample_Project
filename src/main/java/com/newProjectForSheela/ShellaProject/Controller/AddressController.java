package com.newProjectForSheela.ShellaProject.Controller;

import com.newProjectForSheela.ShellaProject.Dto.AddressDto;
import com.newProjectForSheela.ShellaProject.Entity.Address;
import com.newProjectForSheela.ShellaProject.Service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/getAddress")
    public List<AddressDto> getAllAddress(){
        ModelMapper modelMapper = new ModelMapper();
        return (List<AddressDto>) addressService.getAllAddress()
                .stream()
                .map(address -> modelMapper.map(address,AddressDto.class));
    }
    @GetMapping("/getAddress/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable(name = "id") Long id) throws Com.Team.Creation.demo.Exception.EmployeeException {
        Address post = addressService.getByAddressId(id);
        ModelMapper modelMapper = new ModelMapper();
        AddressDto postResponse = modelMapper.map(post, AddressDto.class);

        return ResponseEntity.ok().body(postResponse);
    }
    @PostMapping("/createAddress")
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto) {
        ModelMapper modelMapper = new ModelMapper();
        Address postRequest = modelMapper.map(addressDto, Address.class);

        Address address = addressService.createAddress(postRequest);

        AddressDto addressDto1 = modelMapper.map(address, AddressDto.class);

        return new ResponseEntity<AddressDto>(addressDto1, HttpStatus.CREATED);
    }
    @PutMapping("/updateAddress/{id}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable long id, @RequestBody AddressDto addressDto) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        Address addressRequest = modelMapper.map(addressDto, Address.class);

        Address address = addressService.updateAddress(id, addressRequest);

        AddressDto addressResponse = modelMapper.map(address, AddressDto.class);

        return ResponseEntity.ok().body(addressResponse);
    }
    @DeleteMapping("/deleteAddress/{id}")
    public ResponseEntity<AddressDto> deleteAddress(@PathVariable(name = "id") Long id) throws Com.Team.Creation.demo.Exception.EmployeeException {
        addressService.deleteAddress(id);
        AddressDto addressDto = new AddressDto(Boolean.TRUE, "Address deleted successfully", HttpStatus.OK);
        return new ResponseEntity<AddressDto>(addressDto, HttpStatus.OK);
    }

}
