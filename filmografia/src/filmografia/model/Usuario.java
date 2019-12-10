package filmografia.model;



public class Usuario {
	
	private String user;
	private String pass;
	
	public Usuario(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getPass() {
		return pass;
	}

}
