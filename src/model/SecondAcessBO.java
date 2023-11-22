package model;

public class SecondAcessBO {

	private SecondAcessDAO secondAcessDAO;

	public SecondAcessBO() {

		secondAcessDAO = new SecondAcessDAO();
	}

	public boolean verificarPalavraCorreta(String userID, String accessWork) {

		return secondAcessDAO.verificarPalavraCorreta(userID, accessWork);
	}

	public String buscarDica(String userID) {
		
		return secondAcessDAO.buscarDica(userID);
	}
}