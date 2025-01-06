package top.xym.springboot.task.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import top.xym.springboot.task.entity.EmailLog;
import top.xym.springboot.task.mapper.EmailLogMapper;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {
    private final JavaMailSender mailSender;

    private final EmailLogMapper emailLogMapper;

    public void sendEmail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1286280961@qq.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        // 发送邮件
        mailSender.send(message);

        // 将发送记录保存到数据库
        EmailLog log = new EmailLog();
        log.setRecipient(to);
        log.setSubject(subject);
        log.setContent(content);
        log.setSendAt(LocalDateTime.now());
        emailLogMapper.insert(log);

        System.out.println("邮件已发送至：" + to);
    }
}
