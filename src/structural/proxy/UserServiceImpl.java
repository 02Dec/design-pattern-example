package structural.proxy;

public class UserServiceImpl implements UserService {
    private String username;

    public UserServiceImpl(String username) {
        this.username = username;
    }

    @Override
    public void load() {
        System.out.println(username + " loaded");
    }

    @Override
    public void insert() {
        System.out.println(username + " inserted");
    }
}
