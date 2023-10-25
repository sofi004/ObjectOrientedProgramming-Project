package xxl.core;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

import pt.tecnico.uilib.Display;
import xxl.app.exception.InvalidCellRangeException;

/**
 * Class representing a spreadsheet.
 */
public class Spreadsheet implements Serializable {
  @Serial
  private static final long serialVersionUID = 202308312359L;
  
  private int _height;
  private int _width;
  private boolean _saved;
  private CutBuffer _cutBuffer;
  private Cell[][] _listCells;
  private String _name;
  private boolean _named;


  public Spreadsheet(int row, int column){
    _height = row;
    _width = column;
    _saved = false;
    _listCells = new Cell[row][column];
    createListCell();
    _named = false;
  }

    public String getFileName(){
      return _name;
    }

  public boolean isNamed(){
    return _named;
  }


  public void setName(String name){
    _name = name;
    _named = true;
  }

  public int getHeight(){
    return _height;
  }


  public int getWidth(){
    return _width;
  }


  public boolean isSaved(){
    return _saved;
  }


  public void setSaved(boolean val){
    _saved = val;
  }

  public CutBuffer getCutBuffer(){
    return _cutBuffer;
  }

  public void createListCell(){
    for(int i = 0; i < _height; i++){
      for(int j = 0; j < _width; j++){
        _listCells[i][j] = new Cell(i + 1, j + 1);
      }
    }
  }


  public Range buildRange(String rangeDescription) throws InvalidCellRangeException{
    String[] rangeCoordinates;
    int firstRow, firstColumn, lastRow, lastColumn;
    if (rangeDescription.indexOf(':') != -1) {
      rangeCoordinates = rangeDescription.split("[:;]");
      firstRow = Integer.parseInt(rangeCoordinates[0]);
      firstColumn = Integer.parseInt(rangeCoordinates[1]);
      lastRow = Integer.parseInt(rangeCoordinates[2]);
      lastColumn = Integer.parseInt(rangeCoordinates[3]);
    } else {
      rangeCoordinates = rangeDescription.split(";");
      firstRow = lastRow = Integer.parseInt(rangeCoordinates[0]);
      firstColumn = lastColumn = Integer.parseInt(rangeCoordinates[1]);
    }
    if(firstRow > lastRow || firstColumn > lastColumn || lastRow > _height || lastColumn > _width
    || ((lastRow != firstRow) && (lastColumn != firstColumn))){

      throw new InvalidCellRangeException(rangeDescription);
    }
    return new Range(firstRow, firstColumn, lastRow, lastColumn, this);
  }


  public void insert(int row, int column, Content content){
      searchCell(row, column).insertContent(content);
  }


  public Cell searchCell(int row, int column){
    return _listCells[row-1][column-1];
  }
  
  public void setCutBuffer(CutBuffer cutBuffer){
    _cutBuffer = cutBuffer;
  }

  public void paste(Range selectedCells){
      ArrayList<Cell> targetCells = selectedCells.getListCells();
      ArrayList<Cell> cutBufferCells = _cutBuffer.getListCells();
    if (targetCells.size() == 1){
      int r = targetCells.get(0).getRow();
      int c = targetCells.get(0).getCollumn();
      int r_iterator = 0;
      int c_iterator = 0;
      if(cutBufferCells.size() > 1){
        r_iterator = cutBufferCells.get(1).getRow() - cutBufferCells.get(0).getRow();
        c_iterator = cutBufferCells.get(1).getCollumn() - cutBufferCells.get(0).getCollumn();
      }
      for(Cell e: cutBufferCells){
        searchCell(r, c).insertContent(e.getContent());
        r += r_iterator;
        c += c_iterator;
      }  
    }else if(targetCells.size() > 1){
      for(int i = 0; i < targetCells.size(); i++){
          targetCells.get(i).insertContent(cutBufferCells.get(i).getContent());
      }
    }
  }

  public void copy(String rangeDescription) throws InvalidCellRangeException{
    ArrayList<Cell> copiedCells = buildRange(rangeDescription).getListCells();
    ArrayList<Cell> listCells = new ArrayList<Cell>();
    int r = 1;
    int c = 1;
    int r_iterator = 0;
    int c_iterator = 0;
    if(copiedCells.size() > 1){
      r_iterator = copiedCells.get(1).getRow() - copiedCells.get(0).getRow();
      c_iterator = copiedCells.get(1).getCollumn() - copiedCells.get(0).getCollumn();
    }
    for(int k = 0; k < copiedCells.size(); k++){
      Cell cell = new Cell(r,c);
      cell.insertContent(copiedCells.get(k).getContent());
      listCells.add(cell);
      r += r_iterator;
      c += c_iterator;
    }
    CutBuffer cutBuffer = new CutBuffer(listCells);
    _cutBuffer = cutBuffer;
  }
}


  /**
   * Insert specified content in specified address.
   *
   * @param row the row of the cell to change 
   * param column the column of the cell to change
   * @param contentSpecification the specification in a string format of the content to put
   *        in the specified cell.
   */


