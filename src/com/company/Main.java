package com.company;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            var input = new Scanner(System.in);
            System.out.println("Welcome what do you want to do?");
            String s = input.nextLine();

            if (s.equalsIgnoreCase("e")) {
                isRunning = false;
            }
            else
                switch (s.toLowerCase(Locale.ROOT)) {  // .tolowercase to lower chance of wrong input


                    case "help": //
                        System.out.println("type...checkfile,createfile,openfile or e to exit");
                        break;

                    /**
                     * //Checkfile fast way to check if file is correctly in place
                     */
                    case "checkfile":
                        System.out.println("type filename or filepath");
                        String fileName = input.nextLine();

                        File file = new File(fileName);
                        if (file.exists())
                        {
                            System.out.println("that file exist");
                            System.out.println(file.getPath()+" is the relative path");
                            System.out.println("Down below is the absolute path\n" + file.getAbsolutePath());

                        }
                        else
                            System.out.println("Cannot find file");
                        break;

                    /**
                     * With this case you can create a file and fill it with text
                     */
                    case "createfile":
                        System.out.println("what do you want to name the file?");
                        String newFilename = input.nextLine();
                        System.out.println("Write your text...");
                        String newText = input.nextLine();
                        try {
                            FileWriter writer = new FileWriter(newFilename);
                            writer.write(newText);
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;

                    /**
                     * with this case you can open file and print to console until
                     * user puts in correct name or pathname...e to exit
                     */
                    case "openfile":
                        boolean isOpeningFile = true;
                        while (isOpeningFile) {
                            var openFile = new Scanner(System.in);
                            System.out.println("\nwhat file do you want to open?");
                            String open = openFile.nextLine();

                            if (open.equalsIgnoreCase("e")) {
                                isOpeningFile = false;
                            }

                            try {
                                FileReader fileReader =  new FileReader(open);
                                int data = fileReader.read();
                                while (data != -1){
                                    System.out.print((char)data);
                                    data = fileReader.read();
                                }
                                fileReader.close();
                            } catch (FileNotFoundException e) {
                                System.out.println("Cannot find file with that name \n Type e to exit");
                            } catch (IOException e) {
                                e.printStackTrace();

                            }
                        }
                        break;
                    default:
                        System.out.println("not a valid choice, try help");

                }
        }
    }
}
