package com.ouriques.file.common;

public class FileUtils {

    public static String buildDoneFileName(String fileName){

        String[] file = fileName.split(".dat");

        return file[0] + ".done.dat";
    }
}
