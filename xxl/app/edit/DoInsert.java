package xxl.app.edit;

import java.io.IOException;
import java.util.ArrayList;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.app.exception.InvalidCellRangeException;
import xxl.core.Cell;
import xxl.core.Range;
import xxl.core.Spreadsheet;
import xxl.core.exception.InvalidFunctionException;
import xxl.core.exception.UnrecognizedEntryException;
import xxl.core.Parser;

/**
 * Class for inserting data.
 */
class DoInsert extends Command<Spreadsheet> {

  DoInsert(Spreadsheet receiver) {
    super(Label.INSERT, receiver);
  }
  
  @Override
  protected final void execute() throws CommandException {
    Parser parse = new Parser();
    String rangeDescription = Form.requestString(Message.address());
    String contentDescription = Form.requestString(Message.contents());
    Range range = _receiver.buildRange(rangeDescription);
    ArrayList<Cell> listCells = range.getListCells();
    for(Cell c: listCells){
      try {
        c.insertContent(parse.parseContent(contentDescription));
      } catch (UnrecognizedEntryException| InvalidFunctionException| InvalidCellRangeException e){
        
      }
    }
  }
}
