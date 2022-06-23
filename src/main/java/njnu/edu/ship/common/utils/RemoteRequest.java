package njnu.edu.ship.common.utils;

import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import njnu.edu.ship.common.exception.MyException;
import njnu.edu.ship.common.result.ResultEnum;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Yiming
 * @Date: 2022/06/22/17:34
 * @Description:
 */
public class RemoteRequest {

    /**
    * @Description:查询船只位置信息
    * @Author: Yiming
    * @Date: 2022/6/22
    */
    public static byte[] getShips(String[] bbox, String zoom, String mmsi, String ref, String showName) {
        String url = "https://www.vesselfinder.com/api/pub/mp2" + getUrl(bbox, zoom, mmsi, ref, showName);
        try {
            URL serverUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if(conn.getResponseCode() == 200) {
                return IOUtils.toByteArray(conn.getInputStream());
            } else {
                throw new MyException(ResultEnum.DEFAULT_EXCEPTION);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(ResultEnum.DEFAULT_EXCEPTION);
        }

    }

    private static String getUrl(String[] bbox, String zoom, String mmsi, String ref, String showName) {
        return "?bbox=" + bbox[0] + "%2C" + bbox[1] + "%2C" + bbox[2] + "%2C" + bbox[3] + "&zoom=" + zoom + "&mmsi=" + mmsi + "&ref=" + ref + "&show_names=" + showName;
    }

    public static JSONObject getShipInfo(String mmsi) {
        String url = "https://www.vesselfinder.com/api/pub/click/" + mmsi;
//        try {
//            URL serverUrl = new URL(url);
//            HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setInstanceFollowRedirects(false);
//            conn.connect();
//            if(conn.getResponseCode() == 200) {
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new MyException(ResultEnum.DEFAULT_EXCEPTION);
//        }
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.124 Safari/537.36 Edg/102.0.1245.44");
        HttpEntity httpEntity = new HttpEntity(headers);
        try {
            ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, JSONObject.class);
            return responseEntity.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(ResultEnum.DEFAULT_EXCEPTION);
        }
    }

}
