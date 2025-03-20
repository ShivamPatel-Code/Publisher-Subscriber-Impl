package com.reactive.Mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class SupplierAndCallable {
    private static final Logger log = LoggerFactory.getLogger(SupplierAndCallable.class);


    // with .fromSupplier() delays the response
    // if we use .just() it would not wait to check if there is a subscription and log.info
    public static void main(String[] args) {
        var list = List.of(1, 2, 3);
        Mono.fromSupplier(() -> sum(list))
                .subscribe(x -> log.info(String.valueOf(x)));

        // Additionally supports 'throws Exception' without try/catch
        Mono.fromCallable(() -> sum(list))
                .subscribe(x -> log.info(String.valueOf(x)));

    }

    private static int sum(List<Integer> list){
        log.info("finding the sum of {}", list);
        return list.stream().mapToInt(a -> a).sum();
    }

}
