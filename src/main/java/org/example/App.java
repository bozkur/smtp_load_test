package org.example;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ServerInformation serverInformation = new ServerInformation("mardin.ccb.org", 25, false);
        SmtpUser smtpUser = new SmtpUser("cevher", "123456");
        MessageSendOperation sendOperation = new MessageSendOperation(serverInformation, smtpUser);
        sendOperation.createSession();
        sendOperation.sendMessage("cevher@mardin.ccb.org", "cemal@mardin.ccb.org");
    }
}