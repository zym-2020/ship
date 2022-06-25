package njnu.edu.ship.dao;

import njnu.edu.ship.pojo.Record;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordMapper {

    void addRecord(Record record);
}
