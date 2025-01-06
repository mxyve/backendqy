package top.xym.springboot.task.task;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.xym.springboot.task.service.MailService;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
@Slf4j
public class DailyReportTask {

    private final MailService mailService;

    @Scheduled(cron = "0 22 20 * * ?")
    public void generateAndSendReport() {
        String report = generateReport();
        String recipient = "1286280961@qq.com";
        String subject = "每日数据报表";

        mailService.sendEmail(recipient, subject, report);
        log.info("报表生成并发送邮件完成: {}", LocalDateTime.now());
    }

    private String generateReport() {
        // 此处可以添加真实的数据报表生成逻辑
        return "这是每日数据报表的内容";
    }
}
