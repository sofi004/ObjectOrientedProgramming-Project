package xxl.app.search;

import java.io.IOException;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import xxl.core.Spreadsheet;
// FIXME import classes

/**
 * Command for searching content values.
 */
class DoShowValues extends Command<Spreadsheet> {

  DoShowValues(Spreadsheet receiver) {
    super(Label.SEARCH_VALUES, receiver);
    // FIXME add fields
  }
  
  @Override
  protected final void execute() {
    String literalDescription = Form.requestString(Message.searchValue());
    int r = _receiver.getHeight();
    int c = _receiver.getWidth();
    for(int i = 1; i <= r; i++){
      for(int k = 1; k <= c; k++){
        if(String.valueOf(_receiver.searchCell(i, k).value()).equals(literalDescription)){
          _display.addLine(_receiver.searchCell(i, k).toString());
        }
      }
    }
    _display.display();
  }
}
