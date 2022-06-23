package njnu.edu.ship;

import com.alibaba.fastjson.JSONObject;
import njnu.edu.ship.common.utils.RemoteRequest;
import njnu.edu.ship.common.utils.TranslateShipResponseUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class ShipApplicationTests {

    @Test
    void contextLoads() {
        JSONObject jsonObject = RemoteRequest.getShipInfo("414432000");
        System.out.println(jsonObject);
    }

}
