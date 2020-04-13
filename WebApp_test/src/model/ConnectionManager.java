package model;

import java.util.List;

public class ConnectionManager {

	public boolean ninsyo(UserBean user) {
		UserDAO dao = new UserDAO();
		List<UserBean> userList = dao.findAll();
		for(UserBean emp:userList) {
		if(user.getId().equals(emp.getId()) && user.getPass().equals(emp.getPass())) {
				return true;
			}
		}
		return false;
		}
	}
