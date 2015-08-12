package domain;

public class DeviceReading {
	private int deviceId;
	private double accX;
	private double accY;
	private double accZ;
	private double gyroX;
	private double gyroY;
	private double gyroZ;
	private double latitude;
	private double longitude;
	private int riskLevel;
	private int patientId;
	
	
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public double getAccX() {
		return accX;
	}
	public void setAccX(double accX) {
		this.accX = accX;
	}
	public double getAccY() {
		return accY;
	}
	public void setAccY(double accY) {
		this.accY = accY;
	}
	public double getAccZ() {
		return accZ;
	}
	public void setAccZ(double accZ) {
		this.accZ = accZ;
	}
	public double getGyroX() {
		return gyroX;
	}
	public void setGyroX(double gyroX) {
		this.gyroX = gyroX;
	}
	public double getGyroY() {
		return gyroY;
	}
	public void setGyroY(double gyroY) {
		this.gyroY = gyroY;
	}
	public double getGyroZ() {
		return gyroZ;
	}
	public void setGyroZ(double gyroZ) {
		this.gyroZ = gyroZ;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public int getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(int riskLevel) {
		this.riskLevel = riskLevel;
	}
	@Override
	public String toString() {
		return "DeviceReading [deviceId=" + deviceId + ", accX=" + accX
				+ ", accY=" + accY + ", accZ=" + accZ + ", gyroX=" + gyroX
				+ ", gyroY=" + gyroY + ", gyroZ=" + gyroZ + ", latitude="
				+ latitude + ", longitude=" + longitude + ", riskLevel="
				+ riskLevel + ", patientId=" + patientId + "]";
	}
	
}
