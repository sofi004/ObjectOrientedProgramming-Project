package xxl.core;

public class Add extends BinaryFunction {

    public Add(Content arg0, Content arg1, String name){
        super(arg0, arg1, name);
    }

    @Override
    protected Literal compute(){
        return new Number(_arg0.value().asInt() + _arg1.value().asInt());
    }

}
