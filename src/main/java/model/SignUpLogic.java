package model;

import dao.AccountDAO;

public class SignUpLogic {

	public Account execute(Account account) {
		AccountDAO dao = new AccountDAO();
		Account createAccount = dao.SignUp(account);
		
		return createAccount;
	}
	
}
