package njnu.edu.ship.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Yiming
 * @Date: 2022/06/23/10:52
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ship {
    Integer mmsi;
    Integer length;
    Integer width;
    String name;
    String country;
    String picture;
}
