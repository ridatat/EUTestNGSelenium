package com.cybertek.tests.day10_file_upload;

import org.testng.annotations.Test;

public class FilePathExample {

    @Test
    public void test1(){
        //ödevde sistemi öğrenmiştik
        //System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));


        //  /Users/mac/IdeaProjects/EUTestNGSelenium/src/test/resources/textfile.txt



        //  /Users/mac/IdeaProjects/EUTestNGSelenium
        //System.out.println(System.getProperty("user.dir"));

        String projectPath= System.getProperty("user.dir");
        String filePath="src/test/resources/textfile.txt";

        String fullPath= projectPath+"/"+filePath;
        System.out.println(fullPath);


    }
}
