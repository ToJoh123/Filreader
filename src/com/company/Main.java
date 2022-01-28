package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
    String fileName = "hehe.txt";
    File file = new File(fileName);
    //String strDeleteFile = "";
    //File deleteFile = new File(strDeleteFile);

        if (file.exists())
        {
            System.out.println("that file exist");
            System.out.println(file.getPath()+" is the relative path");
            System.out.println("Down below is the absolute path\n" + file.getAbsolutePath());
            //file.delete();
        }
        else
            System.out.println("Cannot find file");

        try {
            FileWriter writer = new FileWriter("text.txt");
            writer.write("Roses are red\nviolets are blue\nbooty booty booty");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fileReader =  new FileReader(file);
            int data = fileReader.read();
            while (data != -1){
                System.out.print((char)data);
                 data = fileReader.read();
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
