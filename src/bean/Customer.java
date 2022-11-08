package bean;

import java.io.Serializable;

/*
 * 顧客情報を格納するBeanのクラス
 */
public class Customer implements Serializable {
	
	private int id;		// 顧客番号
	private String login;// ログイン名
	private String password;	// パスワード
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
