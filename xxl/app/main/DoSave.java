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
    if (_receiver.getSpreadsheet().isNamed() == false)
      addStringField("filename", Message.newSaveAs());
  }
  
  @Override
  protected final void execute() throws FileOpenFailedException {
    // FIXME implement command and create a local Form
    try{
      if (_receiver.getSpreadsheet().isNamed() == false){
        String nameSaveAs = stringField("filename");
        _receiver.saveAs(nameSaveAs);
        _receiver.getSpreadsheet().setName(nameSaveAs);
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
