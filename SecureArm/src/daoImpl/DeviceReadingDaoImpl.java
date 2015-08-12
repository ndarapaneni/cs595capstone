package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;
import java.util.List;

import dao.DeviceReadingDao;
import domain.DeviceReading;


public class DeviceReadingDaoImpl  implements DeviceReadingDao{
	int patientid;
	
	
		public static int findRiskClass( int deviceId,double accelx, double accely,double accelz, double orientx,double orienty, double orientz,double latitude,double longitude, int pid) throws SQLException {
			 int riskClass = 1;
			 //boolean min = false, max = false;
			 double x, y, z, ox, oy, oz,lat,lon;
			 int devid,patientid;
			 devid=deviceId;
			 patientid=pid;
			 x = accelx;
			 y = accely;
			 z = accelz;
			 ox = orientx;
			 oy = orienty;
			 oz = orientz;
			 lat=latitude;
			 lon=longitude;
			 double a = Math.round(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)
			 + Math.pow(z, 2)));
			 if (a == 10 || a == 9) {
			 riskClass = 1;
			 } else if (a == 8 || a == 7) {
			 riskClass = 2;
			 } else if (a == 4 || a == 5 || a == 6) {
			 riskClass = 3;
			 } else if (a == 1 || a == 2 || a == 3) {
			 riskClass = 4;
			 } else if (a == 0) {
			 riskClass = 5;
			 }
			// saveActivity(accel, orient, riskClass, deviceId);
			 System.out.println(riskClass);
			 updateReadings( devid,x,y,z,ox,oy, oz, lat,lon, riskClass ,patientid);
			 return riskClass;

	}
	@Override
	public boolean insertReadings(DeviceReading dread) throws SQLException  {
		Connection conn=Connections.getConnection();
		System.out.println("connetion obtained");
		//int riskRate = calculateRisk(dread.getAccX(),dread.getAccY());
		String sql="insert into devicereading values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1, dread.getDeviceId());
		stmt.setDouble(2, dread.getAccX());
		stmt.setDouble(3, dread.getAccY());
		stmt.setDouble(4, dread.getAccZ());
		stmt.setDouble(5, dread.getGyroX());
		stmt.setDouble(6, dread.getGyroY());
		stmt.setDouble(7, dread.getGyroZ());
		stmt.setDouble(8, dread.getLatitude());
		stmt.setDouble(9, dread.getLongitude());
		stmt.setInt(10, dread.getRiskLevel());
		stmt.setInt(11,dread.getPatientId());
		//stmt.setString(10, dread.getPatientEmailId());
		
		//stmt.setString(11, dread.getNurseEmailId());
		
		int result=stmt.executeUpdate();
		System.out.println(" no of rows inserted succesfully are="+result);
		stmt.close();
		return true;
		
	}
	public  static boolean  updateReadings(int deviceId,double accelx, double accely,double accelz, double orientx,double orienty, double orientz,double latitude,double longitude,int riskclass ,int pid) throws SQLException{
		Connection conn=Connections.getConnection();
		System.out.println("connection obtained");
		String sql="update devicereading set deviceid=?, AccX=?,  AccY=?, AccZ=?, GyroX=?, GyroY=?, GyroZ=?, latitude=?, longitude=?,Risklevel=? where patientid=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1, deviceId);
		stmt.setDouble(2, accelx);
		stmt.setDouble(3, accely);
		stmt.setDouble(4, accelz);
		stmt.setDouble(5, orientx);
		stmt.setDouble(6, orienty);
		stmt.setDouble(7, orientz);
		stmt.setDouble(8, latitude);
		stmt.setDouble(9, longitude);
		stmt.setInt(10,riskclass);
		stmt.setInt(11, pid);
		int result=stmt.executeUpdate();
		System.out.println(" no of rows updated succesfully are="+result);
		stmt.close();
		
	return true;
	}

	@Override
	public DeviceReading getAll(int patientid) throws SQLException {
		Connection conn=Connections.getConnection();
		System.out.println("connection obtained");
		String sql="select * from devicereading where patientid=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1,patientid);
		ResultSet rs=stmt.executeQuery();
		//List<DeviceReading> list=new ArrayList<DeviceReading>();;
		DeviceReading read=new DeviceReading();
		while(rs.next()){
			read.setDeviceId(rs.getInt("deviceId"));
			read.setAccX(rs.getDouble("accX"));
			read.setAccY(rs.getDouble("accY"));
			read.setAccZ(rs.getDouble("accZ"));
		read.setGyroX(rs.getDouble("gyroX"));
			read.setGyroY(rs.getDouble("gyroY"));
			read.setGyroZ(rs.getDouble("gyroZ"));
			read.setLatitude(rs.getDouble("latitude"));
			read.setLongitude(rs.getDouble("longitude"));
			read.setRiskLevel(rs.getInt("riskLevel"));
			read.setPatientId(rs.getInt("patientid"));
			
		}
		System.out.println(read);
		//list.add(read);
		rs.close();
		stmt.close();
		return read;
	}

	public List<DeviceReading> getAll() throws SQLException {
		Connection conn=Connections.getConnection();
		System.out.println("connection obtained");
		String sql="select * from devicereading ";
		PreparedStatement stmt=conn.prepareStatement(sql);
		//stmt.setInt(1,patientid);
		ResultSet rs=stmt.executeQuery();
		List<DeviceReading> list=new ArrayList<DeviceReading>();;
		DeviceReading read;
		while(rs.next()){
			read=new DeviceReading();
			read.setDeviceId(rs.getInt("deviceId"));
			read.setAccX(rs.getDouble("accX"));
			read.setAccY(rs.getDouble("accY"));
			read.setAccZ(rs.getDouble("accZ"));
		read.setGyroX(rs.getDouble("gyroX"));
			read.setGyroY(rs.getDouble("gyroY"));
			read.setGyroZ(rs.getDouble("gyroZ"));
			read.setLatitude(rs.getDouble("latitude"));
			read.setLongitude(rs.getDouble("longitude"));
			read.setRiskLevel(rs.getInt("riskLevel"));
			read.setPatientId(rs.getInt("patientid"));
			list.add(read);	
		}
		//System.out.println(read);
		//list.add(read);
		rs.close();
		stmt.close();
		return list;
	}

	public int getPatientId(int deviceid) throws SQLException {
		Connection conn;
		
			conn = Connections.getConnection();
		
		System.out.println("connection obtained");
		String sql="select patientid  from devicereading where deviceid=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1,deviceid);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()){
			patientid=rs.getInt("patientid");
			
			
		}
		
		return patientid;
	}

	
public static void main(String[] args) throws SQLException{
	DeviceReadingDao dao=new DeviceReadingDaoImpl();
	DeviceReading dread=new DeviceReading();
	dread.setDeviceId(110);
	dread.setAccX(0.0);
	dread.setAccY(0.0);
	dread.setAccZ(0.0);
	dread.setGyroX(0.0);
	dread.setGyroY(0.0);
	dread.setGyroZ(0.0);
	dread.setLatitude(0.0);
	dread.setLongitude(0.0);
	dread.setPatientId(10);
	//dao.insertReadings(dread);
	//dao.getAll(10);
	
	//int risk=findRiskClass(110,1.0,1.0,1.0,1.0,1.0,1.0,15.0,15.0,10);
	//System.out.println(risk);
	int id=dao.getPatientId(110);
	System.out.println(id);
	
}
}
