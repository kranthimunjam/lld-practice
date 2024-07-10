package org.payment.gateway.client;

import org.payment.gateway.utils.PaymentMode;

import java.util.HashSet;
import java.util.Set;

public class BasicClient implements Client{
    int id;
    String name;

     Set<PaymentMode> allowedPaymentModes = new HashSet<>();

    public BasicClient(int id, String name, Set<PaymentMode> paymentModes) {
        this.id = id;
        this.name = name;
        this.allowedPaymentModes = paymentModes;
    }
    @Override
    public Set<PaymentMode> getSupportedPaymentModes() {
        return this.allowedPaymentModes;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public boolean removePaymentMode(PaymentMode paymentMode) {
        allowedPaymentModes.remove(paymentMode);
        return true;
    }

    @Override
    public void addPaymentMode(PaymentMode newPaymentMode) {
        allowedPaymentModes.add(newPaymentMode);
    }
}
