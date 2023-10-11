package xxl.app.main;

import java.io.IOException;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.app.exception.FileOpenFailedException;
import xxl.core.Calculator;
// FIXME import classes
import xxl.core.exception.MissingFileAssociationException;

/**
 * Open existing file.
 */
class DoOpen extends Command<Calculator> {

  DoOpen(Calculator receiver) {
    super(Label.OPEN, receiver);
  }
  
  @Override
  protected final void execute() throws CommandException {
    /*
      try {
      //FIXME implement command
      } catch (UnavailableFileException e) {
      throw new FileOpenFailedException(e);
      }
    */
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
