package com.vouchers.repositories;

import com.vouchers.models.Voucher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface VoucherRepository extends MongoRepository<Voucher, String> {


    @Query("{ 'type': ?0 }")
    List<Voucher> findByType(String type);

    @Query("{ 'code': ?0 }")
    Optional<Voucher> findByCode(String code);
}
