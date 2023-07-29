package ftn.graduatethesispolovniautomobili.service;


import ftn.graduatethesispolovniautomobili.model.dto.user.request.UserRegistrationRequestDTO;

public interface EmailService {

    void sendEmail(String to, String subject, String text);

    void sendVerificationEmail(UserRegistrationRequestDTO userRegistrationRequestDTO);
}
