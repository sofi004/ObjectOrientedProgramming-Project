package xxl.app.edit;

import java.util.ArrayList;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.app.exception.InvalidCellRangeException;
import xxl.core.Cell;
import xxl.core.Range;
import xxl.core.Spreadsheet;

/**
 * Delete command.
 */
class DoDelete extends Command<Spreadsheet> {

  DoDelete(Spreadsheet receiver) {
    super(Label.DELETE, receiver);
  }
  
  @Override
  protected final void execute() throws CommandException {
    String rangeDescription = Form.requestString(Message.address());
    try{
    Range range = _receiver.buildRange(rangeDescription);
    ArrayList<Cell> listCells = range.getListCells();
    _receiver.delete(listCells);
    _receiver.setSaved(false);
    }catch(InvalidCellRangeException e){
      _display.addLine(e.getMessage());
    }
  }
}
