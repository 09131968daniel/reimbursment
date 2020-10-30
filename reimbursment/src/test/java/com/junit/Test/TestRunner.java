package com.junit.Test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite.SuiteClasses;




@SuiteClasses(value = {TestJunit.class,TestReimbursmentDAO.class,TestUserDAO.class})
public class TestRunner {
	public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(TestJunit.class,TestReimbursmentDAO.class,TestUserDAO.class);
			
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println(result.wasSuccessful());
	   }
}
