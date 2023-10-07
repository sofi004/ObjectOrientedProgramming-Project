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
  
  private int _row;
  private int _column;
  private boolean _changed;
  private Range _cutBuffer;
  private Cell[][] _listCells;
  private User[] _listUsers;

  public Spreadsheet(int row, int column){
    _row = row;
    _column = column;
    _changed = false;
    _listCells = new Cell[row][column];
  }


  public int getRow(){
    return _row;
  }

  public int getColumn(){
    return _column;
  }

  public boolean isChanged(){
    return _changed;
  }


  public void createListCell(){
    for(i = 0; i < row; i++){
      for(j = 0; j < column; j++){
        _listCells[i][j] = new Cell(i, j)
      }
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
  public void insertContent(int row, int column, String contentSpecification) throws UnrecognizedEntryException /* FIXME maybe add exceptions */ {
    //FIXME implement method
  }
}
