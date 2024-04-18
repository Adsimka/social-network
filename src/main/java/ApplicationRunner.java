import database.pool.ConnectionPool;
import repository.UserRepository;
import service.UserService;

import static ioc.Container.get;

public class ApplicationRunner {

    public static void main(String[] args) {
//        var connectionPool = new ConnectionPool();
//        var userRepository = new UserRepository(connectionPool);
//        var userService = new UserService(userRepository);

        var connectionPool = get(ConnectionPool.class);
        var userRepository = get(UserRepository.class);
        var userService = get(UserService.class);
    }
}
