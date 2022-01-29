package ro.fasttrackit.persons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonServiceTest {
    Person person;
    PersonService personService;

    @BeforeEach
    void setup() {
        person = new Person("Alin", 28);
        personService = new PersonService(List.of(
                new Person("David", 20)));
    }

    @Test
    @DisplayName("WHEN try to add a null Person THEN throw exception")
    void testAddNullPerson() {
        NullPointerException e = assertThrows(NullPointerException.class,
                () -> personService.addPerson(null));
        assertThat(e.getMessage()).isEqualTo("You can not add a null person");
    }

    @Test
    @DisplayName("WHEN receiving a valid person THEN inert that person")
    void testAddValidPerson() {
        personService.addPerson(person);
        assertThat(personService.getAllPersons()).contains(person);
    }

    @Test
    @DisplayName("WHEN adding a person THEN generate an id for that person")
    void testGenerateIdOnInsert() {
        Person actual = personService.addPerson(person);
        assertThat(actual.getId()).isNotNull();
        assertThat(actual.getId()).isNotEqualTo(0);
    }

    @Test
    @DisplayName("WHEN removing a person by an id that does not exist THEN throw an exception")
    void testRemovePersonByNonExistentId() {
        PersonDoesNotExistException e = assertThrows(PersonDoesNotExistException.class,
                () -> personService.removePerson(999));
        assertThat(e.getMessage()).isEqualTo("Person does not exist");
    }

    @Test
    @DisplayName("WHEN removing a valid person THEN the size of the list decreases by 1")
    void testRemoveValidPerson() {
        personService.addPerson(person);
        personService.removePerson(2);
        assertThat(personService.getSize()).isEqualTo(1);
    }

    @Test
    @DisplayName("WHEN trying to get a person with an invalid age THEN throw exception")
    void testInvalidAgeOnGetPersonsOlderThan() {
        InvalidParameterException e = assertThrows(InvalidParameterException.class,
                () -> personService.getPersonsOlderThan(125));
        assertThat(e.getMessage()).isEqualTo("You have to insert a valid age.");
    }

    @Test
    @DisplayName("WHEN receiving a valid age THEN return persons older than that age")
    void testValidGetPersonsOlderThan() {
        personService.addPerson(person);
        assertThat(personService.getPersonsOlderThan(25)).containsExactlyInAnyOrder(person);
    }

    @Test
    @DisplayName("WHEN running getAllPersonNames() THEN return all their names")
    void testGetAllPersonNames() {
        personService.addPerson(person);
        assertThat(personService.getAllPersonNames()).containsExactlyInAnyOrder("Alin", "David");
    }

    @Test
    @DisplayName("WHEN giving a valid name to getPerson THEN return the person with that name")
    void testGetPerson() {
        personService.addPerson(person);
        assertThat(personService.getPerson(person.getName())).isEqualTo(person);
    }

    @Test
    @DisplayName("WHEN giving a valid id to getPersonById THEN return the person with that id")
    void testGetPersonById() {
        personService.addPerson(person);
        assertThat(personService.getPersonById(person.getId())).isEqualTo(person);
    }
}
