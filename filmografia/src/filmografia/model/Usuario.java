package filmografia.model;

/**
 * The Class Usuario.
 */
public class Usuario {
	
	/** The user. */
	private String user;
	
	/** The pass. */
	private String pass;
	
	/**
	 * Instantiates a new usuario.
	 *
	 * @param user the user
	 * @param pass the pass
	 */
	public Usuario(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}
	
	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(String user) {
		this.user = user;
	}
	
	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	
	/**
	 * Sets the pass.
	 *
	 * @param pass the new pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	/**
	 * Gets the pass.
	 *
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

}
