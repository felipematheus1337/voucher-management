package com.vouchers.services;

import com.vouchers.dtos.VoucherCreationDTO;
import com.vouchers.dtos.VoucherResponseDTO;
import com.vouchers.models.Voucher;
import com.vouchers.models.VoucherStatus;
import com.vouchers.models.VoucherType;
import com.vouchers.repositories.VoucherRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static com.vouchers.models.VoucherType.BASIC;
import static com.vouchers.models.VoucherType.PREMIUM;

@Service
public class VoucherServiceImpl implements VoucherService {

    private final VoucherRepository repository;

    public VoucherServiceImpl(VoucherRepository repository) {
        this.repository = repository;
    }

    @Override
    public VoucherResponseDTO create(VoucherCreationDTO dto) {
        var voucher = new Voucher();

        voucher.setCreatedAt(LocalDateTime.now());
        voucher.setBalance(dto.balance());

        voucher.setCode(dto.code());
        voucher.setDescription(dto.description());
        voucher.setType(dto.type());
        voucher.setStatus(VoucherStatus.ACTIVE);

        voucher.setUsable(true);
        voucher.setValue(BigDecimal.ZERO);
        voucher.setUsages(0);

        LocalDateTime expirationDate = this.setExpirationDate(voucher.getType());
        voucher.setExpirationDate(expirationDate);


        repository.save(voucher);

        return null;
    }

    private LocalDateTime setExpirationDate(VoucherType type) {
        LocalDateTime actualTime = LocalDateTime.now();

        return actualTime.plusMonths(type.getExpirationMonths());
    }

    @Override
    public List<VoucherResponseDTO> list() {
        return repository.findAll()
                .stream()
                .map(v ->
                        new VoucherResponseDTO(v.getBalance(), v.getCode(), v.getDescription(),
                                v.getExpirationDate(), v.getType(), v.getStatus()))
                .toList();
    }
}
