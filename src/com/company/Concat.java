package com.company;

import java.nio.file.Files;
import java.util.List;

/**
 * Created by icondor on 11/19/2016.
 */
public class Concat extends Main{

    public static void main(String[] args) {

        Concat c = new Concat();
        String[] poemsFileNames = {"catelus.txt","luceafarul.txt","plumb.txt"};
        for (String eachPoem: poemsFileNames){
            List<String> poem = c.readFile(eachPoem);
            c.writeFile("poems.txt",poem);
        }
    }



}
