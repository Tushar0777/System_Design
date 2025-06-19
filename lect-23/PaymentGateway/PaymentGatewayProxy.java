package PaymentGateway;

// ----------------------------
// Proxy class that wraps a PaymentGateway to add retries (Proxy Pattern)
// ----------------------------
public class PaymentGatewayProxy extends PaymentGateway {
    private PaymentGateway realGateway;
    private int retries;

    public PaymentGatewayProxy(PaymentGateway gateway, int maxRetries) {
        this.realGateway = gateway;
        this.retries     = maxRetries;
    }

    @Override
    public boolean processPayment(PaymentRequest request) {
        boolean result = false;
        for (int attempt = 0; attempt < retries; ++attempt) {
            if (attempt > 0) {
                System.out.println("[Proxy] Retrying payment (attempt " + (attempt+1)
                        + ") for " + request.sender + ".");
            }
            result = realGateway.processPayment(request);
            if (result) break;
        }
        if (!result) {
            System.out.println("[Proxy] Payment failed after " + retries
                    + " attempts for " + request.sender + ".");
        }
        return result;
    }

    @Override
    protected boolean validate(PaymentRequest request) {
        return realGateway.validate(request);
    }

    @Override
    protected boolean initiate(PaymentRequest request) {
        return realGateway.initiate(request);
    }

    @Override
    protected boolean confirm(PaymentRequest request) {
        return realGateway.confirm(request);
    }
} 