package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonRepository {

    // Version mit List
    private final List<Person> personList = new ArrayList<>();

    // Version mit Map (optional, für schnellen Zugriff per ID)
    private final Map<Integer, Person> personMap = new HashMap<>();

    // Person zur Liste hinzufügen
    public void addPerson(Person person) {
        personList.add(person);
        personMap.put(person.id(), person);
    }

    // Person anhand der ID finden
    public Person findPersonById(int id) {
        return personMap.get(id);
    }

    // Alle Personen zurückgeben
    public List<Person> getAllPersons() {
        return new ArrayList<>(personList); // Rückgabe einer Kopie
    }

    // Personen nach Lieblingswochentag filtern
    public List<Person> getPersonsByFavoriteDay(DaysOfWeek day) {
        List<Person> result = new ArrayList<>();
        for (Person person : personList) {
            if (person.favoriteDay() == day) {
                result.add(person);
            }
        }
        return result;
    }

    // Person anhand der ID entfernen
    public boolean removePerson(int id) {
        Person person = personMap.remove(id);
        if (person != null) {
            return personList.remove(person);
        }
        return false;
    }

    // Anzahl der Personen
    public int getPersonCount() {
        return personList.size();
    }
}
