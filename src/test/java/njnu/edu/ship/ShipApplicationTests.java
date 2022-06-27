package njnu.edu.ship;

import com.alibaba.fastjson.JSONObject;
import com.google.common.primitives.Bytes;
import njnu.edu.ship.common.result.JsonResult;
import njnu.edu.ship.common.utils.Byte2btye;
import njnu.edu.ship.common.utils.MyTime;
import njnu.edu.ship.common.utils.RemoteRequest;
import njnu.edu.ship.common.utils.MyTime;
import njnu.edu.ship.common.utils.TranslateShipResponseUtil;
import njnu.edu.ship.dao.RecordMapper;
import njnu.edu.ship.service.RecordService;
import njnu.edu.ship.service.ShipService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.*;
@SpringBootTest
class ShipApplicationTests {
    @Autowired
    ShipService shipService;

    @Autowired
    RecordService recordService;

    @Autowired
    RecordMapper recordMapper;

    @Autowired
    MyTime myTime;

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
        //返回船的参数正确性测试
       //JSONObject info=RemoteRequest.getShipInfo("808464435");
        //将船插入数据库成功测试//
        // shipService.addAllShip();


        //byte连接、准确性、测试
//        byte[] b0=new byte[0];
//        byte[] b1=(byte[])recordMapper.QueryCodeByMsi(412372190).get(0).get("code");
//        byte[] b2=(byte[])recordMapper.QueryCodeByMsi(412365750).get(0).get("code");
//
//        byte[] codes= Bytes.concat(b1,b2);
//        byte[] newCode= Byte2btye.getShipBinary(codes);
//        System.out.println("dd");
//        //Time.timer2();
//        System.out.println("hh");
//        myTime.timer5();
        shipService.addAllShip();
       System.out.println("ll");

    }


}
