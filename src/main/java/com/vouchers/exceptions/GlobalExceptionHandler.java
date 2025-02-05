package com.vouchers.exceptions;


import com.vouchers.dtos.ErrorResponseDTO;
import com.vouchers.dtos.GenericErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VoucherNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleVoucherNotExists(VoucherNotFoundException v) {
        var errorResponse = new ErrorResponseDTO(
                v.getCode(),
                v.getDescription()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericErrorResponse> handleGenericException(Exception ex) {
        var error = new GenericErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());

        return ResponseEntity.status(error.statusCode()).body(error);
    }
}
