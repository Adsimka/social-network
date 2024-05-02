import database.pool.ConnectionPool;
import database.repository.CRUDRepository;
import database.repository.CompanyRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import database.repository.UserRepository;

public class ApplicationRunner
{
    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            var connectionPool = context.getBean("p", ConnectionPool.class);
            System.out.println(connectionPool);

            var companyRepository = context.getBean("companyRepository", CRUDRepository.class);

            System.out.println(companyRepository);
        }
        System.out.println();
    }
}
