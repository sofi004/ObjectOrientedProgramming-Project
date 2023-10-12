package xxl.core;

// FIXME import classes

import java.io.Serial;
import java.io.Serializable;

import xxl.core.exception.UnrecognizedEntryException;
import xxl.app.exception.InvalidCellRangeException;

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
  private String _name;
  private boolean _named;

  public Spreadsheet(int row, int column){
    _height = row;
    _width = column;
    _changed = false;
    _listCells = new Cell[row][column];
    createListCell();
  }

  public void setName(String name){
    _name = name;
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
        _listCells[i][j] = new Cell(i + 1, j + 1);
      }
    }
  }

  public Range buildRange(String rangeDescription) throws InvalidCellRangeException/* temos de meter excecoes*/{
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

  public void insert(int row, int column, Content content) throws UnrecognizedEntryException{
    searchCell(row, column).insertContent(content);
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
}
