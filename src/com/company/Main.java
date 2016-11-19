package com.company;

import java.io.IOException;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Main m = new Main();

        List<String> poem = m.readFile("luceafarul.txt");

        m.printPoem(poem);

        System.out.println("(Adrian)numarul de randuri este: " + m.getRows(poem));
        //System.out.println("(Ionel)numarul de randuri este: "+m.getRowsIonel(poem));
        System.out.println("(Adrian)numarul de cuvinte este: " + m.getWordCount(poem));
        //System.out.println("(Ionel)numarul de cuvinte este: "+m.getWords(poem));

    }

    protected List<String> readFile(String fileName) {

        List<String> poem = new ArrayList<>();
        try {

            Path path = Paths.get("./src/com/company/", fileName);

            Charset charset = Charset.forName("UTF-8");

            poem = Files.readAllLines(path, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return poem;
    }

    protected void printPoem(List<String> poem) {

        for (String line : poem) {
            System.out.println(line);
        }
    }

    protected int getRows(List<String> poem) {
        poem.removeAll(Collections.singleton(""));
        return poem.size();
    }

    protected int getWordCount(List<String> poem) {

        poem.removeAll(Collections.singleton(""));
        int wordCount = 0;
        for (String line : poem) {
            String parts[] = line.split(" ");
            for (String words : parts) {
                System.out.println(words);
            }
            wordCount += parts.length;
        }
        return wordCount;
    }

    protected void writeFile(String fileName,List<String> poem){
        Path path = Paths.get("./src/com/company/", fileName);

        Charset charset = Charset.forName("UTF-8");
        try {
            if(Files.exists(path)) {
                Files.write(path, poem, charset, StandardOpenOption.APPEND);
            }else{
                Files.write(path, poem, charset, StandardOpenOption.CREATE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void writeFile(String fileName,String poem){
        Path path = Paths.get("./src/com/company/", fileName);
        List<String> poemList = new ArrayList<>();
        poemList.add(poem);
        Charset charset = Charset.forName("UTF-8");
        try {
            if(Files.exists(path)) {
                Files.write(path, poemList, charset, StandardOpenOption.APPEND);

            }else{
                Files.write(path, poemList, charset, StandardOpenOption.CREATE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



