package njnu.edu.ship.service.impl;

import njnu.edu.ship.dao.RecordMapper;
import njnu.edu.ship.pojo.Record;
import njnu.edu.ship.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    RecordMapper recordMapper;

    @Override
    public void addRecord(Record record){
        recordMapper.addRecord(record);
    }

//    @Override
//    public Map<String, Object> QueryCodeByMsi(Integer mmsi) {
//        Map<String, Object> result = new HashMap<>();
//        result.put("list", recordMapper.QueryCodeByMsi(mmsi));
//        return result;

    //}

}
