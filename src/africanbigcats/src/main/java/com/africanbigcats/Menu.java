package com.africanbigcats;

import java.util.*;

/*
 * Menu class for the african big cat app
 */
public class Menu {

    // attributes
    private Scanner input;

    // constructor
    public Menu() {

        // initialize attributes
        this.input = new Scanner(System.in);

    }

    // prints the menu
    public void print() {

        printLine();
        System.out.println("African Big Cats App");
        printLine();

        /*
            TIP:
            In this area of the code, the additional commands need to be created and added to the menu.
        */

        printCommand('c',"[C]reates a big cat");
        printCommand('d',"[D]eletes a big cat");
        printCommand('f',"[F]inds a big cat");
        printCommand('l',"[L]ists all big Cats");
        printCommand('q',"[Q]uits");
        printLine();

    }

    private static void printLine() {
        System.out.println("----------------------------------------------------------" );
    }

    private static void printCommand(Character command, String desc) {
        System.out.printf("%s\t%s\n", command, desc);
    }

    // get first character from input
    public Character getCommand() {

        Character command = '_';

        String rawInput = input.nextLine();
        
        if (rawInput.length() > 0) {
            rawInput = rawInput.toLowerCase();
            command = rawInput.charAt(0);
        }

        return command;

    }

    // command switch
    public Boolean executeCommand(Character command, LinkedList<Panthera> catList) {

        Boolean success = true;

        /*
            TIP:
            In this area of the code, the additional commands need to be created and added.
        */

        switch(command) {

            case 'c':
                executeCreate(catList);
                break;

            case 'l':
                executeList(catList);
                break;

            case 'q':
                executeQuit();
                break;

            default:
                System.out.println("ERROR: Unknown commmand");
                success = false;
          }

        return success;
    }

    // update the position of all the cats
    public void update(LinkedList<Panthera> catList) {

        // update by moving all the cats
        for (Panthera cat: catList) {
            cat.move();
        }

    }

    // quit the app
    public void executeQuit() {

        // close the scannner
        input.close();
        System.out.println();
        printLine();
        System.out.println("Thank you for using the African Big Cats App!");
        printLine();
        System.out.println();

    }

    public Panthera getNewCat(String name) {
        
        /*
            TIP:
            In this area of the code, students need to get input from the user for the type of cat 
            and create the correct type.

            Currently, the code always create a Tiger.  But, support for Lions and Jaguars
            also needs to be added.

        */
        System.out.print("Enter 1 for Tiger, 2 for Lion, 3 for Jaguar: ");
        Character catChoice = getCommand();
        Panthera result = null;
        if (catChoice == '1'){
            result = new Tiger(name);
            System.out.println(String.format("\nSTATUS: %s has been added.", result.name()));
            return result;
        }

        else if (catChoice == '2'){
            result = new Lion(name);
            System.out.println(String.format("\nSTATUS: %s has been added.", result.name()));
            return result;
        }

        else if (catChoice == '3'){
            result = new Jaguar(name);
            System.out.println(String.format("\nSTATUS: %s has been added.", result.name()));
            return result;
        }

        else{
            result = new Tiger(name);
            System.out.print(String.format("\nERROR: invalid big cat type. Creating a tiger named %s", result.name()));
            System.out.println(String.format("\nSTATUS: %s has been added.", result.name()));
            return result;
        }
    }

    // create a cat, if it's unique
    public void executeCreate(LinkedList<Panthera> catList) {

        // get the name
        System.out.println();
        System.out.print("Enter a name for the big cat to create: ");
        String name = input.nextLine();
        System.out.println();

        /*
            TIP:
            In this area of the code, students would need to add in checking if the cat name already exists in order to prevent duplicates
        */
        int listSize = catList.size();
        if (listSize > 0){
            for (int i = 0; i < listSize; i++){
                if (catList.get(i).name().equals(name)){
                    System.out.println(String.format("Cat name %s has been used, can not create another cat name %s", name, name));
                    return;
                }
            }
        }
        Panthera cat = getNewCat(name);
        catList.add(cat);
    }

    // list all big cats 
    public void executeList(LinkedList<Panthera> catList) {

        System.out.println();
        printLine();
        System.out.println("African Big Cat List");
        printLine();

        Panthera cat;
        if (catList.size() > 0) {
            for (Integer i = 0; i < catList.size(); i++) {
                cat = catList.get(i);
                System.out.print(String.format("#%03d ", i+1));
                System.out.println(cat);
            }
        } else {
            System.out.println("There are no African Big Cats. :(");
        }

        System.out.println();
    }

    /*
        TIP:
        Additional methods and functionality need to be added to this class.
    */


}
