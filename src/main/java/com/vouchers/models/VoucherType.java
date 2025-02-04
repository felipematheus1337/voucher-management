package com.vouchers.models;

public enum VoucherType {

    BASIC(2), PREMIUM(5);

    private final int expirationMonth;


    VoucherType(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationMonths() {
        return expirationMonth;
    }
}
