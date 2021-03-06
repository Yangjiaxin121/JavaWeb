package cn.itcast.user.domain;

/**
 * 实体类
 * @author yangjiaxin
 *
 */
public class User {
	private String username;
	private String password;
	private String verifyCode;
	public User(String username, String password, String verifyCode) {
		super();
		this.username = username;
		this.password = password;
		this.verifyCode = verifyCode;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

}
