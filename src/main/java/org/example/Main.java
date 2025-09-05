package org.example;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println(DaysOfWeek.workDayOrWeekend(DaysOfWeek.SATURDAY));
        System.out.println(DaysOfWeek.workDayOrWeekend(DaysOfWeek.MONDAY));

        // PersonRepository erstellen
        PersonRepository repository = new PersonRepository();

        // Personen hinzufügen
        repository.addPerson(new Person(1, "Ali Baba", DaysOfWeek.MONDAY));
        repository.addPerson(new Person(2, "Ben Amor", DaysOfWeek.SATURDAY));
        repository.addPerson(new Person(3, "test", DaysOfWeek.FRIDAY));
        repository.addPerson(new Person(4, "Ronaldo", DaysOfWeek.SUNDAY));

        // Suche nach Person mit ID 2
        System.out.println("Suche nach Person mit ID 2:");
        Optional<Person> personOptional = repository.findPersonById(2);

        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            printPersonDetails(person);
        } else {
            System.out.println("Person nicht gefunden");
        }

        System.out.println("\nSuche nach Person mit ID 99:");
        Optional<Person> notFoundOptional = repository.findPersonById(99);

        if (notFoundOptional.isPresent()) {
            Person person = notFoundOptional.get();
            printPersonDetails(person);
        } else {
            System.out.println("Person nicht gefunden");
        }

        // Alle Personen ausgeben
        System.out.println("\nAlle Personen:");
        for (Person person : repository.getAllPersons()) {
            String dayType = DaysOfWeek.workDayOrWeekend(person.favoriteDay());
            System.out.println(person.name() + " mag " + dayType);
        }

        // Personen nach Lieblingstag filtern
        System.out.println("\nPersonen die Samstag mögen:");
        for (Person person : repository.getPersonsByFavoriteDay(DaysOfWeek.SATURDAY)) {
            System.out.println(person.name());
        }

        // Person per ID finden
        Optional<Person> personOptional3 = repository.findPersonById(3);
        if (personOptional3.isPresent()) {
            Person person = personOptional3.get();
            System.out.println("\nPerson mit ID 3: " + person.name());
        } else {
            System.out.println("\nPerson mit ID 3 nicht gefunden");
        }
    }

    // Separate Methode zum Ausgeben der Personendetails
    private static void printPersonDetails(Person person) {
        String dayType = DaysOfWeek.workDayOrWeekend(person.favoriteDay());
        System.out.println("Gefunden: " + person.name());
        System.out.println("Lieblingstag: " + person.favoriteDay() + " (" + dayType + ")");
    }
}