package com.br.ecommercebook.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.ecommercebook.entity.Voucher;
import org.springframework.stereotype.Repository;
@Repository
public interface VoucherRepository extends CrudRepository<Voucher, Long>{
}
