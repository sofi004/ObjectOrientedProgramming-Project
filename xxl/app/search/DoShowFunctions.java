package xxl.app.search;

import java.io.IOException;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import xxl.core.Spreadsheet;
import xxl.core.MatrixCellRepresentation;

/**
 * Command for searching function names.
 */
class DoShowFunctions extends Command<Spreadsheet> {

  DoShowFunctions(Spreadsheet receiver) {
    super(Label.SEARCH_FUNCTIONS, receiver);
  }

  @Override
  protected final void execute() {
    String functionDescription = Form.requestString(Message.searchFunction());
    int r = _receiver.getCells().getRowsnum();
    int c = _receiver.getCells().getColumnsnum();
    for(int i = 1; i <= r; i++){
      for(int k = 1; k <= c; k++){
        try{
          if(_receiver.getCells().searchCell(i, k).getContent().getName().contains(functionDescription)){
            _display.addLine(_receiver.getCells().searchCell(i, k).toString());
          }
        }catch(IOException e){
          continue;
        }
      }
    }
    _display.display();
  }
}
