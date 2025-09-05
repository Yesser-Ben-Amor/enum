package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersonRepository {

    private final List<Person> personList = new ArrayList<>();
    private final Map<Integer, Person> personMap = new HashMap<>();

    public void addPerson(Person person) {
        personList.add(person);
        personMap.put(person.id(), person);
    }

    // Methode die ein Optional zurückgibt optinal Aufgabe
    public Optional<Person> findPersonById(int id) {
        return Optional.ofNullable(personMap.get(id));
    }

    // Alternative: Mit List statt Map (wenn nur List verwendet wird)
    public Optional<Person> findPersonByIdUsingList(int id) {
        return personList.stream()
                .filter(person -> person.id() == id)
                .findFirst();
    }

    public List<Person> getAllPersons() {
        return new ArrayList<>(personList);
    }

    public List<Person> getPersonsByFavoriteDay(DaysOfWeek day) {
        List<Person> result = new ArrayList<>();
        for (Person person : personList) {
            if (person.favoriteDay() == day) {
                result.add(person);
            }
        }
        return result;
    }

    public boolean removePerson(int id) {
        Person person = personMap.remove(id);
        if (person != null) {
            return personList.remove(person);
        }
        return false;
    }

    public int getPersonCount() {
        return personList.size();
    }
}