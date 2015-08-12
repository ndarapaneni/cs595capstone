package dao;

import java.sql.SQLException;

import domain.Register;

public interface RegistrationDao {
	public  boolean  createnewUser(Register registration)throws SQLException;
	public   int validateLogin(String emailid,String password)throws SQLException;

}
