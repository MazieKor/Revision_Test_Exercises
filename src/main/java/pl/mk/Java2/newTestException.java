package pl.mk.Java2;

public class newTestException extends Exception {
    newTestException(String message){
        super(message);
    }

    private static final String MESSAGE_PATTERN = "Entity with id %s can not be found";
    public newTestException(Long id) {
        super(String.format(MESSAGE_PATTERN, id));
    }

}
