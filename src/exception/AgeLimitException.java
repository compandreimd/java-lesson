package exception;

public class AgeLimitException extends Exception{
    public AgeLimitException(){
       super("Age Limit Greate than 17");
    }
}
