package ro.fasttrackit.persons;

public class PersonDoesNotExistException extends RuntimeException {
    public PersonDoesNotExistException(String msg){
        super(msg);
    }
}
