package xxl.core;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import xxl.app.exception.InvalidCellRangeException;
import xxl.core.exception.ImportFileException;
import xxl.core.exception.InvalidFunctionException;
import xxl.core.exception.MissingFileAssociationException;
import xxl.core.exception.UnavailableFileException;
import xxl.core.exception.UnrecognizedEntryException;

/**
* Class representing a spreadsheet application.
*/
public class Calculator{
  /** The current spreadsheet. */
  private Spreadsheet _spreadsheet;
  
  /**
   * Return the current spreadsheet.
   *
   * @returns the current spreadsheet of this application. This reference can be null.
   */
  public void addSpreadsheet(int numberl, int numberc) throws UnrecognizedEntryException{
    if (numberl <= 0 || numberc <= 0) {
      throw new UnrecognizedEntryException("Dimensões inválidas para a folha");
    }
    Spreadsheet spreadsheet = new Spreadsheet(numberl, numberc);
    _spreadsheet = spreadsheet;
  }

  public final Spreadsheet getSpreadsheet(){
    return _spreadsheet;
  }


  /**
   * Saves the serialized application's state into the file associated to the current network.
   *
   * @throws FileNotFoundException if for some reason the file cannot be created or opened. 
   * @throws MissingFileAssociationException if the current network does not have a file.
   * @throws IOException if there is some error while serializing the state of the network to disk.
   */
  public void save() throws FileNotFoundException, MissingFileAssociationException, IOException {
    // FIXME implement serialization method
    try(ObjectOutputStream outstream = new ObjectOutputStream(new FileOutputStream(_spreadsheet.getFileName()))){
      outstream.writeObject(_spreadsheet);
      _spreadsheet.setSaved(true);

    }
  }

  

  /**
   * Saves the serialized application's state into the specified file. The current network is
   * associated to this file.
   *
   * @param filename the name of the file.
   * @throws FileNotFoundException if for some reason the file cannot be created or opened.
   * @throws MissingFileAssociationException if the current network does not have a file.
   * @throws IOException if there is some error while serializing the state of the network to disk.
   */
  public void saveAs(String filename) throws FileNotFoundException, MissingFileAssociationException, IOException {
    try(ObjectOutputStream outstream = new ObjectOutputStream(new FileOutputStream(filename))){
      outstream.writeObject(_spreadsheet);
      _spreadsheet.setName(filename);
      _spreadsheet.setSaved(true);
    }
  }

  
  /**
   * @param filename name of the file containing the serialized application's state
   *        to load.
   * @throws UnavailableFileException if the specified file does not exist or there is
   *         an error while processing this file.
   */
  public void load(String filename) throws UnavailableFileException, MissingFileAssociationException, IOException {
    try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
      _spreadsheet = (Spreadsheet)in.readObject();
    } catch (ClassNotFoundException | IOException e){
      throw new UnavailableFileException(filename);
    }
  }
  

  /**
   * Read text input file and create domain entities.
   *
   * @param filename name of the text input file
   * @throws ImportFileException
   */
  public void importFile(String filename) throws ImportFileException, InvalidFunctionException, InvalidCellRangeException {
    try {
      Parser parse = new Parser(_spreadsheet);
      _spreadsheet = parse.parseFile(filename);
    } catch (IOException | UnrecognizedEntryException e) {
      throw new ImportFileException(filename, e);
    }
  } 
}
