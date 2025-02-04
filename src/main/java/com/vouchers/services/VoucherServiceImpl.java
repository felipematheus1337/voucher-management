package com.vouchers.services;

import com.vouchers.dtos.VoucherCreationDTO;
import com.vouchers.dtos.VoucherResponseDTO;
import com.vouchers.repositories.VoucherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherServiceImpl implements VoucherService {

    private final VoucherRepository repository;

    public VoucherServiceImpl(VoucherRepository repository) {
        this.repository = repository;
    }

    @Override
    public VoucherResponseDTO create(VoucherCreationDTO dto) {
        return null;
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
