package xxl.app.exception;

import pt.tecnico.uilib.menus.CommandException;

public class InvalidSheetEntryException extends CommandException {

  
  /**
   * @param entrySpecification
   */
  public InvalidSheetEntryException(String s) {
    super(s);
  }
  
}