/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ttest2;

/**
 *
 * @author graham
 */


import java.util.*;


import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.naming.*;
import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.SSLSession;
import com.sun.mail.imap.IMAPStore;

import org.omg.CORBA.FixedHolder;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.org.apache.bcel.internal.generic.SASTORE;

import java.security.*;

import java.io.*;

public class mMain {

    /**
     * @param args the command line arguments
     */
	public static void main(String[] args) {
 //       ExtendedSSLSession session = new ExtendedSSLSession(0);
    
        Store store = null;
        Folder folder = null;
        Message[] messages = new Message[100];
        Message message = null;
        Security.addProvider( new com.sun.net.ssl.internal.ssl.Provider());
        
        Properties props = System.getProperties();
        
    //    props.setProperty( "mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    //    props.setProperty( "mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty( "mail.store.protocol", "imaps");
    //    props.put("mail.imaps.ssl.trust", "/usr/local/ssl/imap.theos.in.key");
        props.put("mail.imaps.ssl.trust", "*");
  //      props.setProperty("mail.imaps.ssl.trust", "*");
   //     props.setProperty( "mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   //             props.setProperty( "mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
   //     props.setProperty( "mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      
        try {
            FileInputStream in = new FileInputStream("/cgi-bin/customers.txt");
           
            byte s[] = null;
    //        int bytes[] = null;
            Integer numberOfBytesRead = null;
            numberOfBytesRead = in.read(s);
            System.err.print(s);
            in.close();
            
        } catch(IOException e) {
        	
           System.err.print(e.getLocalizedMessage());
        	
        } finally {
       
        }
            
            
        
        props.put("mail.from", "daniel.edward.graham@gmail.com");
 //       props.put("mail.from", "daniel.edward.graham@hotmail.com");
 //       props.setProperty( "mail.pop3.port", "995");
 //       props.setProperty( "mail.pop3.socketFactory.port", "995");
 //       Security.setProperty( "javax.net.ssl.SocketFactory.provider", "DummySSLSocketFact");
 //       props.setProperty("javax.mail.pop3.starttls.enable", "true");
 //       props.setProperty("javax.mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");  
 //       props.setProperty("javax.mail.pop3.socketFactory.fallback", "false");  
 //       props.setProperty("javax.mail.pop3.port", "995");  
 //       props.setProperty("javax.mail.pop3.socketFactory.port", "995");
        
 //       session = ExtendedSSLSession.getDefaultInstance(props, null);
//        session = se
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
     long maxmesg = 10000;
     try {
//            store = Session.getStore("imaps");
    	 Session mailsession=Session.getInstance(props,null);
    	 
    	 
    	 Session session = mailsession;

    	 mailsession.setDebug(true);

    	 store = (IMAPStore)mailsession.getStore("imaps");

//    	 store.connect(imapserver,user,pwd);
//    	 Session mailsession = IMAPStore.getStore("imaps");
            System.out.println("getStore complete");
  //          store.connect();
            store.connect("imap.gmail.com", "daniel.edward.graham@gmail.com", "!!VC244562R01//#2121");
//            store.connect("imap.gmail.com", "daniel.edward.graham@hotmail.com", "jiecucnan777");
            System.out.println("Connect complete");
            folder = store.getFolder("INBOX");
            System.out.println("getFolder INBOX complete");
            folder.open(folder.READ_ONLY);
            Message[] messages2 = new Message[100];
            maxmesg = messages2.length;
     } catch (Exception e) {
     }
     
     @SuppressWarnings("unused")
	javax.mail.Message[] messages3 = new javax.mail.Message[100];
     for (int ii=0; ii<=maxmesg; ii++) {
         if ((ii % 200) == 0) {
           try {
        	   
 //           urln = new URLName("pop3", "pop.gmail.com", 995, null, "daniel.edward.graham", "!!VC244562R01//#2121");
//            store = session.getStore(urln);
//            store = session.getStore("imaps");
            Session mailsession=Session.getInstance(props,null);
            store = (IMAPStore)mailsession.getStore("imaps");
            System.out.println("getStore complete");
  //          store.connect();
            store.connect("imap.gmail.com", "daniel.edward.graham@gmail.com", "!!VC244562R01//#2121");
  //          store.connect("imap.gmail.com", "daniel.edward.graham@hotmail.com", "jiecucnan777");
            System.out.println("Connect complete");
            folder = store.getFolder("INBOX");
            System.out.println("getFolder INBOX complete");
            folder.open(folder.READ_ONLY);
            messages3 = folder.getMessages();
//            System.out.println("getMessages complete");
            folder.close(true);
            store.close();
            
            
            
        } catch (javax.mail.NoSuchProviderException e) {
            System.out.println("Error: NoSuchProviderException :" + e.getMessage());
            return;
        } catch (MessagingException e) {
            System.out.println("Error: MessagingException :" + e.getMessage());
            return;            
        }
         }
        try {
           message = (Message) folder.getMessage(ii);
        } catch (Exception e) {
            
        }
        for (int i=0; i<messages.length; i++) {
        try {
            subject = ((javax.mail.Message) messages[i]).getSubject();
            System.out.println("===========> subj: " + subject + " <============");
        } catch (Exception e) {
            
        }    
 //           if (subject != null && subject.contentEquals("Hi! Motion detected, take a look at attached images.")) {
           try {
        	   
        	   @SuppressWarnings("unused")
			Folder folder2 = null;
        	   
        	   folder2 = store.getFolder("INBOX");
               System.out.println("getFolder INBOX complete");
               folder.open(folder.READ_ONLY);
        
        	   folder.open(folder.READ_ONLY);
        	   messages3 = folder.getMessages();
				System.out.println("===========> From: " + ((javax.mail.Message) messages3[i]).getFrom().toString() + " <============");
			} catch (MessagingException e1) {
				// TODO Auto-generated catch block0
				e1.printStackTrace();
			}
            OutputStream out = null;
            try {
            Object cont = ((Part) message).getContent();
            MimeMultipart mcont = MimeMultipart.class.cast(cont);
            MimeBodyPart pcont = MimeBodyPart.class.cast(mcont.getBodyPart(1));
//*            InputStream fis;
//*                fis = DataInputStream(pcont.getRawInputStream());
                            Date e = ((javax.mail.Message) message).getSentDate();
                String es = e.toString();
                es = es.replace(" ","_");
                es = es.replace(":","_");
                pcont.saveFile("/home/danieledwardgraham/dgwPic5/"+es + ".jpg");
            
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
                
                
                System.out.println("Subject: " + ((javax.mail.Message) message).getSubject());

System.out.println("Message Inbox date :"+es);
     //       System.out.println("Body: " + messages[i].getContent().toString());
     } catch (Exception e) {
                
            }
            }
            subject = null;
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
     