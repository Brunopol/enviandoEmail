package enviandoEmail.enviandoEmail.classes;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ObjetoEnviarEmail {

	private String userName = "brunomiria.brownies@gmail.com";
	private String userPassword = "eybcemptrqxedshl";

	private String nomeQueApareceNoInbox = "";
	private String emailDeQuemRecebe = "";
	private String emailAssunto = "";
	private String emailTexto = "";

	public ObjetoEnviarEmail(String nomeQueApareceNoInbox, String emailDeQuemRecebe, String emailAssunto,
			String emailTexto) {

		this.nomeQueApareceNoInbox = nomeQueApareceNoInbox;
		this.emailDeQuemRecebe = emailDeQuemRecebe;
		this.emailAssunto = emailAssunto;
		this.emailTexto = emailTexto;

	}

	public void enviarEmail(boolean enviarHtml) {

		try {

			Properties properties = new Properties();
			properties.put("mail.smtp.ssl.trust", "*");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "465");
			properties.put("mail.smtp.socketFactory.port", "465");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, userPassword);
				}
			});

			Address[] toUser = InternetAddress.parse(emailDeQuemRecebe);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName, nomeQueApareceNoInbox));
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(emailAssunto);

			if (enviarHtml) {

				message.setContent(emailTexto, "text/html; charset=utf-8");

			} else {
				message.setText(emailTexto);
			}

			Transport.send(message);
			System.out.println("e-mail enviado com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("e-mail deu errado");
		}

	}

}
