package com.vouchers.services;

import com.vouchers.dtos.UsedVoucherResponseDTO;
import com.vouchers.dtos.VoucherCreationDTO;
import com.vouchers.dtos.VoucherResponseDTO;
import com.vouchers.models.VoucherStatus;
import com.vouchers.models.VoucherType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VoucherService {

    VoucherResponseDTO create(VoucherCreationDTO dto);

    List<VoucherResponseDTO> list();

    List<VoucherResponseDTO> getByType(VoucherType type);

    List<VoucherResponseDTO> getByStatus(VoucherStatus status);

    Page<VoucherResponseDTO> getPaginado(Pageable pageable);

    void createInLote(List<VoucherCreationDTO> vouchers);

    UsedVoucherResponseDTO use(String code);
}
