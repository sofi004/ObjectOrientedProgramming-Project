package xxl.app.edit;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.core.CutBuffer;
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
      CutBuffer cutBuffer = new CutBuffer(_receiver.buildRange(rangeDescription));

  }
}
