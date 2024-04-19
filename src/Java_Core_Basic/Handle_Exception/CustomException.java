package Java_Core_Basic.Handle_Exception;

public class CustomException extends RuntimeException{
    public CustomException(String msg){
        super(msg);
    }
    
    public CustomException(Throwable cause){
        super(cause);
    }
    
    public CustomException(String msg, Throwable cause){
        super(msg, cause);
    }
}
