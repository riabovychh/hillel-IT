package main.lesson14_Lection_Exception;

public class OwnException extends RuntimeException{
    private String something;

    public OwnException() {
    }

    public OwnException(String message) {
        super(message);
    }

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }
}
