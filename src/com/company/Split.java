package com.company;

import java.util.List;
import java.util.StringJoiner;

/**
 * Created by icondor on 11/19/2016.
 */
public class Split extends Main{
    public static void main(String[] args) {

        Split s = new Split();
        String[] delimitators = {"X","Y","Z"};
        List<String> book = s.readFile("poems.txt");

        int currentDelim=0;

        for(String line: book){

            if(line.equalsIgnoreCase(delimitators[currentDelim])){
                s.writeFile(currentDelim+".txt",line);
                currentDelim++
            }else{
                s.writeFile(currentDelim+".txt",line);
            }
        }


    }



}
