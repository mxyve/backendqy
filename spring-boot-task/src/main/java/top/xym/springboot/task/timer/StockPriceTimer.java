package top.xym.springboot.task.timer;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@Slf4j
public class StockPriceTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
           final Random random = new Random();
           double stockPrice = 100.0;

           @Override
            public void run() {
               // 随即上下波动
               stockPrice += (random.nextDouble() - 0.5) * 2;
               log.info("当前股票价格：{}", stockPrice);
           }
        };
        // 每隔1秒更新一次
        timer.schedule(task, 0, 1000);
    }
}
