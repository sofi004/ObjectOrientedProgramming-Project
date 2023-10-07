package xxl.core;

public class Cell {
    private int _column;
    private int _row;
    private Content _content;


    public Cell(int row, int column){
        _column = column;
        _row = row;
    }

    public int getRow(){
        return _row;
    }

    public int getCollumn(){
        return _column;
    }

    public void insertContent(Content content){
        _content = content;
    }
}
