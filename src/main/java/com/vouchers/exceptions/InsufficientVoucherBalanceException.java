package com.vouchers.exceptions;

public class InsufficientVoucherBalanceException extends ApplicationException {

    public InsufficientVoucherBalanceException(String code, String description) {
        super(code, description);
    }
}
