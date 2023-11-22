package model;

public class CadastroBO {

	private CadastroDAO cadastroDAO;

	public CadastroBO() {
		cadastroDAO = new CadastroDAO();
	}

	public boolean cadastrarUsuario(String userID, String email, String password, String acessWork, String tip) {

		try {

			CadastroVO usuario = new CadastroVO(userID, email, password, acessWork, tip);
			cadastroDAO.cadastrarUsuario(usuario);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	public boolean validarSenha(String password) {

		int letterOrSymbolCount = password.replaceAll("[^a-zA-Z0-9]", "").length();
		return password.length() >= 8 && letterOrSymbolCount >= 3 && !password.contains(" ") && password.length() <= 45;
	}

	public boolean verificarUserIDExistente(String userID) {

		return cadastroDAO.verificarUserIDExistente(userID);
	}

	public boolean verificarEmailExistente(String email) {

		return cadastroDAO.verificarEmailExistente(email);
	}
}