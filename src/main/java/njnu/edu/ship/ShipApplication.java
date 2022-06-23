package njnu.edu.ship;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("njnu.edu.ship.dao")
public class ShipApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShipApplication.class, args);
    }

}
