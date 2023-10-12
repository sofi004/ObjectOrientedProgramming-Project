package xxl.core;

public class Concat extends IntervalFunction {

    public Concat(Range range, String name){
        super(range, name);
    }

    @Override
    protected Literal compute(){
        return new Character("");
    }

}
