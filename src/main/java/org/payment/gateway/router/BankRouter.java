package org.payment.gateway.router;

import org.payment.gateway.bank.Bank;
import org.payment.gateway.bank.HDFCBank;
import org.payment.gateway.bank.SBIBank;
import org.payment.gateway.utils.PaymentMode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class BankRouter {
    List<Bank> banks;

    HashMap<Bank, Integer> bankTrafficCapacity = new HashMap<>();

    private static BankRouter instance;

    // singleton
    public static synchronized BankRouter getInstance() {
        if (instance == null) {
            instance = new BankRouter();
        }
        return instance;
    }

    private BankRouter() {
        HDFCBank hdfcBank = new HDFCBank(new HashSet<>(Arrays.asList(PaymentMode.UPI, PaymentMode.NET_BANKING)));
        SBIBank sbi = new SBIBank(new HashSet<>(Arrays.asList(PaymentMode.UPI, PaymentMode.CREDIT_CARD)));
        this.banks = Arrays.asList(hdfcBank, sbi);
    }

    public Bank getBankForPaymentMode(PaymentMode PaymentMode) {
        double successRate = 0;
        Bank selectedBank = banks.get(0);
        // filter by payment mode
        List<Bank> eligibleBanks = banks.stream().filter(b -> b.supports(PaymentMode)).toList();

        for (Bank bank : eligibleBanks) {
            if (successRate < bank.getSuccessRate(PaymentMode)) {
                successRate = bank.getSuccessRate(PaymentMode);
                selectedBank = bank;
            }
        }
        return selectedBank;
    }

    public void setBankTrafficCapacity(String bankName, int capacity) {
        Bank bank = null;
        for(Bank bankObj : banks){
            if(bankObj.getName().equals(bankName)) bank = bankObj;
        }
        this.bankTrafficCapacity.put(bank,capacity);
    }

    public void initBankTrafficDefault(){
        for(Bank bank : banks) bankTrafficCapacity.put(bank, 100);
    }
}
