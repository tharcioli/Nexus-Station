package model;

public class LoginBO {

	private LoginDAO loginDAO;

	public LoginBO() {

		loginDAO = new LoginDAO();
	}

	public int realizarLogin(String userID, String password) {

		if (loginDAO.verificarUserIDExistente(userID)) {

			if (loginDAO.verificarCredenciais(userID, password))
				return 0; 
			else
				return 1; 
		} else
			return 2; 
	}
	
	public int realizarLoginSecundario(String userID, String acessWork) {
		
		if (loginDAO.verificarUserIDExistente(userID)) {

			if (loginDAO.verificarCredenciaisSecundarias(userID, acessWork))
				return 0;
			else
				return 1; 
		} else
			return 2;
	}
	
	public boolean verificarUserIDExistente(String userID) {
		
		return loginDAO.verificarUserIDExistente(userID);
	}
}