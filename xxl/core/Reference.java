package xxl.core;

import java.io.Serializable;

public class Reference extends Content implements Serializable, Observer{
    private int _row;
    private int _column;
    private Spreadsheet _spreadsheet;
    private Cell _cell;
    private Literal _value;

    public Reference(int row, int column, Spreadsheet spreadsheet){
        _row = row;
        _column = column;
        _spreadsheet = spreadsheet;
        _cell = _spreadsheet.getCells().searchCell(row, column);
        _cell.addObserver(this);
        update();
    }

    @Override
    public String toString(){
           return  _cell.value() + "=" + String.valueOf(_row)+";"+String.valueOf(_column);
    }

    public Cell getCell(){
        return _cell;
    }

    @Override
    Literal value(){
        return _value;   
    }

    public void update(){
        _value = _cell.value();
    }

    public boolean accept(Visitor visitor){
        return visitor.visit(this);
    }

}
