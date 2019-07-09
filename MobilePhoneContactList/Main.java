package com.ExampleProject;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("555-555-5555");


    public static void main(String[] args) {
        boolean quit = false;
        while(!quit){
            printAvailableActions();
            int userChoice = scanner.nextInt();
            scanner.nextLine();
            switch(userChoice){
                case 0:
                    quit = true;
                    System.out.println("Closing system. Good bye");
                    break;
                case 1:
                    mobilePhone.printOutContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateExistingContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
            }
        }
    }

    public static void addNewContact(){
        Contacts newContact = newContactCreator();
        mobilePhone.addNewContact(newContact);
    }

    public static void updateExistingContact() {
        System.out.println("Please enter existing contact name to update");
        String existingContactName = scanner.nextLine();
        if (!mobilePhone.queryIfContactExists(existingContactName)) {
            System.out.println("Contact name not found");
        } else {
            Contacts newContact = newContactCreator();
            boolean changeSuccess = mobilePhone.updatedExistingContact(existingContactName, newContact);
            String response = (changeSuccess) ? "Updated successful" : "update failed";
            System.out.println(response);
        }
    }

    public static void removeContact(){
        System.out.println("Please enter name of contact to be removed");
        String removeContact = scanner.nextLine();
        mobilePhone.removeContact(removeContact);
    }

    public static void queryContact(){
        System.out.println("Enter name of contact to search for");
        String searchContactName = scanner.nextLine();
        String response = (mobilePhone.queryIfContactExists(searchContactName))? "Contact found": "contact not found";
        System.out.println(response);
    }

    public static void printAvailableActions(){
        System.out.println("\nAvailable Actions:\npress\n"+
                "0 - To shutdown\n" +
                "1 - To print contacts\n" +
                "2 - To add new contact\n" +
                "3 - To updated existing contact\n"+
                "4 - To remove an existing contact\n" +
                "5 - To query if a contact exists\n");
    }

    private static Contacts newContactCreator(){
        System.out.println("Please enter the new contact name");
        String newContactName = scanner.nextLine();
        System.out.println("Please enter " + newContactName + "'s phone number");
        String newContactPhone = scanner.nextLine();
        return Contacts.createNewContact(newContactName,newContactPhone);
    }





}
