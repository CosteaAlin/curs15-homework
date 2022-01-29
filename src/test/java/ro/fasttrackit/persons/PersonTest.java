package ro.fasttrackit.persons;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {

    @Test
    @DisplayName("WHEN creating a person with null as name THEN throw exception")
    void testNullString() {
        NullPointerException e = assertThrows(NullPointerException.class, () -> new Person(null, 20));
        assertThat(e.getMessage()).isEqualTo("You can not create a person with null as name");
    }

    @Test
    @DisplayName("WHEN creating a person with empty string as name THEN throw exception")
    void testEmptyString() {
        InvalidParameterException e = assertThrows(InvalidParameterException.class, () -> new Person("", 20));
        assertThat(e.getMessage()).isEqualTo("You can not create a person with empty string as name");
    }

    @Test
    @DisplayName("WHEN creating a person with invalid age THEN throw exception")
    void testInvalidAge() {
        InvalidParameterException e = assertThrows(InvalidParameterException.class, () -> new Person("Alin",-1));
        assertThat(e.getMessage()).isEqualTo("You have to insert a valid age.");
    }

}
