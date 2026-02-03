package com.gdm.mailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class Controller{

    @Autowired
    private Servico servico;

    @PostMapping("/envio")
    public String envio(@RequestBody EmailRequest request){

        // Mensagem para o centro.
        servico.enviaEmail(
            request.getPara(),
            "Agendamento de visita",
            request.getCorpo(),
            request.getDonde()
        );

        
        // Mensagem de confirmação pro usuário.
        servico.enviaEmail(
            request.getDonde(),
            "Confirmação de Envio",
            "Sua mensagem foi enviada com sucesso! Aguarde a confirmação de agendamento.",
            request.getPara()
        );

        return "E-mail enviado com sucesso!";
    }

}