/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package EMAILARCHIVING_DAN;

/**
 *
 * @author dgraham
 */


import java.util.*;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.naming.*;

import java.io.IOException;
import java.security.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        Session session;
        Store store = null;
        String hot_em_address;
        String hot_em_password;
        String hot_em_host;
       String goog_em_address;
        String goog_em_password;
        String goog_em_host;
        
        File curDir = new File("./customerPhotos");
        File[] filesList = curDir.listFiles();
        for(File f : filesList){
            if(f.isDirectory())
                curDir = new File("./customerPhotos/"+f.getName());
                filesList = curDir.listFiles();
                for(File f2 : filesList) {
                	if (f2.getName().equals("setup.conf")) {
                		Charset charset = Charset.forName("UTF-8");
                		Path conf_path = Paths.get("./customerPhotos/"+f.getName(), "/setup.conf");
                		List<String> lines = Files.readAllLines(conf_path, charset);
                        hot_em_address = lines.get(0);
                        hot_em_password = lines.get(1);
                        hot_em_host = lines.get(2);
                        goog_em_address = lines.get(3);
                        goog_em_password = lines.get(4);
                        goog_em_host = lines.get(5);
        
        Folder folder = null;
        Message[] messages;
        Message message = null;
 //       Security.addProvider( new com.sun.net.ssl.internal.ssl.Provider());
        
        Properties props = System.getProperties();
        
    //    props.setProperty( "mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    //    props.setProperty( "mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty( "mail.store.protocol", "imaps");
        props.setProperty("mail.imap.port", "993");
        props.setProperty("mail.imap.connectiontimeout", "50000000");
        props.setProperty("mail.imap.timeout", "50000000");
        props.setProperty("mail.imaps.port", "993");
        props.setProperty("mail.imaps.connectiontimeout", "50000000");
        props.setProperty("mail.imaps.timeout", "50000000");
        props.setProperty("mail.imap.statuscachetimeout", "50000000");
        props.setProperty("mail.imaps.statuscachetimeout", "50000000");
   //     props.setProperty( "mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   //             props.setProperty( "mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   //     props.setProperty( "mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
 //       props.put("mail.from", "daniel.edward.graham@gmail.com");
          props.put("mail.from", goog_em_address);
 //       props.setProperty( "mail.pop3.port", "995");
 //       props.setProperty( "mail.pop3.socketFactory.port", "995");
 //       Security.setProperty( "javax.net.ssl.SocketFactory.provider", "DummySSLSocketFact");
 //       props.setProperty("javax.mail.pop3.starttls.enable", "true");
 //       props.setProperty("javax.mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");  
 //       props.setProperty("javax.mail.pop3.socketFactory.fallback", "false");  
 //       props.setProperty("javax.mail.pop3.port", "995");  
 //       props.setProperty("javax.mail.pop3.socketFactory.port", "995");
        
//        session = Session.getDefaultInstance(props, null);
        session = Session.getInstance(props);
      // -- Get hold of a POP3 message store, and connect to it --
//      store = session.getStore("pop3");
//        try {
//            InitialContext ic = new InitialContext();
//            String snName = "dns:";
//            session = (javax.mail.Session)ic.lookup(snName);
//        } catch (NamingException e) {
//            System.out.println("Error: Naming Exception :" + e.getMessage());
//            return;        
//        }
//        Properties props = session.getProperties();
     URLName urln;
     String subject = null;
     long maxmesg = 12000000;
     try {
            store = session.getStore("imaps");
            System.out.println("getStore complete");
  //          store.connect();
  //          store.connect("imap.gmail.com", "daniel.edward.graham@gmail.com", "!!VC244562R01//#//2121");
            store.connect(hot_em_host, hot_em_address, hot_em_password);
            System.out.println("Connect complete");
            folder = store.getFolder("INBOX");
            System.out.println("getFolder INBOX complete");
            folder.open(Folder.READ_ONLY);
            messages = folder.getMessages();
            maxmesg = messages.length;
     } catch (Exception e) {
     }
     
     
     for (int ii=0; ii<=maxmesg; ii++) {
         if ((ii % 200) == 0) {
           try {
        	   folder.close(true);
        	   store.close();
   
////////            urln = new URLName("pop3", "pop.gmail.com", 995, null, "daniel.edward.graham", "!!VC244562R01//#//2121");
//            store = session.getStore(urln);
            store = session.getStore("imaps");
            System.out.println("getStore complete");
  //          store.connect();
 //           store.connect("imap-mail.outlook.com", "daniel.edward.graham@hotmail.com", "jiecucnan777");
            store.connect(hot_em_host, hot_em_address, hot_em_password);
            System.out.println("Connect complete");
            folder = store.getFolder("INBOX");
            System.out.println("getFolder INBOX complete");
            folder.open(Folder.READ_ONLY);
//            messages = folder.getMessages();
//            System.out.println("getMessages complete");
 //           store.close();
        } catch (javax.mail.NoSuchProviderException e) {
            System.out.println("Error: NoSuchProviderException :" + e.getMessage());
            return;
        } catch (MessagingException e) {
            System.out.println("Error: MessagingException :" + e.getMessage());
            try {
            Thread.sleep(2000);
            store.connect(hot_em_host, hot_em_address, hot_em_password);
            System.out.println("Connect complete");
            folder = store.getFolder("INBOX");
            System.out.println("getFolder INBOX complete");
            folder.open(Folder.READ_ONLY);
            } catch (MessagingException e2) {
            	System.out.println("Error: 2 Messaging Exceptions : " + e2.getMessage());
            	return;
            } catch (InterruptedException e3) {
            	
            }
            continue;            
        }
         }
        try {
           message = folder.getMessage(ii);
        } catch (Exception e) {
        	System.out.println("getMessage Error: "+e.getMessage());
            
        }
//        for (int i=0; i<messages.length; i++) {
        try {
            subject = message.getSubject();
            System.out.println("===========> subj: " + subject + " <============");
        } catch (Exception e) {
        	System.out.println("getSubject Error" + e.getMessage());
            
        }    
            if (subject != null && subject.contentEquals("Hi! Motion detected, take a look at attached images.")) {
     //       System.out.println("===========> From: " + messages[i].getFrom().toString() + " <============");
            OutputStream out = null;
            try {
            Object cont = message.getContent();
            MimeMultipart mcont = MimeMultipart.class.cast(cont);
            MimeBodyPart pcont = MimeBodyPart.class.cast(mcont.getBodyPart(1));
//*            InputStream fis;
//*                fis = DataInputStream(pcont.getRawInputStream());
                            Date e = message.getSentDate();
                String es = e.toString();
                es = es.replace(" ","_");
                es = es.replace(":","_");
                pcont.saveFile("./customerPhotos/"+f.getName()+"/"+es+".jpg");
 //               pcont.saveFile("/photos/"+es + ".jpg");
            
//*                OutputStream output = new FileOutputStream("/home/dgraham/dgwPic/"+es + ".txt");
//* try{ byte[] buffer = new byte[8 * 1024];
  
//*    int bytesRead;
//*    while ((bytesRead = fis.read(buffer)) != -1) {
//*      output.write(buffer, 0, bytesRead);
//*    } 
//     out = new FileOutputStream("/home/dgraham/dgwPic/"+es + ".jpg");
//     byte b;
//     while ((b=(byte)fis.read()) >= 0) {  
//     out.write(b);
//     }
 //*     }  
 //*   finally{  
 //*    output.flush();
 //*   if(output !=null)  {
 //*       output.close(); 
 //*   }
 //*     }  
                
                
                System.out.println("Subject: " + message.getSubject());

System.out.println("Message Inbox date :"+es);
     //       System.out.println("Body: " + messages[i].getContent().toString());
     } catch (Exception e) {
          System.err.println(e.getMessage());             
            }
            }
            subject = null;
        }
    }
}
        }
    }
}
//      } catch (MessagingException e) {
//            System.out.println("Error: MessagingException: " + e.getMessage());
//            return;
//       } catch (IOException e) {
//            System.out.println("Error: IOException: " + e.getMessage());
//            return;
//        }
//    }

//}