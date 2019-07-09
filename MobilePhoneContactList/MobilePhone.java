package com.ExampleProject;



import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contacts> contactList;
    private String myNumber;

    public MobilePhone(String myNumber){
        this.contactList = new ArrayList<Contacts>();
        this.myNumber = myNumber;
    }

    public void printOutContacts(){
        System.out.println("Total Contacts: " + contactList.size());
        for(int i = 0; i < contactList.size();i++){
            System.out.println(contactList.get(i).getContactName());
        }
    }

    public boolean addNewContact(Contacts newContact){
        contactList.add(newContact);
        if(queryIfContactExists(newContact) >= 0){
            return true;
        } else {
            return false;
        }
    }

    public boolean updatedExistingContact(String oldContactName, Contacts newContact){
        if(!queryIfContactExists(oldContactName)){
            System.out.println("Old Contact not found");
        }
        int oldContactIndex = findContactIndex(oldContactName);
        contactList.set(oldContactIndex,newContact);
        if(queryIfContactExists(newContact)>= 0){
            return true;
        } else {
            return false;
        }
    }

    public void removeContact(String contactName){
        int contactIndex = findContactIndex(contactName);
        if(contactIndex >= 0){
            contactList.remove(contactIndex);
            System.out.println("Contact removed");
        } else {
            System.out.println("Contact not found");
        }

    }

    public int queryIfContactExists(Contacts contactToCheck){
        for(int i = 0; i < contactList.size();i++){
            if(contactList.get(i).equals(contactToCheck)){
                return i;
            }
        }
        return -1;
    }

    public boolean queryIfContactExists(String name){
        if(findContactIndex(name) >= 0){
            return true;
        }
        return false;
    }

    //============================================= Private Methods ==========================================================

    private int findContactIndex(String name){
        for(int i = 0; i < contactList.size();i++){
            String contactName = contactList.get(i).getContactName();
            if(contactName.equals(name)){
                return i;
            }
        }
        return -1;
    }

}
