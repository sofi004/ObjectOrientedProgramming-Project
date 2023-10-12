package xxl.app.main;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.app.exception.FileOpenFailedException;
import xxl.core.Calculator;
import java.io.IOException;
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
    try{
      if(_receiver.getSpreadsheet() != null &&  !_receiver.getSpreadsheet().isSaved()){
        boolean booleanAnswer = Form.confirm(Message.saveBeforeExit());
        if(booleanAnswer){
          if( _receiver.getSpreadsheet().isNamed())
            _receiver.save();
          else{
            String fileName = stringField("FileName");
            _receiver.saveAs(fileName);
          }
        }
      }
      String nameSaveAs = stringField("filename");
      _receiver.load(nameSaveAs);
    }
    catch(IOException | MissingFileAssociationException | UnavailableFileException e){      
      throw new FileOpenFailedException(e);
    } 
  }
}
