package xxl.core;

import java.util.ArrayList;

public class CutBuffer {

    private ArrayList<Cell> _listCells;

    public CutBuffer(ArrayList<Cell> listcell){
        _listCells = listcell;
    }

    public ArrayList<Cell> getListCells(){
        return _listCells;
    }
}