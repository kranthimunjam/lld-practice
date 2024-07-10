package org.payment.gateway;

import org.payment.gateway.client.BasicClient;
import org.payment.gateway.client.Client;
import org.payment.gateway.gateway.BasicPaymentGateway;
import org.payment.gateway.gateway.PaymentGateway;
import org.payment.gateway.strategy.UPIPaymentStrategy;
import org.payment.gateway.utils.PaymentMode;

import java.util.Arrays;
import java.util.HashSet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Client client = new BasicClient(1, "client1", new HashSet<>(Arrays.asList(PaymentMode.UPI, PaymentMode.NET_BANKING)));
        PaymentGateway paymentGateway = new BasicPaymentGateway();
        paymentGateway.addClient(client);
        UPIPaymentStrategy upi = new UPIPaymentStrategy("id");
        paymentGateway.processPayment(1, upi, 100.0);

        System.out.println("supported method for the client 1: " + paymentGateway.supportedModes(1));
    }
}