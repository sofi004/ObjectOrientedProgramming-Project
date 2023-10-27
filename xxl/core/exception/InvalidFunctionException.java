package xxl.core.exception;

/**
 * Class for representing a function name problem.
 */

 public class InvalidFunctionException extends Exception {
  private static final String ERROR_MESSAGE = "Função inválida:";

 /**
   * @param functionName name of the wrong function
   */
  public InvalidFunctionException(String functionName) {
    super(ERROR_MESSAGE + functionName);
  }
  
  /**
   * @param functionName name of the wrong function
   * @param cause exception that triggered this one
   */
  public InvalidFunctionException(String functionName, Exception cause) {
    super(ERROR_MESSAGE + functionName, cause);
  }
}