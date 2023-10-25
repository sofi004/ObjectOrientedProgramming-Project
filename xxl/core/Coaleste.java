package xxl.core;

import java.util.ArrayList;

public class Coaleste extends IntervalFunction {

    public Coaleste(Range range, String name){
        super(range, name);
    }

    @Override
    protected Literal compute(){
        ArrayList<Cell> listCells = _range.getListCells();
        for(Cell c: listCells){
            try{
                String content = c.getContent().asString();
                return new Character(content);
            }catch(ArithmeticException e){
                continue;
            }
        }
        return new Character("'");
    }
}
