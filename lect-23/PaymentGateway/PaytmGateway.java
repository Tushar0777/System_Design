package PaymentGateway;

import PaymentGateway.BankingSystem.Bankingsystem;
import PaymentGateway.BankingSystem.PaytmBanking;

class PaytmGateway extends PaymentGateway {
    public PaytmGateway() {
        this.bankingsystem = new PaytmBanking();
    }

    @Override
    protected boolean validate(PaymentRequest request) {
        System.out.println("[Paytm] Validating payment for " + request.sender + ".");
        if (request.amount <= 0 || !"INR".equals(request.currency)) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean initiate(PaymentRequest request) {
        System.out.println("[Paytm] Initiating payment of " + request.amount
                + " " + request.currency + " for " + request.sender + ".");
        return bankingsystem.ProcessPayment(request.amount);
    }

    @Override
    protected boolean confirm(PaymentRequest request) {
        System.out.println("[Paytm] Confirming payment for " + request.sender + ".");
        // Confirmation always succeeds in this simulation
        return true;
    }
}

// ----------------------------
// Concrete Payment Gateway for Razorpay
// ----------------------------

