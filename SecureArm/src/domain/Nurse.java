package domain;

public class Nurse {
private int nurseId;
private String firstName;
private String lastName;
private String nurseEmailId;
private int PhoneNumber;
private int deviceId;

public int getDeviceId() {
	return deviceId;
}
public void setDeviceId(int deviceId) {
	this.deviceId = deviceId;
}
public int getNurseId() {
	return nurseId;
}
public void setNurseId(int nurseId) {
	this.nurseId = nurseId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getNurseEmailId() {
	return nurseEmailId;
}
public void setNurseEmailId(String nurseEmailId) {
	this.nurseEmailId = nurseEmailId;
}
public int getPhoneNumber() {
	return PhoneNumber;
}
public void setPhoneNumber(int phoneNumber) {
	PhoneNumber = phoneNumber;
}
@Override
public String toString() {
	return "Nurse [nurseId=" + nurseId + ", firstName=" + firstName
			+ ", lastName=" + lastName + ", nurseEmailId=" + nurseEmailId
			+ ", PhoneNumber=" + PhoneNumber + ", deviceId=" + deviceId + "]";
}

}


