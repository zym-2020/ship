package njnu.edu.ship.service;

import njnu.edu.ship.pojo.Record;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface RecordService {
    void addRecord (Record record );

//    Map<String,Object> QueryCodeByMsi(Integer mmsi);
}
