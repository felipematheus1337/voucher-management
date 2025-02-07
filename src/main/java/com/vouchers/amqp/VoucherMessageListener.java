package com.vouchers.amqp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vouchers.dtos.VoucherCreationDTO;
import com.vouchers.services.VoucherService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VoucherMessageListener {

    private final ObjectMapper objectMapper;
    private final VoucherService service;

    public VoucherMessageListener(ObjectMapper objectMapper, VoucherService service) {
        this.objectMapper = objectMapper;
        this.service = service;
    }

    @KafkaListener
    public void createVoucherInLoteListener(@Payload String message) throws JsonProcessingException {

        List<VoucherCreationDTO> vouchers = objectMapper.readValue(message, new TypeReference<List<VoucherCreationDTO>>(){});

        this.service.saveInLote(vouchers);

    }
}
