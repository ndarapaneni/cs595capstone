package daoImpl;


import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dao.DeviceReadingDao;
import dao.NurseDao;
import daoImpl.DeviceReadingDaoImpl;
import daoImpl.NurseDaoImpl;


public class Network {
   public static void main(String args[]) throws SQLException {
     DeviceReadingDao dbService = new DeviceReadingDaoImpl();
     NurseDao dao=new NurseDaoImpl();
      String staffEmail =dao.getNurseEmailId(120);
      System.out.println(staffEmail+" :");
        Network.sendEmail(100);
   }
     
      
  
   public static void sendEmail(int deviceid) throws SQLException {
      Properties properties = new Properties();
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.socketFactory.port", "465");
      properties.put("mail.smtp.socketFactory.class",
                     "javax.net.ssl.SSLSocketFactory");
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.port", "465");
      properties.put("mail.smtp.starttls.enable","true");
     
      // final String password = getSenderPwd();
      Session session = Session.getDefaultInstance(properties,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               // return new PasswordAuthentication("GMAIL id of sender", 
               // "PASSWORD of sender"); 
               return new PasswordAuthentication("neeraja.nelloru@gmail.com", 
                                      "Buddy12#");
            }
         }
      );

      DeviceReadingDao dbService = new DeviceReadingDaoImpl();
      NurseDao dao=new NurseDaoImpl();

      String staffEmail = dao.getNurseEmailId(deviceid);
      try {
         int patientId=dbService.getPatientId(deviceid);
         /*Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress("cs595vidhya@gmail.com"));
         message.setRecipients(Message.RecipientType.TO,
                               InternetAddress.parse(staffEmail));
         message.setSubject("CS595 " + "   " +  patientemailId+"   " 
                            + " vidhyalakshmi ");
         message.setText("code");*/
         
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress("cs595securearm@gmail.com"));
         message.setRecipients(Message.RecipientType.TO,
                               InternetAddress.parse(staffEmail));
         message.setSubject("Alert for :"+patientId+" from device:"+deviceid);
         message.setText("Dear Staff,"
            + "\n\n This is an alert send for patientId:"+patientId+" from Device:"
            + deviceid);
         Transport.send(message);
         System.out.println("Message sended to Nurse");
         System.out.println("Done");
      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
         
         
   }
}
