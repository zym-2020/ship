package njnu.edu.ship.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.primitives.Bytes;
import njnu.edu.ship.common.utils.GenerateBytes;
import njnu.edu.ship.common.utils.RemoteRequest;
import njnu.edu.ship.common.utils.TranslateShipResponseUtil;
import njnu.edu.ship.dao.RecordMapper;
import njnu.edu.ship.dao.ShipMapper;
import njnu.edu.ship.pojo.Record;
import njnu.edu.ship.pojo.Ship;
import njnu.edu.ship.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ShipServiceImpl implements ShipService {
    @Autowired
    ShipMapper shipMapper;
    @Autowired
    RecordMapper recordMapper;
    @Override
    public void addAllShip() {
        List<Object> list = new ArrayList<>();
        List<Map<String, Object>> listYangZte;
        for (Integer i = 2; i <= 8; i++) {
            String zoom = Integer.toString(i);
            listYangZte= TranslateShipResponseUtil.translate(new String[]{"71957934", "18541879", "73272997", "19611906"}, zoom, "0", "33958.91359543285", "1");
            addShipColumn(listYangZte,i);
            list.add(listYangZte);

        }
        System.out.println("h");
    }



    @Override
    public Map<String, Object> QueryLenWidByMsi(Integer mmsi) {
        Map<String, Object> result = new HashMap<>();
         result.put("list", shipMapper.QueryLenWidByMsi(mmsi));
         return result;

    }



    @Override
    public void addShipColumn(List<Map<String, Object>> listYangZte,Integer zoom) {
        int num = listYangZte.size();
        Ship ship;
        Record record;
        JSONObject info;
        int count ;
        int len;
        int wid;
        byte[] code ;
        byte[] codes=new byte[0];
        for (int i = 0; i < num; i++) {
            Integer mmsi = (Integer) listYangZte.get(i).get("mmsi");
            ship = new Ship();
            count = shipMapper.CountByMsi(mmsi); //??count应返回根据mmsi查询ship表的len和wid
            if(count == 0) { //该船的长与宽在表中未曾记录过
                info=RemoteRequest.getShipInfo(mmsi.toString()); //获得船的相关信息
                ship.setMmsi(mmsi);
                ship.setLength((Integer) info.get("al"));
                ship.setWidth((Integer) info.get("aw"));
                ship.setName((String) info.get("name"));
                ship.setCountry((String) info.get("country"));
                ship.setPicture((String) info.get("pic"));
                shipMapper.addShip(ship);

                record = new Record();
                record.setId(UUID.randomUUID().toString());
                record.setMmsi(mmsi);
                record.setDate(new Date());
                record.setZoom(zoom);
                code= GenerateBytes.generate( mmsi,
                        (int)((double)listYangZte.get(i).get("longitude") * 100000),
                        (int)((double)listYangZte.get(i).get("latitude") * 100000),
                        (int)((double)listYangZte.get(i).get("rotation") * 1000),
                        (Integer) info.get("al"),
                        (Integer) info.get("aw"),
                         zoom);
                record.setCode(code);
                recordMapper.addRecord(record);
                codes= Bytes.concat(codes,code);

            }

            else { //该船的长与宽在表中曾记录过
                len=(Integer) shipMapper.QueryLenWidByMsi(mmsi).get(0).get("length");
                wid=(Integer) shipMapper.QueryLenWidByMsi(mmsi).get(0).get("width");
                record = new Record();
                record.setId(UUID.randomUUID().toString());
                record.setMmsi(mmsi);
                record.setDate(new Date());
                record.setZoom(zoom);
                code= GenerateBytes.generate( mmsi,
                        (int)((double)listYangZte.get(i).get("longitude") * 100000),
                        (int)((double)listYangZte.get(i).get("latitude") * 100000),
                        (int)((double)listYangZte.get(i).get("rotation") * 1000),
                        len,
                        wid,
                        zoom);
                record.setCode(code);
                codes= Bytes.concat(codes,code);

            }


        }
        //return codes;

    }
}
