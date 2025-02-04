package com.vouchers.dtos;

import com.vouchers.models.VoucherStatus;
import com.vouchers.models.VoucherType;

import java.math.BigDecimal;

public record VoucherCreationDTO(BigDecimal balance, VoucherType type,
                                String description) {
}
