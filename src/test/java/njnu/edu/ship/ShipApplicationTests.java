package njnu.edu.ship;

import com.alibaba.fastjson.JSONObject;
import njnu.edu.ship.common.result.JsonResult;
import njnu.edu.ship.common.utils.RemoteRequest;
import njnu.edu.ship.common.utils.TranslateShipResponseUtil;
import njnu.edu.ship.service.ShipService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@SpringBootTest
class ShipApplicationTests {
    @Autowired
    ShipService shipService;

    @Test
    void contextLoads() {
//        JSONObject jsonObject = RemoteRequest.getShipInfo("414432000");
//        System.out.println(jsonObject);
        //List<Map<String, Object>> list= TranslateShipResponseUtil.translate(new String[]{"71957934", "18541879", "73272997", "19611906"},"9","0","33958.91359543285","1");
        List<Object> list= new ArrayList<>();
//        for(Integer i=1;i<=10;i++) {
//            String zoom=Integer.toString(i);
//            List<Map<String, Object>> listYangZte = TranslateShipResponseUtil.translate(new String[]{"71957934", "18541879", "73272997", "19611906"}, zoom, "0", "33958.91359543285", "1");
//            list.add(listYangZte);
//        }
 //       JSONObject info=RemoteRequest.getShipInfo("808464435");
        shipService.addAllShip();
        System.out.println("dd");
    }

}
