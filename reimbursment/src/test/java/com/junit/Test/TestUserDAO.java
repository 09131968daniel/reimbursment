package com.junit.Test;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.project.DAO.UserDAO;
import com.project.DAO.UserDAOim;
import com.project.model.User;

public class TestUserDAO {
	@Test
    public void findUserByUsernameTest() {
		UserDAOim ud= new UserDAOim();
       int u= ud.findUserbyUsername("cdaniel");
        assertNotNull(u);
    }
	@Test
	public void getUserbyUsernameTest() {
		UserDAOim ud= new UserDAOim();
		User u =  ud.getUserbyUsername("cdaniel");
		assertNotNull(u);
	}
	@Test
	public void LoginUserTest() {
		UserDAOim user=new UserDAOim();
		int u= user.LoginUser("cdaniel","1234");
		assertNotNull(u);
		
	}
	
}


