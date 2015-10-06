package se.doverfelt.prog2.kap3.uppg3_9;

/**
 * Filnamn: Degrees.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-09-23
 */
public enum Degrees {
    GENERAL("General"), GENERALLOJTNANT("Generallöjtnant"), GENERALMAJOR("Generalmajor"), OVERSTE("Överste"),
    OVERSTELOJTNANT("Överstelöjtnant"), MAJOR("Major"), KAPTEN("Kapten"), LOJTNANT("Löjtnant"), FANRIK("Fänrik"), FANJUNKARE("Fanjunkare"),
    SERGEANT("Sergeant"), OVERFURIR("Överfurir"), FURIR("Furir"), KORPRAL("Korpral"), MENIG("Menig");

    public final String degree;

    Degrees(String s) {
        degree = s;
    }

    public String toString() {
        return degree;
    }

}
