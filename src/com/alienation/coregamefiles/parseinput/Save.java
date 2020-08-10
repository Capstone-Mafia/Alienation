package com.alienation.coregamefiles.parseinput;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Save implements Action {

    private static final ArrayList<String> performAction = new ArrayList<>();

    static {
        try {
            try (InputStream inputStream = Look.class.getResourceAsStream("/saveSyns.txt");
                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

                String contents = reader.lines().collect(Collectors.joining(System.lineSeparator()));

                //define file
                File synonyms = new File(contents);
                //instantiate scanner to read file
                Scanner synonymScanner = new Scanner(synonyms);

                //add to arraylist
                while((synonymScanner.hasNext())) {
                    performAction.add(synonymScanner.nextLine().toUpperCase().trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    //try to read file, if not, print stack trace
//    static {
//        try {
//            //locate the cvs txt file w/ synonyms
//            String fileLocation = "src" + File.separator + "com" + File.separator + "alienation" +
//                    File.separator + "coregamefiles" + File.separator + "parseinput" + File.separator +
//                    "inputsynonyms" + File.separator + "saveSyns.txt";
//
//            //define the file by location
//            File synonyms = new File(fileLocation);
//
//            //instantiate scanner to read file
//            Scanner synonymScanner = new Scanner(synonyms);
//
//            //add to arraylist
//            while((synonymScanner.hasNext())) {
//                performAction.add(synonymScanner.nextLine().toUpperCase().trim());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static ArrayList<String> getPerformAction() {
        return performAction;
    }
}
