package org.payment.gateway.bank;

import org.payment.gateway.utils.PaymentMode;

import java.util.Set;

public class HDFCBank extends Bank {

    public HDFCBank(Set<PaymentMode> supportedMethods) {
        super(supportedMethods);
    }

    @Override
    public double getSuccessRate(PaymentMode PaymentMode) {
        return 0.5;
    }

    public String getName() {
        return "HDFC";
    }
}
