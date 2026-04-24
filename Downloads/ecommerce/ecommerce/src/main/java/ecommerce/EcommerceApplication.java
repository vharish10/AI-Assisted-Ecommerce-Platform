package ecommerce;

import ecommerce.model.Role;
import ecommerce.model.User;
import ecommerce.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan(basePackages = "ecommerce.model")
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner loadData(UserRepository repo) {
        return args -> {
            String[] names = {
                    "Aarav Sharma", "Diya Patel", "Rohan Verma", "Ananya Iyer",
                    "Karthik Reddy", "Meera Nair", "Arjun Singh", "Sneha Gupta",
                    "Vikram Rao", "Pooja Mehta"
            };

            for (int i = 0; i < 100; i++) {
                User user = new User();
                String name = names[i % names.length];

                user.setName(name);
                user.setEmail(name.toLowerCase().replace(" ", "") + i + "@gmail.com");
                user.setPassword("1234");
                user.setRole(Role.CUSTOMER);

                repo.save(user);
            }
        };
    }
}
