package xxl.core;

import java.io.Serializable;
import java.util.ArrayList;

public class Cell implements Serializable{

    private int _column;
    private int _row;
    private Content _content;
    private ArrayList<Observer> _observers;

    public Cell(int row, int column){
        _column = column;
        _row = row;
        _content = new Null();
        _observers = new ArrayList<Observer>();
    }

    public Literal value(){
        return _content.value();
    }

    public int getRow(){
        return _row;
    }

    public int getCollumn(){
        return _column;
    }

    public void insertContent(Content content){
        _content = content;
        recalcula();
    }
    
    public String toString(){
            return  _row + ";" + _column + "|" + _content.toString(); 
    }

    public Content getContent(){
        return _content;
    }

    public void addObserver(Observer o){
        _observers.add(o);
    }

    public void recalcula(){
        for(Observer o: _observers){
            o.update();
        }
    }

    public boolean visit(Cell cell){
        return true;
    }
}
