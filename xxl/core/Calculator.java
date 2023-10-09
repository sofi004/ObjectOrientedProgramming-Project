package xxl.core;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import xxl.core.exception.ImportFileException;
import xxl.core.exception.InvalidFunctionException;
import xxl.core.exception.MissingFileAssociationException;
import xxl.core.exception.UnavailableFileException;
import xxl.core.exception.UnrecognizedEntryException;

// FIXME import classes

/**
 * Class representing a spreadsheet application.
 */
public class Calculator implements Serializable{
  /** The current spreadsheet. */
  private Spreadsheet _spreadsheet;
  
  // FIXME add more fields and methods if needed
  
  /**
   * Return the current spreadsheet.
   *
   * @returns the current spreadsheet of this application. This reference can be null.
   */
  public final Spreadsheet getSpreadsheet() {
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
    // FIXME implement serialization method
    
    try(ObjectOutputStream outstream = new ObjectOutputStream(new FileOutputStream(filename))){
      outstream.writeObject(this);

    
    }
  }

  
  
  /**
   * @param filename name of the file containing the serialized application's state
   *        to load.
   * @throws UnavailableFileException if the specified file does not exist or there is
   *         an error while processing this file.
   */
  public void load(String filename) throws UnavailableFileException {

    // FIXME implement serialization method

    try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
      Calculator loadedCalculator = (Calculator) in.readObject();
      this._spreadsheet = loadedCalculator.getSpreadsheet();

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
  public void importFile(String filename) throws ImportFileException, InvalidFunctionException {
    try {
      // FIXME open import file and feed entries to new spreadsheet (in a cycle)
      //       each entry is inserted using insertContent of Spreadsheet. Set new
      // spreadsheet as the active one.
      // ....
      Parser parse = new Parser(_spreadsheet);
      _spreadsheet = parse.parseFile(filename);
    } catch (IOException | UnrecognizedEntryException /* FIXME maybe other exceptions */ e) {
      throw new ImportFileException(filename, e);
    }
  } 
}
