package datamodel;

import java.util.LinkedList;
import java.util.List;

/**
 * Class of entity type <i>Customer</i>.
 * 
 * @version <code style=color:green>{@value application.package_info#Version}</code>
 * @author <code style=color:blue>{@value application.package_info#Author}</code>
 */
public class Customer {
    private long id = -1;
    private String lastName = " ";
    private String firstName = " ";
    private final List<String> contacts = new LinkedList<>();;
    boolean IDisSet = false;

    /**
     * Default constructor.
     */
    public Customer(String first, String Last) {
        firstName= first;
        lastName = Last;
    }
    
    public Customer(String name) {
        contacts.add(name);
    }

    public Customer setid(long id){
        if(!IDisSet && id > -1){
        this.id = id;
        }

        return this;
    }

    public long getid(){
        return id;
    
    }

    public String getFirstName(){
        return firstName;
    }

    public Customer setName(String firstName, String lastName){
        return new Customer(firstName,lastName);
    }

    public String getLasttName(){
        return  lastName;
    }

    public Customer setName(String name){
        return new Customer(name);
    }

    public int contactsCount(){
        int count = 0;
        for (int i = 0; i < contacts.size(); i++) {
            count++;
        }

        return count;
    }

    public String[] getContact(){
        return null;
    }

    public Customer addContact(String contact){
        return new Customer(contact);
    }

    public void deleteContact(int i){
         contacts.remove(i);
    }

    public void deleteAllContacts(){
      contacts.removeAll(contacts);
    }

    private Customer splitName(String name){
        String[] split = name.split(" ");
        return new Customer(split[0], split[1]);
    }

}
