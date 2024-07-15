package org.payment.gateway.data.paymentstoredata;

import org.payment.gateway.payment.Payment;

import java.util.HashMap;
import java.util.Map;

public class PaymentStore {
    Map<String, Payment> paymentMap;
    static PaymentStore instance;

    private PaymentStore() {
        paymentMap = new HashMap<>();
    }

    public static PaymentStore getInstance() {
        if (instance == null) {
            instance = new PaymentStore();
        }
        return instance;
    }

    public Payment getPayment(String id) {
        return paymentMap.get(id);
    }

    public void addPayment(Payment payment) {
        paymentMap.put(payment.paymentId, payment);
    }
}
