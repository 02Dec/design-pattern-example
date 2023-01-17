import behavioural.command.*;
import behavioural.template.ContactPage;
import behavioural.template.HomePage;
import behavioural.template.PageTemplate;
import creational.builder.Song;
import creational.builder.SongBuilder;
import creational.factorymethod.FCType;
import creational.factorymethod.FootballClub;
import creational.factorymethod.FootballClubFactory;
import creational.prototype.Computer;
import creational.singleton.DoubleCheckLockingSingleton;
import structural.facade.ShopFacade;
import structural.proxy.UserService;
import structural.proxy.UserServiceProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
//        demoSingleton();
//        demoFactoryMethod();
//        demoBuilder();
//        demoPrototype();
//        demoFacade();
//        demoProxy();
//        demoTemplate();
        demoCommand();
    }

    /**
     * @author: dungnk
     * Demo #Reflection break #SingletonPattern
     */
    public static void demoSingleton() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        DoubleCheckLockingSingleton instanceOne = DoubleCheckLockingSingleton.getInstance();
        DoubleCheckLockingSingleton instanceTwo = null;
        Constructor<?>[] constructors = DoubleCheckLockingSingleton.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            instanceTwo = (DoubleCheckLockingSingleton) constructor.newInstance();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

    /**
     * @throws Exception Demo factory method
     * @author dungnk
     */
    public static void demoFactoryMethod() throws Exception {
        FootballClub fc = FootballClubFactory.getFootballClub(FCType.CHELSEA);
        System.out.println(fc.getFCName());
    }

    /**
     * @author dungnk
     * Demo #Builder pattern
     */
    public static void demoBuilder() {
        Song song = new SongBuilder()
                .author("Onionn")
                .title("Waiting For You")
                .singer("Mono")
                .publishedAt(new Date())
                .build();
        System.out.println(song.toString());
    }

    /**
     * @author dungnk
     * Demo Prototype Pattern
     */
    public static void demoPrototype() {
        Computer com1 = new Computer("Window 10", "Office 2022", "Window Defender", "Chrome", "Slack");
        Computer com2 = com1.clone();
        com2.setOthers("Discord");
        System.out.println(com1);
        System.out.println(com2);
    }

    /**
     * @author dungnk
     * Demo Facade Pattern
     */
    public static void demoFacade() {
        ShopFacade.getInstance().buyProductByCash("dungnk@gmail.com");
        ShopFacade.getInstance().buyProductByPaypal("dungnk@gmail.com", "113");
    }

    /**
     * @author dungnk
     * Demo Proxy Pattern
     */
    public static void demoProxy() throws IllegalAccessException {
        UserService admin = new UserServiceProxy("dungnk", "admin");
        admin.load();
        admin.insert();

        UserService ba = new UserServiceProxy("mytt", "ba");
        ba.load();
        ba.load();
        ba.insert();
    }

    /**
     * @author dungnk
     * Demo Template Pattern
     */
    public static void demoTemplate() {
        PageTemplate homePage = new HomePage();
        homePage.showPage();

        PageTemplate contactPage = new ContactPage();
        contactPage.showPage();
    }

    /**
     * @author dungnk
     * Demo Command Pattern
     */
    public static void demoCommand() {
        Account account = new Account("dungnk");
        Command open = new OpenAccount(account);
        Command close = new CloseAccount(account);
        BankApp bankApp = new BankApp(open, close);
        bankApp.clickOpenAccount();
        bankApp.clickCloseAccount();
    }
}
