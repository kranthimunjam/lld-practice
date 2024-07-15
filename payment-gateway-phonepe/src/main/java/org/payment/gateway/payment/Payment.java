package org.payment.gateway.payment;

import org.payment.gateway.bank.Bank;
import org.payment.gateway.strategy.PaymentStrategy;
import org.payment.gateway.utils.Status;

import java.util.UUID;

public class Payment {

    double price;
    PaymentStrategy paymentStrategy;
    public String paymentId;
    Status status;
    int clientId;
    Bank bank;

    public Payment(int clientId, PaymentStrategy strategy, double price) {
        this.clientId = clientId;
        this.price = price;
        this.paymentStrategy = strategy;
        this.bank = strategy.getBank();
        this.paymentId = UUID.randomUUID().toString();
        this.status = Status.PENDING;
    }

    public void processPayment() {
        boolean processed = this.bank.processPayment(this);
        if (processed) {
            status = Status.SUCCESSFUL;
        } else {
            status = Status.FAILED;
        }
    }

    public boolean cancelPayment() {
        return this.bank.cancelPayment(this);
    }
}
