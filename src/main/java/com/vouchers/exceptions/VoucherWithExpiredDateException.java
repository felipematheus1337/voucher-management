package com.vouchers.exceptions;

public class VoucherWithExpiredDateException extends ApplicationException {

    public VoucherWithExpiredDateException(String code, String description) {
        super(code, description);
    }
}
