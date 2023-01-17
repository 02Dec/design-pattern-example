package structural.facade;

public class ShopFacade {
    private static final ShopFacade INSTANCE = new ShopFacade();

    private AccountService accountService;
    private PaymentService paymentService;
    private SmsService smsService;
    private EmailService emailService;

    private ShopFacade() {
        accountService = new AccountService();
        paymentService = new PaymentService();
        smsService = new SmsService();
        emailService = new EmailService();
    }

    public static ShopFacade getInstance() {
        return INSTANCE;
    }

    public void buyProductByCash(String email) {
        accountService.getAccount(email);
        paymentService.paymentByCash();
        emailService.sendMail(email);
        System.out.println("Done\n");
    }

    public void buyProductByPaypal(String email, String phoneNumber) {
        accountService.getAccount(email);
        paymentService.paymentByPaypal();
        emailService.sendMail(email);
        smsService.sendSMS(phoneNumber);
        System.out.println("Done\n");
    }
}
