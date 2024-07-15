package org.payment.gateway.bank;

import org.payment.gateway.payment.Payment;
import org.payment.gateway.utils.PaymentMode;

import java.util.Set;

public abstract class Bank {

    public String getName() {
        return "INVLAID";
    }

    public Set<PaymentMode> supportedMethods;

    public Bank(Set<PaymentMode> supportedMethods) {
        this.supportedMethods = supportedMethods;
    }

    public boolean processPayment(Payment payment) {
        return true;
    }

    public boolean cancelPayment(Payment payment) {
        return true;
    }

    public abstract double getSuccessRate(PaymentMode PaymentMode);

    public boolean supports(PaymentMode PaymentMode) {
        return supportedMethods.contains(PaymentMode);
    }
}

