package com.br.ecommercebook.repository;

import com.br.luminous.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface AddressRepository extends CrudRepository<Address, Long> {
    @Override
    List<Address> findAll();

    Optional <List<Address>> findByUserId(Long userId);
}
