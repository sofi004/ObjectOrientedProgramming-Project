package xxl.core;

import java.util.ArrayList;

public class Average extends IntervalFunction {

    public Average(Range range, String name){
        super(range, name);
        update();
    }

    @Override
    protected Literal compute(){
        ArrayList<Cell> listCells = _range.getListCells();
        int n = 0;
        try{
            for(Cell c: listCells){
                n += c.value().asInt();
            }
            n /= listCells.size();
            return new Number(n);
        }catch(ArithmeticException e){
            return new Null().value();
        }
    }

}
