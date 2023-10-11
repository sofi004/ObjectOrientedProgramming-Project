package xxl.app.main;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.core.Calculator;
import xxl.core.Parser;
import xxl.core.Spreadsheet;

/**
 * Open a new file.
 */
class DoNew extends Command<Calculator> {

  DoNew(Calculator receiver) {
    super(Label.NEW, receiver);
    addIntegerField("numberl", Message.lines());
    addIntegerField("numberc", Message.columns());
  }
  
  @Override
  protected final void execute() throws CommandException {
    // FIXME implement command
    Integer numberl = integerField("numberl");
    Integer numberc = integerField("numberc");
    _receiver.addSpreadsheet(new Spreadsheet(numberl, numberc)); 

  }
}
