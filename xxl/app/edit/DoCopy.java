package xxl.app.edit;

import java.util.ArrayList;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.core.Cell;
import xxl.core.CutBuffer;
import xxl.core.Spreadsheet;
import xxl.core.Content;

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
    ArrayList<Cell> copiedCells = _receiver.buildRange(rangeDescription).getListCells();
    ArrayList<Cell> listCells = new ArrayList<Cell>();
    int r = 1;
    int c = 1;
    int r_iterator = 0;
    int c_iterator = 0;
    if(copiedCells.size() > 1){
      r_iterator = copiedCells.get(1).getRow() - copiedCells.get(0).getRow();
      c_iterator = copiedCells.get(1).getCollumn() - copiedCells.get(0).getCollumn();
    }
    for(int k = 0; k < copiedCells.size(); k++){
      Cell cell = new Cell(r,c);
      cell.insertContent(copiedCells.get(k).getContent());
      listCells.add(cell);
      r += r_iterator;
      c += c_iterator;
    }
    CutBuffer cutBuffer = new CutBuffer(listCells);
    _receiver.setCutBuffer(cutBuffer);
  }
}
