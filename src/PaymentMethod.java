// Base class PaymentMethod
public class PaymentMethod {

    public static void main(String[] args) {
        // Create PaymentMethod objects
        PaymentMethod creditCard = new CreditCard("1234-5678-9876-5432", "Alejandro Taborda", "09/25");
        PaymentMethod payPal = new PayPal("alejandro.taborda280@gmail..com");
        PaymentMethod bankTransfer = new BankTransfer("1234567890", "Bank of Bruselas");

        // Simulate payments and verifications
        double amount = 1350.0;

        System.out.println("\nProcessing Payments:");
        creditCard.makePayment(amount);
        payPal.makePayment(amount);
        bankTransfer.makePayment(amount);

        System.out.println("\nVerifying Payments:");
        creditCard.verifyPayment(amount);
        payPal.verifyPayment(amount);
        bankTransfer.verifyPayment(amount);
    }

    //Method to make payment (to be overridden)
    public void makePayment(double amount) {
        System.out.println("Payment of $" + amount + " made using payment method.");
    }

    // Method to verify payment (to be overridden)
    public boolean verifyPayment(double amount) {
        System.out.println("Verifying payment of $" +amount+ "using payment method.");
        return true;
    }
}


// Subclass CreditCard
class CreditCard extends PaymentMethod {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;

    public CreditCard(String cardNumber, String cardHolderName, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }

    @Override
    public boolean verifyPayment(double amount) {
        System.out.println("Verifying credit card Payment of $" + amount);
        return true;
    }
}

// Subclass Paypal
class PayPal extends PaymentMethod {
    private String email;

    public PayPal(String email) {
        this.email = email;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }

    @Override
    public boolean verifyPayment(double amount) {
        System.out.println("Verifying PayPal payment of $" + amount);
        return true;
    }
}

// Subclass BankTransfer
class BankTransfer extends PaymentMethod {
    private String accountNumber;
    private String bankName;

    public BankTransfer(String accountNumber, String bankName) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Processing Bank Transfer payment of $" + amount);
    }

    @Override
    public boolean verifyPayment(double amount) {
        System.out.println("Verifying Bank Transfer payment of $" + amount);
        return true;
    }
}

