package xxl.app.edit;

import java.util.ArrayList;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.core.Cell;
import xxl.core.Null;
import xxl.core.Range;
import xxl.core.Spreadsheet;

/**
 * Delete command.
 */
class DoDelete extends Command<Spreadsheet> {

  DoDelete(Spreadsheet receiver) {
    super(Label.DELETE, receiver);
    // FIXME add fields
  }
  
  @Override
  protected final void execute() throws CommandException {
    String rangeDescription = Form.requestString(Message.address());
    Range range = _receiver.buildRange(rangeDescription);
    ArrayList<Cell> listCells = range.getListCells();
    _receiver.setSaved(false);
    for(Cell c: listCells){
      Null n = new Null();
      c.insertContent(n);
    }
  }
}
