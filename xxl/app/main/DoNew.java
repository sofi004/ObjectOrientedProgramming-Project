package xxl.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.app.exception.FileOpenFailedException;
import xxl.core.Calculator;
import xxl.core.Parser;
import xxl.core.Spreadsheet;
import xxl.core.exception.MissingFileAssociationException;


/**
 * Open a new file.
 */
class DoNew extends Command<Calculator> {

  DoNew(Calculator receiver) {
    super(Label.NEW, receiver);
    addIntegerField("numberl", Message.lines());
    addIntegerField("numberc", Message.columns());
  }
  
  @Override
  protected final void execute() throws FileOpenFailedException{
    // FIXME implement command
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
    }catch( IOException | MissingFileAssociationException e){
      throw new FileOpenFailedException(e);
    }
    Integer numberl = integerField("numberl");
    Integer numberc = integerField("numberc");
    _receiver.addSpreadsheet(new Spreadsheet(numberl, numberc)); 

  }
}
