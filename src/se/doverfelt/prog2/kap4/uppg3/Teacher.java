package se.doverfelt.prog2.kap4.uppg3;

/**
 * Filnamn: Teacher.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-09-09
 */
public class Teacher extends Person {

    private String[] subjects;

    public Teacher(String firstname, String surname, int age, String[] subjects) {
        super(firstname, surname, age);
        this.subjects = subjects;
    }

    public void removeSubject(String subject) {
        String[] old = subjects;
        String[] newSub = new String[old.length-1];
        for (int i = 0, k = 0; i < old.length; i++) {
            if (!old[i].equals(subject)) {
                k++;
                newSub[k] = old[i];
            }
        }
        newSub[old.length-2] = subject;
        subjects = newSub;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public void addSubject(String subject) {
        String[] old = subjects;
        String[] newSub = new String[old.length+1];
        for (int i = 0; i < old.length; i++) {
            newSub[i] = old[i];
        }
        newSub[old.length] = subject;
        subjects = newSub;
    }

    public String[] getSubjects() {
        return subjects;
    }
}
