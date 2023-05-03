package unibs;


import com.sun.jdi.Value;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/**
 * @author saleri giorgio
 */
public class MenuManager {

    protected String title;
    protected String[] choices;

    /**
     * @param title
     * @param choice
     */
    public MenuManager(String title, String[] choice) {
        this.title = title;
        this.choices = choice;
    }

    /**
     * print the menu with its entries
     */
    public void printMenu() {
        System.out.println("\n" + title);
        for (int i = 0; i < choices.length; i++) {
            System.out.println(i + 1 + " - " + choices[i]);
        }
        System.out.println("0 - Exit\n");
    }

    /**
     * print the menu and take a int from the user
     */
    public int choose() {
        printMenu();
        return (InputInterface.readInt("Select the number: ", 0, choices.length) - 1);
    }

    public String chooseString() {
        printMenu();
        return choices[(InputInterface.readInt("Select the number: ", 0, choices.length) - 1)];
    }

    public void printMenuNoExit() {
        System.out.println("\n" + title);
        for (int i = 0; i < choices.length; i++) {
            System.out.println(i + 1 + " - " + choices[i]);
        }
    }
    /**
     * print the menu and take a int from the user
     */
    public int chooseNoExit() {
        printMenuNoExit();
        return (InputInterface.readInt("Select the number: ", 1, choices.length) - 1);
    }

    public String chooseStringNoExit() {
        printMenuNoExit();
        return choices[(InputInterface.readInt("Select the number: ", 1, choices.length) - 1)];
    }
}
