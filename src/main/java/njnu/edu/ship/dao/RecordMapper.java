package njnu.edu.ship.dao;

import njnu.edu.ship.pojo.Record;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RecordMapper {

    void addRecord(Record record);

    List<Map<String, Object>> QueryCodeByMsi(Integer mmsi);
}
