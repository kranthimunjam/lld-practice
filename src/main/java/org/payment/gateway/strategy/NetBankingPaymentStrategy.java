package org.payment.gateway.strategy;

import org.payment.gateway.utils.PaymentMode;

public class NetBankingPaymentStrategy extends PaymentStrategy{
    String number;

    public NetBankingPaymentStrategy( String number) {
        super(PaymentMode.NET_BANKING);
        this.number = number;
    }

}
