package xxl.app.main;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import xxl.app.exception.FileOpenFailedException;
import xxl.core.Calculator;
import java.io.*;
// FIXME import classes
import xxl.core.exception.MissingFileAssociationException;

/**
 * Save to file under current name (if unnamed, query for name).
 */
class DoSave extends Command<Calculator> {

  DoSave(Calculator receiver) {
    super(Label.SAVE, receiver, xxl -> xxl.getSpreadsheet() != null);
    if (_receiver.getFile() == null)
      addStringField("filename", Message.saveAs());
  }
  
  @Override
  protected final void execute() throws FileOpenFailedException {
    // FIXME implement command and create a local Form
    try{
      if (_receiver.getFile() == null){
        String nameSaveAs = stringField("filename");
        _receiver.saveAs(nameSaveAs);
      }
    }
    catch(IOException | MissingFileAssociationException e){      
      throw new FileOpenFailedException(e);
    }
  }
}
