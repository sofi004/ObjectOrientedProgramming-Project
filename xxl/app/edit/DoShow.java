package xxl.app.edit;

import java.util.ArrayList;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.core.Spreadsheet;
import xxl.core.Range;
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
  protected final void execute() throws CommandException {
    // FIXME implement command
    String rangeDescription = stringField("range");
    Range range = _receiver.buildRange(rangeDescription);
    ArrayList<Cell> listCells = range.getListCells();
    for(Cell c: listCells){
      _display.addLine(c.toString());
    }

  }
}
