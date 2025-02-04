package com.vouchers.dtos;

import com.vouchers.models.VoucherStatus;
import com.vouchers.models.VoucherType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VoucherResponseDTO(BigDecimal balance, String code, String description,
                                 LocalDateTime expirationDate, VoucherType type, VoucherStatus status) {
}
