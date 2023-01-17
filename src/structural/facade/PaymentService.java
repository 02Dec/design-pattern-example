package structural.facade;

public class PaymentService {
    public void paymentByPaypal() {
        System.out.println("Payment by Paypal");
    }

    public void paymentByCreditCard() {
        System.out.println("Payment by Credit card");
    }

    public void paymentByCash() {
        System.out.println("Payment by cash");
    }
}
