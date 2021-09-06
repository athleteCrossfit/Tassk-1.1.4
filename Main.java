package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    private final static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        userService.createUsersTable();

        userService.saveUser("Брэд", "Питт", (byte) 58);
        userService.saveUser("Том", "Круз", (byte) 59);
        userService.saveUser("Джек", "Николсон", (byte) 84);
        userService.saveUser("Мэтт", "Дэймон", (byte) 51);

        userService.removeUserById(3);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
