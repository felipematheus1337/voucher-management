package com.vouchers.services;

import com.vouchers.dtos.UseVoucherDTO;
import com.vouchers.dtos.UsedVoucherResponseDTO;
import com.vouchers.dtos.VoucherCreationDTO;
import com.vouchers.dtos.VoucherResponseDTO;
import com.vouchers.models.VoucherStatus;
import com.vouchers.models.VoucherType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface VoucherService {

    VoucherResponseDTO create(VoucherCreationDTO dto);

    List<VoucherResponseDTO> list();

    VoucherResponseDTO getByCode(String code);

    List<VoucherResponseDTO> getByType(String type);

    List<VoucherResponseDTO> getByStatus(String status);

    Page<VoucherResponseDTO> getPaginado(int page, int size);

    void createInLote(List<VoucherCreationDTO> vouchers);

    UsedVoucherResponseDTO useVoucher(UseVoucherDTO dto);

    void saveInLote(List<VoucherCreationDTO> vouchers);
}
