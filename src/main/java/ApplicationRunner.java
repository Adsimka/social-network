import database.pool.ConnectionPool;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.UserRepository;
import service.UserService;

import static ioc.Container.get;

public class ApplicationRunner
{
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");
        var connectionPool = context.getBean("pool", ConnectionPool.class);
        System.out.println(context.getBean("p3", ConnectionPool.class));
    }
}
