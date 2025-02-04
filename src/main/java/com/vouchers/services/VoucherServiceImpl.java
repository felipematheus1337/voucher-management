package com.vouchers.services;

import com.vouchers.dtos.UsedVoucherResponseDTO;
import com.vouchers.dtos.VoucherCreationDTO;
import com.vouchers.dtos.VoucherResponseDTO;
import com.vouchers.models.Voucher;
import com.vouchers.models.VoucherStatus;
import com.vouchers.models.VoucherType;
import com.vouchers.repositories.VoucherRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
        voucher.setCode(this.generateVoucherCode());

        voucher.setDescription(dto.description());
        voucher.setType(dto.type());
        voucher.setStatus(VoucherStatus.ACTIVE);

        voucher.setUsable(true);
        voucher.setValue(BigDecimal.ZERO);
        voucher.setUsages(0);

        LocalDateTime expirationDate = this.setExpirationDate(voucher.getType());
        voucher.setExpirationDate(expirationDate);

        var response = repository.save(voucher);

        return new VoucherResponseDTO(
                response.getBalance(),
                response.getCode(),
                response.getDescription(),
                response.getExpirationDate(),
                response.getType(),
                response.getStatus()
        );
    }

    private LocalDateTime setExpirationDate(VoucherType type) {
        LocalDateTime actualTime = LocalDateTime.now();

        return actualTime.plusMonths(type.getExpirationMonths());
    }

    private String generateVoucherCode() {
        UUID uuid = UUID.randomUUID();
        return "VOUCHER-" + uuid.toString().substring(0, 8).toUpperCase();
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

    @Override
    public List<VoucherResponseDTO> getByType(VoucherType type) {
        return List.of();
    }

    @Override
    public List<VoucherResponseDTO> getByStatus(VoucherStatus status) {
        return List.of();
    }

    @Override
    public Page<VoucherResponseDTO> getPaginado(Pageable pageable) {
        return null;
    }

    @Override
    public void createInLote(List<VoucherCreationDTO> vouchers) {

    }

    @Override
    public UsedVoucherResponseDTO use(String code) {
        return null;
    }
}
