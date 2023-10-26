package xxl.core;

import java.util.ArrayList;

public class Coalesce extends IntervalFunction {

    public Coalesce(Range range, String name){
        super(range, name);
        update();
    }

    @Override
    protected Literal compute(){
        ArrayList<Cell> listCells = _range.getListCells();
        String n = "'";
        for(Cell c: listCells){
            try{
                n = c.getContent().asString();
                return new Character(n);
            }catch(ArithmeticException e){
                continue;
            }
        }
        return new Character(n);
    }

    public boolean accept(Visitor visitor){
        return visitor.visit(this);
    }
}
