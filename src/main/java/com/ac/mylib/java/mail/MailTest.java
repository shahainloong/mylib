package com.ac.mylib.java.mail;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

/**
 * This program shows how to use JavaMail to send mail messages.
 * @author Cay Horstmann
 * @version 1.00 2012-06-04
 */
public class MailTest
{
   public static void main(String[] args) throws MessagingException, IOException, URISyntaxException {
      Properties props = new Properties();
//      String path = MailTest.class.getClassLoader().getResource("mail.properties").getPath();
//      try (InputStream in = Files.newInputStream(Paths.get("C:\\D\\workspace-idea\\mylib\\src\\main\\java\\com\\ac\\mylib\\java\\mail\\mail.properties")))
//      {
//         props.load(in);
//      }
//      List<String> lines = Files.readAllLines(Paths.get("C:\\D\\workspace-idea\\mylib\\src\\main\\java\\com\\ac\\mylib\\java\\mail\\message.txt"), Charset.forName("UTF-8"));
      try (InputStream in = MailTest.class.getClassLoader().getResourceAsStream("mail.properties")) {
         props.load(in);
      }
      URL url = Thread.currentThread().getContextClassLoader().getResource("message.txt");

      List<String> lines = Files.readAllLines(Paths.get(url.toURI()), Charset.forName("UTF-8"));
      String from = lines.get(0);
      String to = lines.get(1);
      String cc = "zachary.li@sap.com";
      String subject = lines.get(2);

      StringBuilder builder = new StringBuilder();
      for (int i = 3; i < lines.size(); i++)
      {
         builder.append(lines.get(i));
         builder.append("\n");
      }
      
//      Console console = System.console();
//      String password = new String(console.readPassword("Password: "));
      String password = "JWGAJPIITOPXDTAT";

      Session mailSession = Session.getDefaultInstance(props);
      // mailSession.setDebug(true);
      MimeMessage message = new MimeMessage(mailSession);
      message.setFrom(new InternetAddress(from));
      message.addRecipient(RecipientType.TO, new InternetAddress(to));
//      message.addRecipient(RecipientType.CC, new InternetAddress(cc));
      message.setSubject(subject);
      message.setText(builder.toString());
      Transport tr = mailSession.getTransport();
      try
      {
         tr.connect(null, password);
         tr.sendMessage(message, message.getAllRecipients());
      }
      finally
      {
         tr.close();
      }
   }
}
