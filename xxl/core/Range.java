package xxl.core;

import java.util.ArrayList;

public class Range {
    private int _beginRow;
    private int _beginColumn;
    private int _endRow;
    private int _endColumn;
    private Spreadsheet _spreadsheet;

    public Range(int beginRow, int beginColumn, int endRow, int endColumn, Spreadsheet spreadsheet){
        _beginRow = beginRow;
        _beginColumn = beginColumn;
        _endRow = endRow;
        _endColumn = endColumn;
        _spreadsheet = spreadsheet;
    }
    /*ArrayList<Cell> getCells(){

    }*/

    public int getBeginRow(){
        return _beginRow;
    }
    public int getBeginColumn(){
        return _beginColumn;
    }
    public int getEndRow(){
        return _endRow;
    }
    public int getEndColumn(){
        return _endColumn;
    }
}


    
