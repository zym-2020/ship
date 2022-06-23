package njnu.edu.ship.controller;

import njnu.edu.ship.common.utils.Byte2btye;
import njnu.edu.ship.common.utils.GenerateBytes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/getShip", method = RequestMethod.GET)
    public byte[] getShip() {
        return GenerateBytes.generate(123456789, 121116457,31766489, 0, 200, 50, 13);
    }
    
    @RequestMapping(value = "/getShipBinary", method = RequestMethod.GET)
    public byte[] getShipBinary() {
        return Byte2btye.getShipBinary(1,7,GenerateBytes.generate(123456789, 121116457,31766489, 0, 200, 50, 13));
    }
}
