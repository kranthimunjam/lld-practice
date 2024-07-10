package org.payment.gateway.strategy;

import org.payment.gateway.bank.Bank;
import org.payment.gateway.router.BankRouter;
import org.payment.gateway.utils.PaymentMode;

public class UPIPaymentStrategy  extends PaymentStrategy{
    String id;

    public UPIPaymentStrategy( String id) {
        super(PaymentMode.UPI);
        this.id = id;
    }

    @Override
    public Bank getBank() {
        BankRouter bankRouter = BankRouter.getInstance();
        bankRouter.setBankTrafficCapacity("HDFC", 30);
        return bankRouter.getBankForPaymentMode(paymentMode);
    }
}
