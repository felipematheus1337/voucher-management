package com.vouchers.dtos;

public record LoginResponse(String accessToken, Long expiresIn) {
}
