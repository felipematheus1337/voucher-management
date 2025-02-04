package com.vouchers.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vouchers.models.VoucherStatus;
import com.vouchers.models.VoucherType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VoucherResponseDTO(BigDecimal balance, String code, String description,
                                 @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime expirationDate, VoucherType type, VoucherStatus status) {
}
