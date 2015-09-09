package se.doverfelt.prog2.kap4.uppg3;

/**
 * Filnamn: Person.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-09-09
 */
public class Person {
    private String firstname, surname;
    private int age;

    public String getName() {
        return firstname + " " + surname;
    }

    public void setName(String first, String surname) {
        this.firstname = first;
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String firstname, String surname, int age) {
        this.firstname = firstname;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return surname + ", " + firstname;
    }
}
