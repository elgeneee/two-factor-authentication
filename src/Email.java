
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class Email {
    private static boolean status;
    private static int random;



    public static void sendMail(String recipient) {
        Random rand = new Random();
        random = rand.nextInt(10000 - 1000 +1) + 1000;
        //authentication info
        final String username = "zolous.official@gmail.com";
        final String password = "08292000";
        String fromEmail = "zolous.official@gmail.com";
        String toEmail = recipient;
        System.out.println("Sending Email....");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }


        });
        //Start our mail message
        MimeMessage msg = new MimeMessage(session);
        try {
            status = true;
            msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            msg.setSubject("Factor Authentication");
            msg.setText("Your confirmation code is: " + random);
            Transport.send(msg);
            System.out.println("Email sent successfully");
            status = true;
        } catch (MessagingException e) {
            status = false;
            System.out.println("An error seems to be occurred...Please try again");
        }

    }

    public  int getRandom() {
        return random;
    }

    public boolean isStatus() {
        return status;
    }

}
