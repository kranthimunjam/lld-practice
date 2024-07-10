package org.payment.gateway.strategy;

import org.payment.gateway.bank.Bank;
import org.payment.gateway.router.BankRouter;
import org.payment.gateway.utils.PaymentMode;

public abstract class PaymentStrategy {
    public PaymentMode paymentMode;

    public PaymentStrategy(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Bank getBank() {
        BankRouter bankRouter = BankRouter.getInstance();
        bankRouter.initBankTrafficDefault();
        return bankRouter.getBankForPaymentMode(paymentMode);
    }
}
