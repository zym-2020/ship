package njnu.edu.ship.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Yiming
 * @Date: 2022/06/23/10:57
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    String id;
    int mmsi;
    Date date;
    int zoom;
    byte[] code;
}
