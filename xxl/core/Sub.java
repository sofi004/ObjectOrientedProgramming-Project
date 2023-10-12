package xxl.core;

public class Sub extends BinaryFunction {
    public Sub(Content arg0, Content arg1, String name){
        super(arg0, arg1, name);
    }
    
    public String toString(){
        String z = "Example";
        return z;
    }

    protected Literal compute(){
        return new Number(_arg0.value().asInt() - _arg1.value().asInt());
    }
}