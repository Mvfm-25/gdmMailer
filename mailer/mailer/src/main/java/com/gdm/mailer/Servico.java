package com.gdm.mailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Servico {
    
    @Autowired 
    private JavaMailSender sender;

    public void enviaEmail(String para, String assunto, String corpo, String replyTo){
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(para);
        mensagem.setSubject(assunto);
        mensagem.setText(corpo + "\nMensagem enviada por : " + replyTo);

        // Pra simplesmente aperta o botão 'Reply'
        mensagem.setReplyTo(replyTo);

        sender.send(mensagem);
    }
}
