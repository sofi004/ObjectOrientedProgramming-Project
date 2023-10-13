package xxl.app.main;

import java.io.IOException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import xxl.app.exception.FileOpenFailedException;
import xxl.core.Calculator;
import xxl.core.Spreadsheet;
import xxl.core.exception.MissingFileAssociationException;
import xxl.core.exception.UnrecognizedEntryException;


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
  protected final void execute() throws FileOpenFailedException/*  UnrecognizedEntryException*/{
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
//    if (numberl <= 0 || numberc <= 0)
//      throw new UnrecognizedEntryException("Dimensões inválidas para a folha");
    _receiver.addSpreadsheet(new Spreadsheet(numberl, numberc)); 

  }
}
