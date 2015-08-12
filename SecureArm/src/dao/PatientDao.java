package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Patient;

public interface PatientDao {
public boolean createPatient(Patient patient)throws SQLException;
public boolean updatePatient(int patientid,String emailid)throws SQLException;
public boolean deletePatient(int patientid)throws SQLException;
public List<Patient> getAllPatients()throws SQLException;
public Patient getPatientById(int patientid)throws SQLException;



}
