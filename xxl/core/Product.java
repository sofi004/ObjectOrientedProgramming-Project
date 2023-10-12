package xxl.core;

public class Product extends IntervalFunction {

    public Product(Range range, String name){
        super(range, name);
    }

    @Override
    protected Literal compute(){
        return new Number(0);
    }

}
