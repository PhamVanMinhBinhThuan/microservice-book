package com.ltfullstack.commonservice.services;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailService {
    
    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * Sends an email with the specified parameters.
     * 
     * @param to: recipient email address
     * @param subject: email subject
     * @param text: email content
     * @param isHtml: whether the email content is HTML or plain text
     * @param attachment: file to be attached to the email, can be null if no attachment
     */
    public void sendEmail(String to, String subject, String text, boolean isHtml, File attachment) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, isHtml);

            // Add attachment if provided
            if (attachment != null) {
                FileSystemResource fileSystemResource = new FileSystemResource(attachment);
                helper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
            }

            javaMailSender.send(message);
            log.info("Email sent successfully to {}", to);

        } catch (MessagingException ex) {
            log.error("Failed to send email to {}" + to, ex);
            // handle the exception (retry logic, save to dlq...)
        }
    }
}
