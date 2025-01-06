package top.xym.springboot.task.task;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.xym.springboot.task.entity.StockPrice;
import top.xym.springboot.task.mapper.StockPriceMapper;

import java.time.LocalDateTime;
import java.util.Random;

@Component
@AllArgsConstructor
@Slf4j
public class StockPriceTask {

    private final StockPriceMapper stockPriceMapper;

    private final Random random = new Random();

    @Scheduled(fixedRate = 10000)
    public void updateStockPrice() {
        double price = 100 + random.nextDouble() * 50;

        StockPrice stockPrice = new StockPrice();
        stockPrice.setName("小米");
        stockPrice.setPrice(price);
        stockPrice.setUpdateTime(LocalDateTime.now());

        stockPriceMapper.insert(stockPrice);
        log.info("股票价格已更新：{}，时间：{}", price, LocalDateTime.now());
    }
}
