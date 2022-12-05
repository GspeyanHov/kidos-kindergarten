package am.friendsWebGroup.kidoskindergarten.service;

import am.friendsWebGroup.kidoskindergarten.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;

    private static final String text = "please verify your account by clicking on this link " +
            "<a href=http://localhost:8080/user/verify?email=%s&token=%s>Activate</a>";

    private final static String subject = "Dear %s, please verify your email ";

    @Async
    public void sendEmail(User user) {
        try {
            MimeMessage mailMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage);
            helper.setTo(user.getEmail());
            helper.setSubject(format(subject,user.getName()));
            helper.setText(format(text,user.getEmail(),user.getVerifyToken()), true);
            mailSender.send(mailMessage);
        } catch (MessagingException e) {
            throw new IllegalStateException(e);
        }
    }
}
