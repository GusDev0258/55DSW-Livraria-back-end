package com.br.ecommercebook.repository;

import com.br.ecommercebook.entity.Voucher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VoucherRepository extends CrudRepository<Voucher, Long>{
}
