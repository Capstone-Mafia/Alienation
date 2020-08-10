package com.alienation.coregamefiles.parseinput;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class North implements Action {

    private static final ArrayList<String> performAction = new ArrayList<>();

    {
        String fileName = "src/com/alienation/resources/northSyns.txt";
        try {
            InputStream is = getClass().getResourceAsStream(fileName);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String contents = br.lines().collect(Collectors.joining(System.lineSeparator()));

            //define file
            File synonyms = new File(contents);
            //instantiate scanner to read file
            Scanner synonymScanner = new Scanner(synonyms);

            //add to arraylist
            while((synonymScanner.hasNext())) {
                performAction.add(synonymScanner.nextLine().toUpperCase().trim());
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
//                    "inputsynonyms" + File.separator + "northSyns.txt";
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
