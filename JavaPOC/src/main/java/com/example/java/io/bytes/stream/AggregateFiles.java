/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.java.io.bytes.stream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jjagadee
 */
public class AggregateFiles {

    public static final int MAX_READ_BUFFER_SIZE = 8 * 1024;//8kb

    public static void aggregateFiles(List<File> files, File destFile) throws Exception {

        try (BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(destFile))) {
            RandomAccessFile raf = null;
            for (File file : files) {
                raf = new RandomAccessFile(file, "r");
                long numReads = raf.length() / MAX_READ_BUFFER_SIZE;
                long numRemainingRead = raf.length() % MAX_READ_BUFFER_SIZE;
                for (int i = 0; i < numReads; i++) {
                    readWrite(raf, bw, MAX_READ_BUFFER_SIZE);
                }
                if (numRemainingRead > 0) {
                    readWrite(raf, bw, numRemainingRead);
                }
                raf.close();
            }
        }
    }

    private static void readWrite(RandomAccessFile raf, BufferedOutputStream bw, long numBytes) throws IOException {
        byte[] buf = new byte[(int) numBytes];
        int val = raf.read(buf);
        if (val != -1) {
            bw.write(buf);
        }
    }

    public static void main(String[] args) throws Exception {
        final String DEST_FILE = "D:\\workspace\\TechnicalConsultent\\Java\\split\\images.zip";
        final String SRC_FILE = "D:\\workspace\\TechnicalConsultent\\Java\\split\\split";
        List<File> splitFiles = new ArrayList<>();
        for (int i = 1; i <= 11; i++) {
            File file = new File(SRC_FILE + i);
            splitFiles.add(file);
        }
        AggregateFiles.aggregateFiles(splitFiles, new File(DEST_FILE));

    }
}
