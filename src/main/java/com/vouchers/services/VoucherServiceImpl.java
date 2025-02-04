package com.vouchers.services;

import com.vouchers.dtos.UsedVoucherResponseDTO;
import com.vouchers.dtos.VoucherCreationDTO;
import com.vouchers.dtos.VoucherResponseDTO;
import com.vouchers.models.Voucher;
import com.vouchers.models.VoucherStatus;
import com.vouchers.models.VoucherType;
import com.vouchers.repositories.VoucherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class VoucherServiceImpl implements VoucherService {

    private final VoucherRepository repository;
    private final ModelMapper mapper;
    private final MongoTemplate mongoTemplate;

    public VoucherServiceImpl(VoucherRepository repository, ModelMapper modelMapper, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mapper = modelMapper;
        this.mongoTemplate = mongoTemplate;
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

        return mapper.map(response, VoucherResponseDTO.class);
    }


    @Override
    public List<VoucherResponseDTO> list() {
        return repository.findAll()
                .stream()
                .map(v -> mapper.map(v, VoucherResponseDTO.class))
                .toList();

    }

    @Override
    public VoucherResponseDTO getByCode(String code) {
        var voucher = this.repository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Voucher not found with the code: " + code));

        return this.mapper.map(voucher, VoucherResponseDTO.class);

    }

    @Override
    public List<VoucherResponseDTO> getByType(String type) {
        return this.repository.findByType(type)
                .stream()
                .map(v -> mapper.map(v, VoucherResponseDTO.class))
                .toList();

    }

    @Override
    public List<VoucherResponseDTO> getByStatus(String status) {
       Query query = new Query(Criteria.where("status").is(status));
       List<Voucher> vouchers = mongoTemplate.find(query, Voucher.class);
       return vouchers.stream()
               .map(v -> mapper.map(v,VoucherResponseDTO.class))
               .toList();
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

    private LocalDateTime setExpirationDate(VoucherType type) {
        LocalDateTime actualTime = LocalDateTime.now();

        return actualTime.plusMonths(type.getExpirationMonths());
    }

    private String generateVoucherCode() {
        UUID uuid = UUID.randomUUID();
        return "VOUCHER-" + uuid.toString().substring(0, 8).toUpperCase();
    }
}
