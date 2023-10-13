package xxl.app.main;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import xxl.app.exception.FileOpenFailedException;
import xxl.core.Calculator;
import java.io.*;
import xxl.core.exception.MissingFileAssociationException;

/**
 * Save to file under current name (if unnamed, query for name).
 */
class DoSave extends Command<Calculator> {

  DoSave(Calculator receiver) {
    super(Label.SAVE, receiver, xxl -> xxl.getSpreadsheet() != null);
  }
  
  @Override
  protected final void execute() throws FileOpenFailedException {
    try{
      if (_receiver.getSpreadsheet().isNamed() == false){
        String nameSaveAs = Form.requestString(Message.newSaveAs());
        _receiver.getSpreadsheet().setName(nameSaveAs);
        _receiver.saveAs(nameSaveAs);
      }
      else{
        _receiver.save();
      }
    }
    catch(IOException | MissingFileAssociationException e){      
      throw new FileOpenFailedException(e);
    }
  }
}
