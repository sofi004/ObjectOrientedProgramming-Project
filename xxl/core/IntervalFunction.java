package xxl.core;

public abstract class IntervalFunction extends Function{
    protected Range _range;

    public IntervalFunction(Range range, String name){
        super(name);
        _range = range;
        addRecalculate();
    }

    @Override
    public String toString(){
        String func = compute().toString() + "=" + super.getName() + "(" + _range.getBeginRow() + ";" + 
        _range.getBeginColumn() + ":" + _range.getEndRow() + ";" + _range.getEndColumn() + ")"; 
        return func;
    }

    public void addRecalculate(){
        for(Cell c: _range.getListCells()){
            c.addObserver(this);
        }
    }

}
