package com.pg.gatewayservice.config;

import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

@Component
public class CountFilter extends AbstractGatewayFilterFactory<CountFilter.Config> {

    public CountFilter() {
        super(Config.class);
    }

    public Logger log= Logger.getLogger(String.valueOf(Config.class));

    private static AtomicInteger COUNT_CALL_GATEWAY = new AtomicInteger(0);
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange,chain)->{
            log.info("La request vienee desde: "+exchange.getRequest().getPath());

            log.info("Count: "+COUNT_CALL_GATEWAY.addAndGet(1));
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                log.info("Response time: "+ Calendar.getInstance().getTime());
            }));
        };
    }

    public static class Config{}
}
