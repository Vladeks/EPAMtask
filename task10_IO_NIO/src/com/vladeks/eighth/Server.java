package com.vladeks.eighth;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel socket = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress("localhost", 1234);

        socket.bind(address);
        socket.configureBlocking(false);

        int ops = socket.validOps();
        SelectionKey selectionKey = socket.register(selector, ops, null);

        while (true) {
            System.out.println("Server starting...");
            selector.select();

            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if(key.isAcceptable()) {
                    SocketChannel client = socket.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                    System.out.println("Connection Accepted: " + client.getLocalAddress() + "\n");
                } else if (key.isReadable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(256);
                    client.read(buffer);
                    String result = new String(buffer.array()).trim();
                    System.out.println("Message received: " + result);

                    if (result.equals("Crunchify")) {
                        client.close();
                        System.out.println("\nIt's time to close connection as we got last company name 'Crunchify'");
                        System.out.println("\nServer will keep running. Try running client again to establish new connection");
                    }
                }
                iterator.remove();
            }
        }


    }
}
