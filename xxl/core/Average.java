package xxl.core;

public class Average extends IntervalFunction {

    public Average(Range range, String name){
        super(range, name);
    }

    @Override
    protected Literal compute(){
        return new Number(0);
    }

}
