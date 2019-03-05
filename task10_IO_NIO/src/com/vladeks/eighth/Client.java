package com.vladeks.eighth;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

public class Client {
    public static void main(String[] arg) throws IOException, InterruptedException {

        InetSocketAddress crunchifyAddr = new InetSocketAddress("localhost", 1234);
        SocketChannel crunchifyClient = SocketChannel.open(crunchifyAddr);

        System.out.println("Connecting to Server on port 1234...");

        ArrayList<String> companyDetails = new ArrayList<String>();

        // create a ArrayList with companyName list
        companyDetails.add("Facebook");
        companyDetails.add("Twitter");
        companyDetails.add("IBM");
        companyDetails.add("Google");
        companyDetails.add("Crunchify");

        for (String companyName : companyDetails) {

            byte[] message = new String(companyName).getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(message);
            crunchifyClient.write(buffer);

            System.out.println(("sending: " + companyName));
            buffer.clear();

            // wait for 2 seconds before sending next message
            Thread.sleep(2000);
        }
        crunchifyClient.close();
    }
}
