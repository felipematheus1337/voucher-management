package com.vouchers.scheduling;


import com.vouchers.repositories.VoucherRepository;
import com.vouchers.services.VoucherService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class VoucherScheduled {

    private final VoucherService voucherService;

    public VoucherScheduled(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void verifyVouchersStatus() throws ExecutionException, InterruptedException {

        this.voucherService.verifyVouchers();

    }
}
