package com.vladeks.second;

import java.io.*;
import java.util.Arrays;

public class ComparePerformance {

    public static void main(String... args) throws IOException {
        for (int mb : new int[]{200}) {
            System.out.println("Buffered");
            testBufferedFileSize(mb, 8192);
            System.out.println("Non");
            testFileSize(mb);
        }

    }

    private static void testBufferedFileSize(int mb, int bs) throws IOException {
        File file = File.createTempFile("test", ".txt");
        file.deleteOnExit();
        char[] chars = new char[1024];
        Arrays.fill(chars, 'A');
        String longLine = new String(chars);
        long start1 = System.nanoTime();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file), bs);
        for (int i = 0; i < mb * 1024; i++)
            writer.write(longLine);
        writer.close();
        long time1 = System.nanoTime() - start1;
        System.out.printf("Took %.3f seconds to write to a %d MB, file rate: %.1f MB/s%n",
                time1 / 1e9, file.length() >> 20, file.length() * 1000.0 / time1);

        long start2 = System.nanoTime();
        BufferedReader reader = new BufferedReader(new FileReader(file), bs);
        for (String line; (line = reader.readLine()) != null; ) {
        }
        reader.close();
        long time2 = System.nanoTime() - start2;
        System.out.printf("Took %.3f seconds to read to a %d MB file, rate: %.1f MB/s%n",
                time2 / 1e9, file.length() >> 20, file.length() * 1000.0 / time2);
        file.delete();
    }

    private static void testFileSize(int mb) throws IOException {
        File file = File.createTempFile("test", ".txt");
        file.deleteOnExit();
        char[] chars = new char[1024];
        Arrays.fill(chars, 'A');
        String longLine = new String(chars);
        long start1 = System.nanoTime();
        FileWriter writer = new FileWriter(file);
        for (int i = 0; i < mb * 1024; i++)
            writer.write(longLine);
        writer.close();
        long time1 = System.nanoTime() - start1;
        System.out.printf("Took %.3f seconds to write to a %d MB, file rate: %.1f MB/s%n",
                time1 / 1e9, file.length() >> 20, file.length() * 1000.0 / time1);

        long start2 = System.nanoTime();
        FileReader reader = new FileReader(file);

        for (int line; (line = reader.read()) != -1; ) {
        }
        reader.close();
        long time2 = System.nanoTime() - start2;
        System.out.printf("Took %.3f seconds to read to a %d MB file, rate: %.1f MB/s%n",
                time2 / 1e9, file.length() >> 20, file.length() * 1000.0 / time2);
        file.delete();
    }

}
