package com.alienation.coregamefiles.parseinput;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory implements Action {

    private static final ArrayList<String> performAction = new ArrayList<>();

    //try to read file, if not, print stack trace
    static {
        try {
            //locate the cvs txt file w/ synonyms
            String fileLocation = "src" + File.separator + "com" + File.separator + "alienation" +
                    File.separator + "coregamefiles" + File.separator + "parseinput" + File.separator +
                    "inputsynonyms" + File.separator + "inventorySyns.txt";

            //define the file by location
            File synonyms = new File(fileLocation);

            //instantiate scanner to read file
            Scanner synonymScanner = new Scanner(synonyms);

            //add to arraylist
            while((synonymScanner.hasNext())) {
                performAction.add(synonymScanner.nextLine().toUpperCase().trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getPerformAction() {
        return performAction;
    }
}
