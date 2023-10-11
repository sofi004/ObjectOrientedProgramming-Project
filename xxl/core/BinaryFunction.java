package xxl.core;

public abstract class BinaryFunction extends Function{
    protected Content _arg0;
    protected Content _arg1;

    public BinaryFunction(Content arg0, Content arg1, String name){
        super(name);
        _arg0 = arg0;
        _arg1 = arg1;
    }

    public String toString(){
        String func = compute().toString() + "=" + super.getName() + "(" + _arg0.toString() + "," + _arg1.toString() + ")"; 
        return func;
        
    }
    public Content getFirstArg(){
        return _arg0;
    }
    public Content getSecondArg(){
        return _arg1;
    }
}