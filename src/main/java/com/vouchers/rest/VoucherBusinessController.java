package com.vouchers.rest;


import com.vouchers.dtos.VoucherCreationDTO;
import com.vouchers.dtos.VoucherResponseDTO;
import com.vouchers.exceptions.VoucherNotFoundException;
import com.vouchers.services.VoucherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/voucher")
public class VoucherBusinessController {

    private final VoucherService voucherService;

    VoucherBusinessController(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    @PostMapping("/create")
    public ResponseEntity<VoucherResponseDTO> createVoucher(@RequestBody VoucherCreationDTO dto) {
        var response = voucherService.create(dto);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/listagem")
    public ResponseEntity<List<VoucherResponseDTO>> list() {
        return ResponseEntity.ok(voucherService.list());
    }

    @GetMapping("/listar/status/{status}")
    public ResponseEntity<List<VoucherResponseDTO>> listByStatus(@PathVariable String status) {
        return ResponseEntity.ok(voucherService.getByStatus(status));
    }

    @GetMapping("/listar/tipo/{type}")
    public ResponseEntity<List<VoucherResponseDTO>> listByType(@PathVariable String type) {
        return ResponseEntity.ok(voucherService.getByType(type));
    }

    @GetMapping("/{code}")
    public ResponseEntity<VoucherResponseDTO> getByCode(@PathVariable String code) throws VoucherNotFoundException {
        return ResponseEntity.ok(voucherService.getByCode(code));
    }
}
