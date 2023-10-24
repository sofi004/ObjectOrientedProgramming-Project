package xxl.app.edit;

import java.util.ArrayList;

import pt.tecnico.uilib.menus.Command;
import xxl.core.Cell;
import xxl.core.CutBuffer;
import xxl.core.Spreadsheet;
// FIXME import classes

/**
 * Show cut buffer command.
 */
class DoShowCutBuffer extends Command<Spreadsheet> {

  DoShowCutBuffer(Spreadsheet receiver) {
    super(Label.SHOW_CUT_BUFFER, receiver);
  }
  
  @Override
  protected final void execute() {
    CutBuffer buffer = _receiver.getCutBuffer();
    ArrayList<Cell> cutBufferCells = buffer.getListCells();
    for(Cell c: cutBufferCells){
      _display.addLine(c.toString());
    }
    _display.display();
  }
}
