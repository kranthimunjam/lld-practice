package org.payment.gateway.gateway;

import org.payment.gateway.client.Client;
import org.payment.gateway.data.clientdata.ClientStore;
import org.payment.gateway.data.paymentstoredata.PaymentStore;
import org.payment.gateway.payment.Payment;
import org.payment.gateway.strategy.PaymentStrategy;
import org.payment.gateway.utils.PaymentMode;

import java.util.ArrayList;
import java.util.List;

public class BasicPaymentGateway implements PaymentGateway{
    ClientStore clientStore;
    PaymentStore paymentStore;

    public BasicPaymentGateway(){
        this.clientStore = ClientStore.getInstance();
        this.paymentStore = PaymentStore.getInstance();
    }


    public void addClient(Client client) {
        clientStore.addClient(client);
    }

    public void removeClient(Client client){
        clientStore.removeClient(client);
    }

    @Override
    public boolean hasClient(Client client) {
        return clientStore.hasClient(client.getId());
    }

    public void addNewPaymentMode(int clientId, PaymentMode mode) {
        if (clientStore.getClient(clientId) != null) {
            Client client = clientStore.getClient(clientId);
            client.addPaymentMode(mode);
        }
    }

    public void removePaymentMode(int clientId, PaymentMode mode) {
        if (clientStore.getClient(clientId) != null) {
            Client client = clientStore.getClient(clientId);
            client.removePaymentMode(mode);
        }
    }

    public Payment processPayment(int clientId, PaymentStrategy strategy, Double amount) {
        Client client = clientStore.getClient(clientId);
        if (client.getSupportedPaymentModes().contains(strategy.paymentMode)) {
            Payment payment = new Payment(clientId, strategy, amount);
            paymentStore.addPayment(payment);
            payment.processPayment();
            System.out.println("processed payment " + amount);
            return payment;
        } else {
            System.out.println("un-supported payment" + strategy.paymentMode);
            return null;
        }
    }

    public List<PaymentMode> supportedModes(int clientId) {
        Client client = clientStore.getClient(clientId);
        if (client != null) {
            return new ArrayList<>(client.getSupportedPaymentModes());
        } else {
            throw new RuntimeException();
        }
    }

    public boolean cancelPayment(String paymentId) {
        Payment payment = paymentStore.getPayment(paymentId);
        if (payment != null) {
            return payment.cancelPayment();
        }
        return false;
    }

}
