package xxl.core;

public abstract class BinaryFunction extends Function{
    private Content _arg0;
    private Content _arg1;

    public BinaryFunction(Content arg0, Content arg1){
        _arg0 = arg0;
        _arg1 = arg1;
    }
}