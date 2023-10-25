package xxl.app.edit;


import java.util.ArrayList;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.app.exception.InvalidCellRangeException;
import xxl.core.Cell;
import xxl.core.Spreadsheet;


// FIXME import classes

/**
 * Copy command.
 */
class DoCopy extends Command<Spreadsheet> {

  DoCopy(Spreadsheet receiver) {
    super(Label.COPY, receiver);
    // FIXME add fields
  }
  
  @Override
  protected final void execute() throws CommandException {
    String rangeDescription = Form.requestString(Message.address());
    try{
      ArrayList<Cell> copiedCells = _receiver.buildRange(rangeDescription).getListCells();
      _receiver.copy(copiedCells);
    }catch(InvalidCellRangeException e){
      _display.addLine(e.getMessage());
    }
    _display.display();
  }
}
