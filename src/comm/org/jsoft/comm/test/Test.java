package org.jsoft.comm.test;

import java.util.ArrayList;
import java.util.List;

import org.jsoft.comm.dao.IBaseDAO;
import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.User;

public class Test {
	public static void main(String[] args) {
		IBaseDAO<User> userdao = new BaseDAO<User>();
		
		System.out.println(userdao.get(User.class, "03584fa7-8d33-1032-ba10-05559a04485a").getPassword());
	}
}
