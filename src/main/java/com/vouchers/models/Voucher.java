package com.vouchers.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "vouchers")
public class Voucher {

    @Id
    private String id;

    private BigDecimal value;

    private BigDecimal balance;

    private LocalDateTime createdAt;

    private boolean isUsable;

    private String code;

    private LocalDateTime expirationDate;

    private VoucherType type;

    private VoucherStatus status;

    private String description;

    private int usages;


}
