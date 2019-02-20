package com.vladeks.seventh;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MyBuffer  {

    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("abc.txt", "rw");

        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(10);
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            buf.flip(); //make buffer ready for read from
            while (buf.hasRemaining()){
                System.out.print((char) buf.get()); // read 1 byte at a time
            }
            buf.clear(); //make buffer ready for writing into
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
