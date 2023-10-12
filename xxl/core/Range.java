package xxl.core;

import java.util.ArrayList;

import xxl.app.exception.InvalidCellRangeException;

public class Range {
    private int _beginRow;
    private int _beginColumn;
    private int _endRow;
    private int _endColumn;
    private Spreadsheet _spreadsheet;
    private ArrayList<Cell> _listCells;

    public Range(int beginRow, int beginColumn, int endRow, int endColumn, Spreadsheet spreadsheet){
        _beginRow = beginRow;
        _beginColumn = beginColumn;
        _endRow = endRow;
        _endColumn = endColumn;
        _spreadsheet = spreadsheet;
        _listCells = new ArrayList<Cell>();
        getCells();
    }

    ArrayList<Cell> getCells(){

        for(int i = _beginRow; i <= _endRow; i++){
            for(int k = _beginColumn; k <= _endColumn; k++){
                _listCells.add(_spreadsheet.searchCell(i, k));
                }
            }
        return _listCells;
    }

    public ArrayList<Cell> getListCells(){
        return _listCells;
    }

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


    
