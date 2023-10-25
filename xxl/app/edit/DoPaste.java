package xxl.app.edit;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.core.Spreadsheet;
import xxl.app.exception.InvalidCellRangeException;
import xxl.core.Range;
// FIXME import classes

/**
 * Paste command.
 */
class DoPaste extends Command<Spreadsheet> {

  DoPaste(Spreadsheet receiver) {
    super(Label.PASTE, receiver);
  }
  
  @Override
  protected final void execute() throws CommandException {
    String rangeDescription = Form.requestString(Message.address());
    Range selectedCells = _receiver.buildRange(rangeDescription);
    if(selectedCells.getListCells().size() != _receiver.getCutBuffer().getListCells().size()){
      throw new InvalidCellRangeException(rangeDescription);
    }
    _receiver.paste(selectedCells);
  }
}
