package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(DaysOfWeek.workDayOrWeekend(DaysOfWeek.SATURDAY));
        System.out.println(DaysOfWeek.workDayOrWeekend(DaysOfWeek.MONDAY));
        // PersonRepository erstellen
        PersonRepository repository = new PersonRepository();

        // Personen hinzufügen
        repository.addPerson(new Person(1, "ALi Baba", DaysOfWeek.MONDAY));
        repository.addPerson(new Person(2, "Ben Jakow", DaysOfWeek.SATURDAY));
        repository.addPerson(new Person(3, "Yesser Ben Amor", DaysOfWeek.FRIDAY));
        repository.addPerson(new Person(4, "Ronaldo", DaysOfWeek.SUNDAY));

        // Alle Personen ausgeben
        System.out.println("Alle Personen:");
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
        Person person = repository.findPersonById(3);
        if (person != null) {
            System.out.println("\nPerson mit ID 3: " + person.name());
        }

    }
}