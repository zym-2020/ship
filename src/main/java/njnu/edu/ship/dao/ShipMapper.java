package njnu.edu.ship.dao;

import njnu.edu.ship.pojo.Ship;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface ShipMapper {

    void addShip(Ship ship);

    List<Map<String, Object>> QueryLenWidByMsi(Integer mmsi);

    Integer CountByMsi(Integer mmsi);
}
