package org.payment.gateway.client;

import org.payment.gateway.utils.PaymentMode;

import java.util.Set;

public interface Client {
    Set<PaymentMode> getSupportedPaymentModes();

    int getId();

    boolean removePaymentMode(PaymentMode newPaymentMode);

    void addPaymentMode(PaymentMode newPaymentMode);

}
