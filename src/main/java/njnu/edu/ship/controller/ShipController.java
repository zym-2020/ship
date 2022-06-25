package njnu.edu.ship.controller;

import com.google.common.collect.ObjectArrays;
import com.google.common.primitives.Bytes;
import njnu.edu.ship.common.utils.Byte2btye;
import njnu.edu.ship.common.utils.GenerateBytes;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.util.ArrayUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Yiming
 * @Date: 2022/06/23/10:38
 * @Description:
 */
@RestController
@RequestMapping("/ship")
public class ShipController {
    @CrossOrigin
    @RequestMapping(value = "/getShip", method = RequestMethod.GET)
    public byte[] getShip() {
        return GenerateBytes.generate(123456789, 121116457,31766489, 0, 200, 50, 13);
    }

    @CrossOrigin
    @RequestMapping(value = "/getShipBinary", method = RequestMethod.GET)
    public byte[] getShipBinary() {
        byte[] b1 = GenerateBytes.generate(1, 2,3, 4, 5, 6, 7);
        byte[] b4 = GenerateBytes.generate(8, 9,10, 11, 12, 13, 14);
        byte[] b2 = GenerateBytes.generate(123456789, 121126457,31766489, 0, 200, 50, 13);
        byte[] b9 = GenerateBytes.generate(123456790, 121326457,31866489, 0, 200, 50, 13);
        byte[] b3 = Bytes.concat(b9, b2);
        byte[] b5 = Bytes.concat(b1, b4);
        byte[] b6= Byte2btye.getShipBinary(2,7,b3);
        byte[] b7= Byte2btye.getShipBinary(1,7,b2);
        byte[] btest= Byte2btye.getShipBinary(2,7,b5);
        return b6;
    }
}
