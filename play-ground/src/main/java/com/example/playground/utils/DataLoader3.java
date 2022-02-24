package com.example.playground.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Component
@Slf4j
public class DataLoader3 implements ApplicationRunner {
    @Override
    public void run(final ApplicationArguments args) throws Exception {
        for (int i = 0; i < args.getSourceArgs().length; ++i) {
            log.info("input" + i + ": " + args.getSourceArgs()[i]);
        }
    }
}
