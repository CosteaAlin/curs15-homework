package ro.fasttrackit.persons;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private final List<Person> persons = new ArrayList<>();

    public PersonService(List<Person> persons) {
        this.persons.addAll(persons);
    }

    public Person addPerson(Person person) {
        if (person == null) {
            throw new NullPointerException("You can not add a null person");
        }
        person.setId(persons.size() + 1);
        persons.add(person);
        return person;
    }

    public Person removePerson(int id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                persons.remove(person);
                return person;
            }
        }
        throw new PersonDoesNotExistException("Person does not exist");
    }

    public int getSize() {
        return this.persons.size();
    }

    public List<Person> getAllPersons() {
        return new ArrayList<>(persons);
    }

    public List<Person> getPersonsOlderThan(int age) {
        validateAge(age);
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAge() > age) {
                result.add(person);
            }
        }
        return result;
    }

    public List<String> getAllPersonNames() {
        List<String> names = new ArrayList<>();
        for (Person person : persons) {
            names.add(person.getName());
        }
        return names;
    }

    public Person getPerson(String name) {
        for (Person person : persons) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }

    public Person getPersonById(int id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    private void validateAge(int age) {
        if (age < 0 || age > 120) {
            throw new InvalidParameterException("You have to insert a valid age.");
        }
    }
}
