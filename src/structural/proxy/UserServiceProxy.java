package structural.proxy;

public class UserServiceProxy implements UserService {
    private String role;
    private UserService userService;

    public UserServiceProxy(String username, String role) {
        this.role = role;
        userService = new UserServiceImpl(username);
    }

    @Override
    public void load() {
        userService.load();
    }

    @Override
    public void insert() throws IllegalAccessException {
        if (isAdmin()) {
            userService.insert();
        } else {
            throw new IllegalAccessException("Access denied");
        }
    }

    private boolean isAdmin() {
        return "admin".equalsIgnoreCase(this.role);
    }
}
