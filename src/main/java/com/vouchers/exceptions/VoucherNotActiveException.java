package com.vouchers.exceptions;

public class VoucherNotActiveException extends ApplicationException {

    public VoucherNotActiveException(String code, String description) {
        super(code, description);
    }
}
