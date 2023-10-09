package xxl.core.exception;

/**
 * Class for representing a function name problem.
 */


 public class InvalidFunctionException extends Exception {
  private static final String ERROR_MESSAGE = "Função inválida:";

 /**
   * @param filename name of the import file
   */
  public InvalidFunctionException(String function_name) {
    super(ERROR_MESSAGE + function_name);
  }
  
  /**
   * @param filename name of the import file
   * @param cause exception that triggered this one
   */
  public InvalidFunctionException(String function_name, Exception cause) {
    super(ERROR_MESSAGE + function_name, cause);
  }
  
}