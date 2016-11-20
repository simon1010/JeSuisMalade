package application;

public class InvalidArgumentException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 8471809107230907781L;
  
  public InvalidArgumentException(String errorMessage)
  {
    super(errorMessage);
  }
}
