package unibs;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author saleri giorgio
 */
public class InputInterface {
    public final static int MAX_INTEGER = Integer.MAX_VALUE;
    public final static int MIN_INTEGER = Integer.MIN_VALUE;
    public final static double MAX_DOUBLE = Double.MAX_VALUE;
    public final static double MIN_DOUBLE = Double.MIN_VALUE;

    private final static String ERROR_MESSAGE = "There was an error, try again";
    private final static String ERROR_NULL_STRING = "You cannot enter an empty string";
    private final static String ERROR_NULL_CHAR = "You cannot enter an empty char";
    private final static String ERROR_OUT_OF_RANGE = "Your value is out of the range %d and %d";
    private final static String ERROR_OUT_OF_RANGE_DOUBLE = "Your value is out of the range %f and %f";
    private final static Scanner SCANNER = new Scanner(System.in);

    /**
     * No one should instantiate this class
     */
    private InputInterface() {

    }

    /**
     * @param message to print
     * @return read string
     */
    public static String readString(String message) {
        System.out.println(message);
        String string = SCANNER.next();
        SCANNER.nextLine();
        return string;
    }

    /**
     * read a string from user and check it is not null
     * @param message to print
     * @return read string
     */
    public static String readNotEmptyString(String message) {
        String readString = null;

        do {
            readString = readString(message);
            if(readString.trim().length() == 0) {
                System.out.println(ERROR_NULL_STRING);
            }
        } while(readString.trim().length() == 0);

        return readString;
    }

    /**
     * read a string from user and check it is not null
     * @param message to print
     * @return read string
     */
    public static String readNotEmptyStringSingleWord(String message) {
        String readString = null;

        do {
            readString = readString(message);
            if(readString.trim().length() != readString.length()) {
                System.out.println(ERROR_NULL_STRING);
            }
        } while(readString.trim().length() != readString.length());

        return readString;
    }

    /**
     * @param message to print
     * @return read int
     */
    public static int readInt(String message) {

        int number = 0;
        boolean finished = false;

        do{
            System.out.println(message);

            try {
                number = SCANNER.nextInt();
                finished = true;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println(ERROR_MESSAGE);
                SCANNER.next();
            }
        } while(!finished);
        SCANNER.nextLine();
        return number;
    }

    /**
     *
     * @param message to print
     * @param begin of range
     *              use MIN_INTEGER to eliminate lower bound
     * @param end of range
     *            use MAX_INTEGER to eliminate upper bound
     * @return read integer
     */
    public static int readInt(String message, int begin, int end) {
        int number;
        do{
            number = readInt(message);
            if(number > end || number < begin) {
                System.out.println(String.format(ERROR_OUT_OF_RANGE, begin, end));
            }
        } while(number > end || number < begin);
        return number;
    }

    /**
     * @param message to print
     * @return read positive int
     */
    public static int readPositiveInt(String message) {
        return readInt(message, 1, MAX_INTEGER);
    }

    /**
     * @param message to print
     * @return read natural int
     */
    public static int readNatualInt(String message) {
        return readInt(message, 0, MAX_INTEGER);
    }

    /**
     * @param message to print
     * @return read double
     */
    public static double readDouble(String message) {
        System.out.println(message);

        double number = 0;
        boolean finished = false;

        do{
            try {
                number = SCANNER.nextDouble();
                finished = true;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println(ERROR_MESSAGE);
                SCANNER.next();
            }
        } while(!finished);
        SCANNER.nextLine();
        return number;
    }

    /**
     * @param message to print
     * @param begin of range
     *              use MIN_DOUBLE to eliminate lower bound
     * @param end of range
     *            use MAX_DOUBLE to eliminate upper bound
     * @return read double
     */
    public static double readDouble(String message, double begin, double end) {
        double number;
        do{
            number = readDouble(message);
            if(number >= end || number <= begin) {
                System.out.println(String.format(ERROR_OUT_OF_RANGE_DOUBLE, begin, end));
            }
        } while(number >= end || number <= begin);
        return number;
    }

    /**
     * @param message to print
     * @return read char
     */
    public static char readChar(String message) {
        char readChar = 0;
        do {
            System.out.println(message);
            String string = SCANNER.next();
            if(string.length() > 0) {
                readChar = string.charAt(0);
                break;
            } else {
                System.out.println(ERROR_NULL_CHAR);
            }
        } while (true);
        return readChar;
    }

    /**
     * ask a true/false yes/no question
     * @param question the question to be printed
     * @param trueAnswer if the user choose this the method will return true
     * @param falseAnswer if the user choose this the method will return false
     * @return true or false based on the user's choice
     */
    public static boolean askTrueOrFalse(String question, String trueAnswer, String falseAnswer) {
        MenuManager menuManager = new MenuManager(question, new String[]{trueAnswer, falseAnswer});
        return menuManager.chooseNoExit() == 0;
    }
}
