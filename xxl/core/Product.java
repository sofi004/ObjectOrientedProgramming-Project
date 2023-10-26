package xxl.core;

import java.util.ArrayList;

public class Product extends IntervalFunction {

    public Product(Range range, String name){
        super(range, name);
        update();
    }

    @Override
    protected Literal compute(){
        ArrayList<Cell> listCells = _range.getListCells();
        int n = 1;
        try{
            for(Cell c: listCells){
                n *= c.value().asInt();
            }
            return new Number(n);
        }catch(ArithmeticException e){
            return new Null().value();
        }
    }

    public boolean accept(Visitor visitor){
        return visitor.visit(this);
    }
}
