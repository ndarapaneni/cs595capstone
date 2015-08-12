package dao;

import java.sql.SQLException;
import java.util.List;

import domain.DeviceReading;

public interface DeviceReadingDao {
	public boolean insertReadings(DeviceReading devicereading)throws SQLException;
	public DeviceReading getAll(int patientid) throws SQLException;
	public  int  getPatientId(int deviceid) throws SQLException;
public List<DeviceReading> getAll() throws SQLException;
}
