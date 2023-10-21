package xxl.core;

public class CutBuffer {

    private Range _listCells;

    public CutBuffer(Range range){
        _listCells = range;
    }

    public Range getListCells(){
        return _listCells;
    }
}