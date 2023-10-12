package xxl.app.edit;

import java.io.IOException;
import java.util.ArrayList;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.core.Spreadsheet;
import xxl.core.exception.MissingFileAssociationException;
import xxl.core.Range;
import xxl.app.exception.FileOpenFailedException;
import xxl.app.exception.InvalidCellRangeException;
import xxl.core.Cell;

// FIXME import classes

/**
 * Class for searching functions.
 */
class DoShow extends Command<Spreadsheet> {

  DoShow(Spreadsheet receiver) {
    super(Label.SHOW, receiver);
    addStringField("range", Message.address());
    // FIXME add fields

  }
  
  @Override
  protected final void execute() throws CommandException, InvalidCellRangeException {
    // FIXME implement command
    String rangeDescription = stringField("range");
    try{
      Range range = _receiver.buildRange(rangeDescription);
      ArrayList<Cell> listCells = range.getListCells();
      for(Cell c: listCells){
      _display.addLine(c.toString());
    }
    }
    catch(CommandException e){      
      throw new InvalidCellRangeException(rangeDescription);
    }

  }
}
