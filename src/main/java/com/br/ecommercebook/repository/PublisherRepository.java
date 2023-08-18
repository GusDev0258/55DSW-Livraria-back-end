package com.br.ecommercebook.repository;

import com.br.ecommercebook.entity.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long>{
}
