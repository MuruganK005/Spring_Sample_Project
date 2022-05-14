package com.newProjectForSheela.ShellaProject.Repository;

import com.newProjectForSheela.ShellaProject.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
