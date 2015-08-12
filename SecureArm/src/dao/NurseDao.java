package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Nurse;

public interface NurseDao {
	public boolean createNurse(Nurse nurse) throws SQLException ;
	public boolean  updateNurse(int nurseid ,String emailid)throws SQLException;
	public boolean  deleteNurse(int nurseid)throws SQLException;
	public List<Nurse> getAllNurses()throws SQLException;
public String getNurseEmailId(int deviceid) throws SQLException;

	
	
	

}
