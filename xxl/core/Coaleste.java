package xxl.core;

public class Coaleste extends IntervalFunction {
    public Coaleste(Range range, String name){
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
