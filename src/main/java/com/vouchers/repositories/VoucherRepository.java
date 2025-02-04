package com.vouchers.repositories;

import com.vouchers.models.Voucher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VoucherRepository extends MongoRepository<Voucher, String> {
}
