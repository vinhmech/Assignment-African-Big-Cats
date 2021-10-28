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
        printCommand('r',"[R]isk report");
        printCommand('w',"[W]arning report");
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
        
        if (rawInput.length() > 1 || rawInput.length() == 0) {
            return '_';
        }

        else {
            rawInput = rawInput.toLowerCase();
            command = rawInput.charAt(0);
            return command;
        }

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

            case 'd':
                executeDelete(catList);
                break;

            case 'f':
                executeFind(catList);
                break;

            case 'l':
                executeList(catList);
                break;
                
            case 'r':
                executeRiskReport(catList);
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

            Currently, the code always create a Tiger. But, support for Lions and Jaguars
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

    // delete a cat based on cat name
    public void executeDelete(LinkedList<Panthera> catList){
        int listSize = catList.size();
        if (listSize == 0){
            System.out.println("Fail to delete, there is no cat in the list to delete");
            System.out.println();
        }
        else{
            // get the name
            System.out.println();
            System.out.print("Delete cat name: ");
            String name = input.nextLine();
            System.out.println();

            boolean wasRemoved = false;
            for (int i = 0; i < listSize; i++){
                if (catList.get(i).name().equals(name)){
                    catList.remove(i);
                    wasRemoved = true;
                    System.out.println(String.format("Delete sucessful, %s has been removed", name));
                    System.out.println();
                    break;
                }
            }
            if (wasRemoved == false){
                System.out.println(String.format("Fail to delete, there is no cat name %s to delete", name));
                System.out.println();
            }
        }
    }

    // find cat based on cat name or part of cat name
    public void executeFind(LinkedList<Panthera> catList){
        // get the name
        System.out.println();
        System.out.print("Find cat name: ");
        String name = input.nextLine();
        System.out.println();

        int listSize = catList.size();
        boolean catFound = false;
        if(listSize > 0){
            for (int i = 0; i < listSize; i++){
                if(catList.get(i).name().contains(name)){
                    System.out.println(catList.get(i));
                    catFound = true;
                }
            }
            if (catFound == false){
                System.out.println(String.format("Keyword %s is not related to any cat name", name));
                System.out.println();
            }
        }
        else {
            System.out.println("Fail to find cat, there is no cat in the list to find");
            System.out.println();
        }
    }


    // find distance between two coordinates
    public Double calculateDistance(Float lattitude1, Float longitude1, Float lattitude2, Float longitude2){
        Double distance = Math.sqrt(Math.pow((lattitude2 - lattitude1), 2) + Math.pow((longitude2 - longitude1), 2));
        return distance;
    }

    // check if a specific cat name is on the list and return that cat object
    public Panthera isCatOnTheList(String name, LinkedList<Panthera> catList){
        int listSize = catList.size();
        if (listSize > 0){
            for (int i = 0; i < listSize; i++){
                if(catList.get(i).name().equals(name)){
                    return catList.get(i);
                }
            }
            return null;
        }
        else {
            return null;
        }
    }

    // execute risk report
    public void executeRiskReport(LinkedList<Panthera> catList){
        int listSize = catList.size();
        if (listSize < 2){
            System.out.println(String.format("We have %d cat in the list, we need at least 2 cats in the tracking list to generate risk report", listSize));
            System.out.println();
            return;
        }

        // get the name
        System.out.println();
        System.out.print("Enter a name for the first big cat: ");
        String firstCatName = input.nextLine();
        Panthera firstCat = isCatOnTheList(firstCatName, catList);
        if (firstCat == null){
            System.out.println(String.format("Your first big cat %s is not on the tracking list, can not generate risk report", firstCatName));
            return;
        }

        System.out.println();
        System.out.print("Enter a name for the second big cat: ");
        String secondCatName = input.nextLine();
        Panthera secondCat = isCatOnTheList(secondCatName, catList);
        if (secondCat == null){
            System.out.println(String.format("Your second big cat %s is on not the tracking list, can not generate risk report", secondCatName));
            return;
        }

        Double distanceBetweenTwoCat = calculateDistance(firstCat.latitude(), firstCat.longitude(),
        secondCat.latitude(), secondCat.longitude());

        System.out.println();
        printLine();
        System.out.println("African Big Cats Risk Report");
        printLine();
        System.out.println(firstCat);
        System.out.println(secondCat);
        printLine();
        System.out.println(String.format("The distance between %s and %s is %.2f", firstCatName, secondCatName, distanceBetweenTwoCat));
        System.out.println();
        return;
    }

}
