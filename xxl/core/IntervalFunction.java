package xxl.core;

public abstract class IntervalFunction extends Function{
    private Range _range;

    public IntervalFunction(Range range, String name){
        super(name);
        _range = range;
    }
    public String toString(){
        String func = "=" + super.getName() + "(" + _range.getBeginRow() + ";" + 
        _range.getBeginColumn() + ":" + _range.getEndRow() + ";" + _range.getEndColumn() + ")"; 
        return func;
    }
}
