package com.vouchers.rest;


import com.vouchers.dtos.VoucherCreationDTO;
import com.vouchers.dtos.VoucherResponseDTO;
import com.vouchers.services.VoucherService;
import org.apache.coyote.Response;
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
    public ResponseEntity<List<VoucherResponseDTO>> listar() {
        return ResponseEntity.ok(voucherService.list());
    }
}
