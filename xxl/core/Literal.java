package xxl.core;

public abstract class Literal extends Content{
    
    @Override
    public int  asInt() throws ArithmeticException{
        throw new ArithmeticException();
    }

    @Override
    public String asString() throws ArithmeticException{
        throw new ArithmeticException();
    }
    
    @Override
    Literal value(){
        return this;
    }

    public boolean visit(Literal literal){
        return true;
    }

}
