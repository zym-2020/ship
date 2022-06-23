package njnu.edu.ship.common.utils;

import java.nio.ByteBuffer;

public class Byte2btye {

    public static byte[] getShipBinary(int size,int field,byte[] oldByte)
    {
        int Size = field * size;
        int bufferSize = 4 * Size;
        ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
        byte[] b = buffer.array();
        int c=0;
        for (int i = 0; i < field; i++) {
            for (int j = i*4; j < bufferSize; j = j + field*4) {
                for (int k=0 ;k<4;k++)
                b[c++] = oldByte[j+k];
            }
        }

        return b;

    }

}
