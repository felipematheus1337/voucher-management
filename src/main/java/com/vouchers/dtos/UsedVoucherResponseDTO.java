package com.vouchers.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vouchers.models.VoucherStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UsedVoucherResponseDTO(BigDecimal balance, String code, VoucherStatus status,
                                     @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime expirationDate) {
}
