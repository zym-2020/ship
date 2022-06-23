package njnu.edu.ship.common.utils;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Yiming
 * @Date: 2022/06/23/10:22
 * @Description:
 */
public class GenerateBytes {
    public static byte[] generate(int mmsi, int lon, int lat, int rot, int len, int wid, int zoom) {
        byte[] result = new byte[25];
        int[] arr = new int[] {mmsi, lon, lat, rot, len, wid};
        for(int i = 0; i < arr.length; i++) {
            byte[] temp = int2bytes(i);
            for(int j = 0; j < 4; j++) {
                result[i * 4 + j] = temp[j];
            }
        }
        result[24] = int2bytes(zoom)[3];
        return result;
    }

    private static byte[] int2bytes(int number) {
        byte[] result = new byte[4];
        result[0] = (byte)((number >> 24) & 0xFF);
        result[1] = (byte)((number >> 16) & 0xFF);
        result[2] = (byte)((number >> 8) & 0xFF);
        result[3] = (byte)(number & 0xFF);
        return result;
    }
}
