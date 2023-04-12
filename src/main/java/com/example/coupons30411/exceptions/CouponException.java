package com.example.coupons30411.exceptions;

public class CouponException extends Exception{

    public CouponException() {
        super();
    }

    public CouponException(String message) {
        super(message);
    }

    public CouponException(String message, Throwable cause) {
        super(message, cause);
    }

    public CouponException(Throwable cause) {
        super(cause);
    }
}
