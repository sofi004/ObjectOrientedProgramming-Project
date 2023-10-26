package xxl.app.search;

import java.io.IOException;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import xxl.core.Spreadsheet;
// FIXME import classes

/**
 * Command for searching function names.
 */
class DoShowFunctions extends Command<Spreadsheet> {

  DoShowFunctions(Spreadsheet receiver) {
    super(Label.SEARCH_FUNCTIONS, receiver);
    // FIXME add fields
  }

  @Override
  protected final void execute() {
    String functionDescription = Form.requestString(Message.searchFunction());
    int r = _receiver.getHeight();
    int c = _receiver.getWidth();
    for(int i = 1; i <= r; i++){
      for(int k = 1; k <= c; k++){
        try{
          if(_receiver.searchCell(i, k).getContent().getName().contains(functionDescription)){
            _display.addLine(_receiver.searchCell(i, k).toString());
          }
        }catch(IOException e){
          continue;
        }
      }
    }
    _display.display();
  }
}
