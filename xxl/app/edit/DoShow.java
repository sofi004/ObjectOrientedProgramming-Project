package xxl.app.edit;

import java.util.ArrayList;
import pt.tecnico.uilib.menus.Command;
import xxl.core.Spreadsheet;
import xxl.core.Range;
import xxl.app.exception.InvalidCellRangeException;
import xxl.core.Cell;

/**
 * Class for searching functions.
 */
class DoShow extends Command<Spreadsheet> {

  DoShow(Spreadsheet receiver) {
    super(Label.SHOW, receiver);
    addStringField("range", Message.address());
  }
  
  @Override
  protected final void execute() throws ArrayIndexOutOfBoundsException, InvalidCellRangeException {
    String rangeDescription = stringField("range");
    try{
      Range range = _receiver.buildRange(rangeDescription);
      ArrayList<Cell> listCells = range.getListCells();
      for(Cell c: listCells){
      _display.addLine(c.toString());
      }
    }
    catch(ArrayIndexOutOfBoundsException e){      
      throw new InvalidCellRangeException(rangeDescription);
    }
    _display.display();
  }
  
}
