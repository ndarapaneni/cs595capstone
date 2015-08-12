package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PatientDao;

import domain.Patient;

public class PatientDaoImpl implements PatientDao{

	@Override
	public boolean createPatient(Patient patient) throws SQLException {
		Connection conn=Connections.getConnection();
		System.out.println("connetion obtained");
		String sql="insert into patient values (?,?,?,?,?,?,?)";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1, patient.getPatientId());
		stmt.setString(2, patient.getFirstName());
		stmt.setString(3, patient.getLastName());
		stmt.setString(4, patient.getPatientEmailId());
		stmt.setInt(5, patient.getPhoneNumber());
		stmt.setString(6, patient.getCity());
		stmt.setString(7, patient.getState());
		int result=stmt.executeUpdate();
		System.out.println(" no of rows inserted succesfully are="+result);
		stmt.close();
		return true;
		
	}

	@Override
	public boolean updatePatient(int patientid, String emailid) throws SQLException {
		Connection conn=Connections.getConnection();
		String sql="update patient set patientemailid=? where patientid=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1, emailid);
		stmt.setInt(2,patientid);
		int result=stmt.executeUpdate();
		System.out.println("number of rows updated are :"+result);
		stmt.close();
		return true;
		
	}

	@Override
	public boolean deletePatient(int patientId) throws SQLException {
		Connection conn=Connections.getConnection();
		String sql="delete from patient where patientid=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1, patientId);
		int result=stmt.executeUpdate();
		System.out.println("no of rows deleted  :"+result);
		stmt.close();
		return true;
	}
	

	@Override
	public List<Patient> getAllPatients() throws SQLException {
		Connection conn=Connections.getConnection();
		System.out.println("connection obtained");
		String sql="select * from patient";
		PreparedStatement stmt=conn.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		List<Patient> list=new ArrayList<Patient>();;
		Patient	patient;
		while(rs.next()){
			patient=new Patient();
			patient.setPatientId(rs.getInt("patientid"));
			patient.setFirstName(rs.getString("firstname"));
			patient.setLastName(rs.getString("lastname"));
			patient.setPatientEmailId(rs.getString("patientemailid"));
			patient.setPhoneNumber(rs.getInt("phonenumber"));
			patient.setCity(rs.getString("city"));
			patient.setState(rs.getString("state"));
			list.add(patient);
		}
		
		//list.add(patient);
		rs.close();
		stmt.close();
		return list;
	}

	@Override
	public Patient getPatientById(int patientid) throws SQLException {
		Connection conn=Connections.getConnection();
		System.out.println("connection obtained");
		String sql="select * from patient where patientid=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1,patientid);
		ResultSet rs=stmt.executeQuery();
		
		Patient patient=new Patient();
		while(rs.next()){
			patient=new Patient();
			patient.setPatientId(rs.getInt("patientid"));
			patient.setFirstName(rs.getString("firstname"));
			patient.setLastName(rs.getString("lastname"));
			patient.setPatientEmailId(rs.getString("patientemailid"));
			patient.setPhoneNumber(rs.getInt("phonenumber"));
			patient.setCity(rs.getString("city"));
			patient.setState(rs.getString("state"));
		}
		return patient;
	}

	public static void main(String args[]) throws SQLException{
		Patient p=new Patient();
		p.setPatientId(10);
		p.setFirstName("anu");
		p.setLastName("bodapati");
		p.setPatientEmailId("anu@gmail.com");
		p.setPhoneNumber(2222222);
		p.setCity("fremont");
		p.setState("ca");
		PatientDao dao=new PatientDaoImpl();
		//dao.createPatient(p);
		List<Patient> list=dao.getAllPatients();
		for(Patient pa:list){
			System.out.println(pa);
			
		}
	}
	

}
