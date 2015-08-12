package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





import dao.NurseDao;
import domain.Nurse;

public class NurseDaoImpl  implements NurseDao{
	String nurseemail;

	@Override
	public boolean createNurse(Nurse nurse) throws SQLException {
		
			Connection conn=Connections.getConnection();
		System.out.println("connetion obtained");
		String sql="insert into nurse values (?,?,?,?,?,?)";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1, nurse.getNurseId());
		stmt.setString(2, nurse.getFirstName());
		stmt.setString(3, nurse.getLastName());
		stmt.setString(4, nurse.getNurseEmailId());
		stmt.setInt(5, nurse.getPhoneNumber());
		stmt.setInt(6, nurse.getDeviceId());
		int result=stmt.executeUpdate();
		System.out.println(" no of rows inserted succesfully are="+result);
		stmt.close();
		return true;
		
	}

	@Override
	public boolean updateNurse(int deviceid, String emailid) throws SQLException {
		Connection conn=Connections.getConnection();
		String sql="update nurse set nurseemailid=? where deviceid=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1, emailid);
		stmt.setInt(2,deviceid);
		int result=stmt.executeUpdate();
		System.out.println("number of rows updated are :"+result);
		stmt.close();
		return true;
		
	}

	@Override
	public boolean deleteNurse(int nurseId) throws SQLException {
		Connection conn=Connections.getConnection();
		String sql="delete from nurse where nurseid=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1, nurseId);
		int result=stmt.executeUpdate();
		System.out.println("no of rows deleted  :"+result);
		stmt.close();
		return true;
	}

	@Override
	public List<Nurse> getAllNurses() throws SQLException {
		Connection conn=Connections.getConnection();
		System.out.println("connection obtained");
		String sql="select * from nurse";
		PreparedStatement stmt=conn.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		List<Nurse> list=new ArrayList<Nurse>();;
		Nurse  nurse;
		while(rs.next()){
			nurse=new Nurse();
			nurse.setNurseId(rs.getInt("nurseid"));
			nurse.setFirstName(rs.getString("firstname"));
			nurse.setLastName(rs.getString("lastname"));
			nurse.setNurseEmailId(rs.getString("nurseemailid"));
			nurse.setPhoneNumber(rs.getInt("phonenumber"));
			nurse.setDeviceId(rs.getInt("deviceId"));
			list.add(nurse);
		}
		
		//list.add(nurse);
		rs.close();
		stmt.close();
		return list;
	}
	public static void main(String[] args) throws SQLException{
		NurseDao dao=new NurseDaoImpl();
		Nurse nur=new Nurse();
		nur.setDeviceId(110);
		nur.setFirstName("vidya");
		nur.setLastName("lakshmi");
		nur.setNurseEmailId("vidya@gmail.com");
		nur.setNurseId(9);
		nur.setPhoneNumber(111111);
		//dao.createNurse(nur);
		List<Nurse> nurses=dao.getAllNurses();
		for(Nurse nurse:nurses){
			System.out.println(nurse);
		}
	}

	@Override
	public String getNurseEmailId(int deviceid) throws SQLException {
Connection conn;
		
		conn = Connections.getConnection();
	
	System.out.println("connection obtained");
	String sql="select nurseemailid  from nurse where deviceid=?";
	PreparedStatement stmt=conn.prepareStatement(sql);
	//String email;
	stmt.setInt(1,deviceid);
	ResultSet rs=stmt.executeQuery();
	while(rs.next()){
		nurseemail=rs.getString("nurseemailid");
		
		
	}
	
	return nurseemail;
	}

}

	


