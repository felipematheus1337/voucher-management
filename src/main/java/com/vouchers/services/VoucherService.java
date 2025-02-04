package com.vouchers.services;

import com.vouchers.dtos.VoucherCreationDTO;
import com.vouchers.dtos.VoucherResponseDTO;

import java.util.List;

public interface VoucherService {

    VoucherResponseDTO create(VoucherCreationDTO dto);

    List<VoucherResponseDTO> list();
}
