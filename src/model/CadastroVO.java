package model;

public class CadastroVO {

	private String userID;
	private String email;
	private String password;
	private String acessWork;
	private String tip;

	public CadastroVO(String userID, String email, String password, String acessWork, String tip) {

		this.userID = userID;
		this.email = email;
		this.password = password;
		this.acessWork = acessWork;
		this.tip = tip;
	}

	public String getUserID() {

		return userID;
	}

	public void setUserID(String userID) {

		this.userID = userID;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public String getAcessWork() {

		return acessWork;
	}

	public void setAcessWork(String acessWork) {

		this.acessWork = acessWork;
	}

	public String getTip() {

		return tip;
	}

	public void setTip(String tip) {

		this.tip = tip;
	}

}