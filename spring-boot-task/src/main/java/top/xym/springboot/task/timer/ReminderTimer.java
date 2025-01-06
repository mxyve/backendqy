package top.xym.springboot.task.timer;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;

@Slf4j
public class ReminderTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                log.info("请休息一下，喝点水吧！");
            }
        };
        // 每隔1小时提醒用户
        timer.schedule(task, 0, 3600 * 1000);
    }
}
