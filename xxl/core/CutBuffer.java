package xxl.core;

import java.io.Serializable;
import java.util.ArrayList;

public class CutBuffer implements Serializable {

    private ArrayList<Cell> _listCells;

    public CutBuffer(ArrayList<Cell> listcell){
        _listCells = listcell;
    }

    public ArrayList<Cell> getListCells(){
        return _listCells;
    }
}