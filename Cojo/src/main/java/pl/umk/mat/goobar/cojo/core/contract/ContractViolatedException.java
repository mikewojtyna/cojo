/**
 * 
 */
package pl.umk.mat.goobar.cojo.core.contract;

/**
 * @author goobar
 *
 */
public class ContractViolatedException extends RuntimeException
{
	/**
	 * 
	 */
	private static final String MSG_FORMAT = "OriginalObjectHolder violdated %s";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String prepareMsg(Class<?> contract)
	{
		return String.format(MSG_FORMAT, contract.getName());
	}

	private final Class<?> contract;

	public ContractViolatedException(Class<?> contract)
	{
		super(prepareMsg(contract));
		this.contract = contract;
	}

	public ContractViolatedException(Class<?> contract, String message)
	{
		super(message);
		this.contract = contract;
	}

	public ContractViolatedException(Class<?> contract, String message,
		Throwable cause)
	{
		super(message, cause);
		this.contract = contract;
	}

	public ContractViolatedException(Class<?> contract, String message,
		Throwable cause, boolean enableSuppression,
		boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
		this.contract = contract;
	}

	public ContractViolatedException(Class<?> contract, Throwable cause)
	{
		super(prepareMsg(contract), cause);
		this.contract = contract;
	}

	/**
	 * @return the contract
	 */
	public Class<?> getContract()
	{
		return contract;
	}

	@Override
	public String toString()
	{
		return prepareMsg(contract);
	}

}
