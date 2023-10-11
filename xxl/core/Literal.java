package xxl.core;

public abstract class Literal extends Content{
    
    public int  asInt() throws ArithmeticException{
        throw new ArithmeticException();
    }


    public String asString() throws ArithmeticException{
        throw new ArithmeticException();
    }
    
    Literal value(){
        return this;
    }
}
