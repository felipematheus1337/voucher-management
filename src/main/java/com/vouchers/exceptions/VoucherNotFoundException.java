package com.vouchers.exceptions;

public class VoucherNotFoundException extends ApplicationException {

    public VoucherNotFoundException(String code, String description) {
        super(code, description);
    }
}
