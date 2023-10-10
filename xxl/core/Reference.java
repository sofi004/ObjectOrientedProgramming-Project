package xxl.core;

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
        return String.valueOf(_row)+";"+String.valueOf(_column);
    }
}
