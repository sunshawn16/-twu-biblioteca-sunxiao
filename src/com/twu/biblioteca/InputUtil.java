package com.twu.biblioteca;
import java.util.Scanner;

public class InputUtil {


        public static int getInputNum() {
            System.out.println("Please input a number:");
            Scanner in = new Scanner(System.in);
            return in.nextInt();
        }


}
