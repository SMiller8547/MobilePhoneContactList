package com.ExampleProject;

public class Contacts {
    private String contactName;
    private String contactPhoneNumber;

    public Contacts(String name, String phoneNumber){
        this.contactName = name;
        this.contactPhoneNumber = phoneNumber;
    }

    public String getContactName(){
        return this.contactName;
    }

    public String getContactPhoneNumber(){
        return this.contactPhoneNumber;
    }

    public static Contacts createNewContact(String name, String phoneNumber){
       return new Contacts(name,phoneNumber);
    }
}
