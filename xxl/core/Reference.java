package xxl.core;

import xxl.app.exception.InvalidCellRangeException;

public class Reference extends Content{
    private int _row;
    private int _column;
    private Spreadsheet _spreadsheet;

    public Reference(int row, int column, Spreadsheet spreadsheet){
        _row = row;
        _column = column;
        _spreadsheet = spreadsheet;
    }

    public String toString(){
           return  _spreadsheet.searchCell(_row, _column).value() + "=" + String.valueOf(_row)+";"+String.valueOf(_column);
    }

    Literal value(){
        return _spreadsheet.searchCell(_row, _column).value();   
    }
}
