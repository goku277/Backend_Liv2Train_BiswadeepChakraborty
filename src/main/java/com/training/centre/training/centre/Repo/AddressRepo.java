package com.training.centre.training.centre.Repo;
import com.training.centre.training.centre.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
}