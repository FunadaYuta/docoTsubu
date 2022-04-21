package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.User;

public class AccountDAO {

	
	//データベース接続に使用する情報
	private final String JDBC_URL =
			"jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	//ログイン処理
	public Account findByLogin(User user) {
		Account account = null;
		
		//データベースに接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			 
			//SELECT文を準備
			String sql = "SELECT NAME, PASS, AGE FROM ACCOUNT WHERE NAME = ? AND PASS = ?";
			PreparedStatement pSmt = conn.prepareStatement(sql);
			pSmt.setString(1, user.getName());
			pSmt.setString(2, user.getPass());
			
			//SELECT文を実行し、結果表を取得
			ResultSet rs = pSmt.executeQuery();
			
			//一致したユーザーが存在した場合
			//そのユーザーを表すAccountインスタンスを生成
			if(rs.next()) {			
				//結果表からデータを取得
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				int age = rs.getInt("AGE");
				account = new Account(name,pass,age);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
			
		}
		
		//見つかったユーザーまたはnullを返す
		return account;
	}
	
	
	
	
	//新規登録処理
	public Account SignUp(Account account) {
		
		
		//データベースに接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			 
			//SELECT文を準備
			String sql = "INSERT INTO ACCOUNT VALUES(?,?,?)";
			PreparedStatement pSmt = conn.prepareStatement(sql);
			pSmt.setString(1, account.getName());
			pSmt.setString(2, account.getPass());
			pSmt.setInt(3,account.getAge());
			
			//SELECT文を実行し、結果表を取得
			int num = pSmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
			
		}
		
		//見つかったユーザーまたはnullを返す
		return account;
	}
	
	
}
