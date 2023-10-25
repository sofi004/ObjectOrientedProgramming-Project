package xxl.app.edit;

import java.util.ArrayList;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.app.exception.InvalidCellRangeException;
import xxl.core.Cell;
import xxl.core.Null;
import xxl.core.Spreadsheet;
// FIXME import classes

/**
 * Cut command.
 */
class DoCut extends Command<Spreadsheet> {

  DoCut(Spreadsheet receiver) {
    super(Label.CUT, receiver);
    // FIXME add fields
  }
  
  @Override
  protected final void execute() throws CommandException {
    String rangeDescription = Form.requestString(Message.address());
    try{
      ArrayList<Cell> copiedCells = _receiver.buildRange(rangeDescription).getListCells();
      _receiver.copy(copiedCells);
      _receiver.delete(copiedCells);
    }catch(InvalidCellRangeException e){
      _display.addLine(e.getMessage());
    }
  }
}
