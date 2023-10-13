package xxl.core;

import java.io.Serial;
import java.io.Serializable;
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
  private Range _cutBuffer;
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
    if(firstRow > lastRow || firstColumn > lastColumn || lastRow > _height || lastColumn > _width){
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
  

  /**
   * Insert specified content in specified address.
   *
   * @param row the row of the cell to change 
   * param column the column of the cell to change
   * @param contentSpecification the specification in a string format of the content to put
   *        in the specified cell.
   */

}
