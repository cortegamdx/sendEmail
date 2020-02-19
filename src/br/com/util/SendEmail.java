package br.com.util;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

public class SendEmail {


	public void sendEmail(String caminho, String desc_arquivo,String nome_arquivo){
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSslSmtpPort("465");
		email.setStartTLSRequired(true);
		email.setStartTLSEnabled(true);
		email.setSSLOnConnect(true);

		email.setAuthentication("email@gmail.com", "senha");
		try{
			email.setFrom("email@gmail.com");
			email.setMsg("Segue arquivo em anexo");
			email.setSubject("Assunto");
			email.addTo("paraEmail@gmail.com");
			
			
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(caminho);
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription(desc_arquivo);
			attachment.setName(nome_arquivo);
			
			email.attach(attachment);
			email.send();
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}
