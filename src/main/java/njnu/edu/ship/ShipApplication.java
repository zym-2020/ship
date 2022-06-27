package njnu.edu.ship;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ServletComponentScan
//@EnableScheduling
@MapperScan("njnu.edu.ship.dao")
public class ShipApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShipApplication.class, args);
    }

}
