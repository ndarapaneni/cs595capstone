package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.RegistrationDao;
import domain.Register;

public class RegistrationDaoImpl implements RegistrationDao{
	int regid;

	@Override
	public boolean createnewUser(Register reg) throws SQLException {
		Connection conn=Connections.getConnection();
		System.out.println("connetion obtained");
		String sql="insert into registration values (Default,?,?,?,?,?,?)";
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setString(1, reg.getFirstName());
		stmt.setString(2, reg.getLastName());
		stmt.setString(3, reg.getEmailId());
		stmt.setString(4, reg.getPassword());
		stmt.setInt(5, reg.getPhoneNumber());
		stmt.setString(6, reg.getType());
		
		int result=stmt.executeUpdate();
		System.out.println(" no of rows inserted succesfully are="+result);
		stmt.close();
		return true;
	}

	
	public  int validateLogin(String emailid, String password)  throws SQLException {
		
		
		
		Connection conn=Connections.getConnection();
		System.out.println("connetion obtained");
		String sql="select regid  from registration where emailid=? and password=?" ;
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setString(1, emailid);
		stmt.setString(2, password);
			
			ResultSet rs= stmt.executeQuery();
		//Register reg=new Register();	
			
				while(rs.next()){
					regid=rs.getInt("regid");
					
					
				}
				System.out.println(regid);
				return regid;
			}

	
	public static void main(String args[]) throws SQLException{
		Register register=new Register();
		
		register.setFirstName("vidya");
		register.setLastName("lakshmi");
		register.setEmailId("vidya@gmail.com");
		register.setPassword("vidya");
		register.setPhoneNumber(11111);
		register.setType("nurse");
		RegistrationDao reg=new RegistrationDaoImpl();
		reg.createnewUser(register);
		reg.validateLogin("vidya@gmail.com", "vidya");
		//reg.validateLogin("siva@gmail.com", "siva");
	}

}
