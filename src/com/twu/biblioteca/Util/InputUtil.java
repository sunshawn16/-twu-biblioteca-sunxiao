package com.twu.biblioteca.Util;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;

public class InputUtil {


        public static int getInputNum() {
            System.out.println("Please input a number:");
            Scanner in = new Scanner(System.in);
            return in.nextInt();
        }

        public static String  getInputString()throws Exception{

            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            String text = buffer.readLine();
            return text;
        }


}
