package org.payment.gateway.bank;

import org.payment.gateway.utils.PaymentMode;

import java.util.Set;

public class SBIBank extends Bank {

    public SBIBank(Set<PaymentMode> supportedModes) {
        super(supportedModes);
    }

    @Override
    public double getSuccessRate(PaymentMode paymentMode) {
        return 0.6;
    }

    public String getName() {
        return "SBI";
    }
}
