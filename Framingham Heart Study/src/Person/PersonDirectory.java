/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import java.util.ArrayList;

/**
 *
 * @author Rohan Jahagirdar, Bhanuja Nagore, Manish Patil
 */
public class PersonDirectory {
    private ArrayList<Person> persons;

    public PersonDirectory() {
        persons = new ArrayList<>();
    }
    
    
    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }
    
    public Person addPerson() {
        Person person = new Person();
        persons.add(person);
        return person;
    }    
}
