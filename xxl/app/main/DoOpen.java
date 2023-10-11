package xxl.app.main;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.app.exception.FileOpenFailedException;
import xxl.core.Calculator;
import java.io.IOException;
// FIXME import classes
import xxl.core.exception.MissingFileAssociationException;
import xxl.core.exception.UnavailableFileException;

/**
 * Open existing file.
 */
class DoOpen extends Command<Calculator> {

  DoOpen(Calculator receiver) {
    super(Label.OPEN, receiver);
    addStringField("filename", Message.openFile());
  }
  
  @Override
  protected final void execute() throws CommandException, FileOpenFailedException {
    /*
      try {
      //FIXME implement command
      } catch (UnavailableFileException e) {
      throw new FileOpenFailedException(e);
      }
    */
   try{
      String nameSaveAs = stringField("filename");
      _receiver.load(nameSaveAs);
    }
    catch(IOException | MissingFileAssociationException | UnavailableFileException e){      
      throw new FileOpenFailedException(e);
    } 
  }
}
