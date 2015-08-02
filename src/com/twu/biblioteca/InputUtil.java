package com.twu.biblioteca;
import java.util.Scanner;

public class InputUtil {


        public static int getInputNum() {
            Scanner in = new Scanner(System.in);
            System.out.println("Please input a number:");
            return in.nextInt();
        }


}
