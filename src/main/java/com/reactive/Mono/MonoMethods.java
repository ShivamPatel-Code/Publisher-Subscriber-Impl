package com.reactive.Mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.util.List;


public class MonoMethods {

    private static final Logger log = LoggerFactory.getLogger(MonoMethods.class);

    public static void main(String[] args) {

        Mono.just("Shivam").log().subscribe(
                data -> log.info("The Mono data {}", data),
            err -> log.error("error", err)
        );

        Flux.just("Shivam", "Patel").log().subscribe(
                data -> log.info("The Flux data {}", data),
            err -> log.error("error", err)
        );


        var mono = Mono.just(List.of("Shivam", "Patel"));

        mono.subscribe(
                i -> log.info("received the data: {}", i),
                err -> log.error("error", err),
                () -> log.info("completed"),
                subscription -> subscription.request(1)
        );

    }

}
