package xxl.core;

import java.io.Serializable;

public class Cell implements Serializable{

    private int _column;
    private int _row;
    private Content _content;

    Literal value(){
        return _content.value();
    }

    public Cell(int row, int column){
        _column = column;
        _row = row;
        _content = new Null();
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
    
    public String toString(){
            return  _row + ";" + _column + "|" + _content.toString(); 
    }

    public Content getContent(){
        return _content;
    }
}
