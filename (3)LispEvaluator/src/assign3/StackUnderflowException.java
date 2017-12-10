package assign3;

public class StackUnderflowException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackUnderflowException(){
		super();
	}
	
	public StackUnderflowException(String message){
		super(message);
	}
}