package datamodel;
import java.util.*;

/**
 * Class of entity type <i>Customer</i>.
 * <p>
 * Customer is a person who creates and holds (owns) orders in the system.
 * </p>
 * 
 * @version <code style=color:green>{@value application.package_info#Version}</code>
 * @author <code style=color:blue>{@value application.package_info#Authorr}</code>
 */
public class Customer {

    /**
     * Unique Customer id attribute, {@code id < 0} is invalid, id can only be set once.
     */
    private long id = -1;

    /**
     * Customer's surname attribute, never null.
     */
    private String lastName = "";

    /**
     * None-surname name parts, never null.
     */
    private String firstName = "";

    boolean IDisSet = id < 0;

    /**
     * Customer contact information with multiple contacts.
     */
    private final List<String> contacts = new LinkedList<>();

    /**
     * Default constructor.
     */
    public Customer(String first, String Last) {
        firstName= first;
        lastName = Last;
    }
    
 
    /**
     * Constructor with single-String name argument.
     * @param name single-String Customer name, e.g. "Eric Meyer".
     * @throws IllegalArgumentException if name argument is null.
     */
    public Customer(String name) {
        if(name == null){
            throw new IllegalArgumentException();
        }

        setName(name);
        }

    /**
    /**
     * Id getter.
     * @return customer id, returns {@code null}, if id is unassigned.
     */
    public long getid(){

        if(id > -1){
        return id;
        } else {
            return (Long) null;
        }

    }

    /**
     * Id setter. Id can only be set once with valid id, id is immutable after assignment.
     * @param id value to assign if this.id attribute is still unassigned {@code id < 0} and id argument is valid.
     * @throws IllegalArgumentException if id argument is invalid ({@code id < 0}).
     * @return chainable self-reference.
     */
 

     public Customer setid(long id){
        if(!IDisSet && id > -1){
         this.id = id;
         return this;
        }

        throw new IllegalArgumentException();
    }

    /**
     * LastName getter.
     * @return value of lastName attribute, never null, mapped to "".
     */
    public String getLastName() {
        if(lastName == null){
            return "";
        }
        return  lastName;
    }

    /**
     * FirstName getter.
     * @return value of firstName attribute, never null, mapped to "".
     */
    public String getFirstName() {
        if(firstName == null){
            return "";
        }
        return firstName;
    }

    /**
     * Setter that splits a single-String name (for example, "Eric Meyer") into first-
     * ("Eric") and lastName ("Meyer") parts and assigns parts to corresponding attributes.
     * @param first value assigned to firstName attribute, null is ignored.
     * @param last value assigned to lastName attribute, null is ignored.
     * @return chainable self-reference.
     */
    public Customer setName(String first, String last) {
        if(first == null){
            first = "";
        }
        if(last == null){
            last = "";
        }
      new Customer(firstName,lastName);

      return this;
    }

    /**
     * Setter that splits a single-String name (e.g. "Eric Meyer") into first- and
     * lastName parts and assigns parts to corresponding attributes.
     * @param name single-String name to split into first- and lastName parts.
     * @throws IllegalArgumentException if name argument is null.
     * @return chainable self-reference.
     */
    public Customer setName(String name) {
            if(name == null){
                throw new IllegalArgumentException();
            }


       splitName(name);

        return this;
    }

    /**
     * Return number of contacts.
     * @return number of contacts.
     */
    public int contactsCount() {
        int count = 0;
        for (int i = 0; i < contacts.size(); i++) {
            count++;
        }

        return count;
    }

    /**
     * Contacts getter (as {@code String[]}).
     * @return contacts (as {@code String[]}).
     */
    public String[ ] getContacts() {
        String[] cont = new String[contacts.size()];
        
        int count = 0;

        for (String string : contacts) {
            count++;

            cont[count] = string;
        }
        
        return cont;
    }

    /**
     * Add new contact for Customer. Only valid contacts (not null, "" nor duplicates) are added.
     * @param contact valid contact (not null or "" nor duplicate), invalid contacts are ignored.
     * @throws IllegalArgumentException if contact argument is null or empty "" String.
     * @return chainable self-reference.
     */
    public Customer addContact(String contact) {
        if(contact != null && !contact.isEmpty() && !contact.contains(contact)){
        contacts.add(contact);
        return this;
        }

        throw new IllegalArgumentException();        
    }

    /**
     * Delete the i-th contact with {@code i >= 0} and {@code i < contactsCount()}, otherwise method has no effect.
     * @param i index of contact to delete.
     */
    public void deleteContact(int i) {
        if(i > 0 && i < contactsCount()){
        contacts.remove(i);
        }
    }

    /**
     * Delete all contacts.
     */
    public void deleteAllContacts() {
        contacts.removeAll(contacts);
    }

    /**
     * Split single-String name into last- and first name parts.
     * @param name single-String name to split into first- and last name parts.
     * @throws IllegalArgumentException if name argument is null.
     * @return chainable self-reference.
     */
    private Customer splitName(String name) {
        if(name == null){
            throw new IllegalArgumentException();
        }
        String[] split = name.split(" ");
        setName(split[0], split[1]);
        return this;
    }

}