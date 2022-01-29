package ro.fasttrackit.persons;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Person {
    private final String name;
    private final int age;
    private int id;

    public Person(String name, int age) {
        handleInvalidNames(name);
        handleInvalidAge(age);
        this.name = name;
        this.age = age;
    }

    private void handleInvalidAge(int age) {
        if (age < 0 || age > 120) {
            throw new InvalidParameterException("You have to insert a valid age.");
        }
    }

    private void handleInvalidNames(String name) {
        if (name == null) {
            throw new NullPointerException("You can not create a person with null as name");
        } else if (name.isEmpty()) {
            throw new InvalidParameterException("You can not create a person with empty string as name");
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
