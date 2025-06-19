package PaymentGateway;

import PaymentGateway.BankingSystem.RazorpayBanking;

class RazorpayGateway extends PaymentGateway {
    public RazorpayGateway() {
        this.bankingsystem = new RazorpayBanking();
    }

    @Override
    protected boolean validate(PaymentRequest request) {
        System.out.println("[Razorpay] Validating payment for " + request.sender + ".");
        if (request.amount <= 0) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean initiate(PaymentRequest request) {
        System.out.println("[Razorpay] Initiating payment of " + request.amount
                + " " + request.currency + " for " + request.sender + ".");
        return bankingsystem.ProcessPayment(request.amount);
    }

    @Override
    protected boolean confirm(PaymentRequest request) {
        System.out.println("[Razorpay] Confirming payment for " + request.sender + ".");
        // Confirmation always succeeds in this simulation
        return true;
    }
}
