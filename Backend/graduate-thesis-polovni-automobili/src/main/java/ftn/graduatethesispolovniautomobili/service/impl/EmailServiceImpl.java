package ftn.graduatethesispolovniautomobili.service.impl;

import ftn.graduatethesispolovniautomobili.model.dto.user.request.UserRegistrationRequestDTO;
import ftn.graduatethesispolovniautomobili.security.TokenUtils;
import ftn.graduatethesispolovniautomobili.service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private static final String SENT_FROM = "graduatepolovni.automobili@gmail.com";
    private static final String VERIFY_API_URL = "http://localhost:4200/verify?token="; //this is the frontend page where the user will enter the new pass
    private static final String SUBJECT_VERIFICATION = "Verify account";

    private final TokenUtils tokenUtils;
    private final JavaMailSender mailSender;

    public EmailServiceImpl(TokenUtils tokenUtils, JavaMailSender mailSender) {
        this.tokenUtils = tokenUtils;
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(SENT_FROM);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }


    @Override
    public void sendVerificationEmail(UserRegistrationRequestDTO userRegistrationRequestDTO) {
        SimpleMailMessage message = new SimpleMailMessage();

        String text = "Please check the link bellow and create a password within the next 60 minutes.Thanks!\n" +
                "Link: " + VERIFY_API_URL + tokenUtils.generateToken(userRegistrationRequestDTO.getEmail(), "ROLE_" + userRegistrationRequestDTO.getRole().toString());

        message.setFrom(SENT_FROM);
        message.setTo(userRegistrationRequestDTO.getEmail());
        message.setSubject(SUBJECT_VERIFICATION);
        message.setText(text);

        mailSender.send(message);
    }
}
