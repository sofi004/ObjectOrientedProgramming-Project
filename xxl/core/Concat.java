package xxl.core;

import java.util.ArrayList;

public class Concat extends IntervalFunction {

    public Concat(Range range, String name){
        super(range, name);
    }

    @Override
    protected Literal compute(){
        ArrayList<Cell> listCells = _range.getListCells();
        String n = "'";
        for(Cell c: listCells){
            try{
            String[] content = c.getContent().asString().split("'", 2);
            n += content[content.length - 1];
            }catch(ArithmeticException e){}
        }
        return new Character(n);
    }

}
