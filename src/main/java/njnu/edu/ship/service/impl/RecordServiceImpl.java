package njnu.edu.ship.service.impl;

import njnu.edu.ship.dao.RecordMapper;
import njnu.edu.ship.pojo.Record;
import njnu.edu.ship.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    RecordMapper recordMapper;

    @Override
    public void addRecord(Record record){
        recordMapper.addRecord(record);
    }

}
