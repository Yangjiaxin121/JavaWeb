package cn.itcast.domain;


/**
 * 把数据库中查询出的结果保存到这个对象中。
 * @author yangjiaxin
 *
 */
public class User {
	private String username;
	private String  password;
	public User(String username, String password) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
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
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	

}
