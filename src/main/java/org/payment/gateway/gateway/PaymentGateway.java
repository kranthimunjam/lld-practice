package org.payment.gateway.gateway;

import org.payment.gateway.client.Client;
import org.payment.gateway.payment.Payment;
import org.payment.gateway.strategy.PaymentStrategy;
import org.payment.gateway.utils.PaymentMode;

import java.util.List;

public interface PaymentGateway {
    void addClient(Client client);

    void removeClient(Client client);

    boolean hasClient(Client client);

    void addNewPaymentMode(int clientId, PaymentMode mode);

    void removePaymentMode(int clientId, PaymentMode method);

    Payment processPayment(int clientId, PaymentStrategy strategy, Double amount);

    List<PaymentMode> supportedModes(int clientId);


    boolean cancelPayment(String paymentId);
}
