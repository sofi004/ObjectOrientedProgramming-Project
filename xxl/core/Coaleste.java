package xxl.core;

public class Coaleste extends IntervalFunction {

    public Coaleste(Range range, String name){
        super(range, name);
    }

    @Override
    protected Literal compute(){
        return new Number(0);
    }

}
