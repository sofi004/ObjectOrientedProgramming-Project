package xxl.core;

public class Average extends IntervalFunction {
    public Average(Range range, String name){
        super(range, name);
    }
    
    public String toString(){
        String z = "Example";
        return z;
    }

    protected Literal compute(){
        return new Number(0);
    }
}
