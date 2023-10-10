package xxl.core;

// FIXME import classes

import java.io.Serial;
import java.io.Serializable;

import xxl.core.exception.UnrecognizedEntryException;

/**
 * Class representing a spreadsheet.
 */
public class Spreadsheet implements Serializable {
  @Serial
  private static final long serialVersionUID = 202308312359L;
  
  private int _height;
  private int _width;
  private boolean _changed;
  private Range _cutBuffer;
  private Cell[][] _listCells;

  public Spreadsheet(int row, int column){
    _height = row;
    _width = column;
    _changed = false;
    _listCells = new Cell[row][column];
    createListCell();
  }


  public int getHeight(){
    return _height;
  }

  public int getWidth(){
    return _width;
  }

  public boolean isChanged(){
    return _changed;
  }


  public void createListCell(){
    for(int i = 0; i < _height; i++){
      for(int j = 0; j < _width; j++){
        _listCells[i][j] = new Cell(i, j);
      }
    }
  }

  public Range buildRange(String rangeDescription)/* temos de meter excecoes*/{
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

    // check if coordinates are valid
    // if yes
    return new Range(firstRow, firstColumn, lastRow, lastColumn, this);
  }

  public void insert(int row, int column, Content content){

  }

  public Cell searchCell(int row, int column){
    for(Cell[] l: _listCells){
      for(Cell c: l){
        if((c.getRow() == row) && (c.getCollumn() == column)){
          return c;
        }
      }
    }
    return null;
  }

  /**
   * Insert specified content in specified address.
   *
   * @param row the row of the cell to change 
   * param column the column of the cell to change
   * @param contentSpecification the specification in a string format of the content to put
   *        in the specified cell.
   */
  public void insertContent(int row, int column, String contentSpecification) throws UnrecognizedEntryException /* FIXME maybe add exceptions */ {
    //FIXME implement method
  }
}
