package com.reactive.implementation;

import com.reactive.implementation.publisher.PublisherClass;
import com.reactive.implementation.subcriber.SubscriberClass;

import java.time.Duration;

public class Test {

    public static void main(String[] args) throws InterruptedException {

        test3();
    }

    private static void test1() throws InterruptedException {
        var publisher = new PublisherClass();
        var subscriber = new SubscriberClass();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
    }

    private static void test2() throws InterruptedException {
        var publisher = new PublisherClass();
        var subscriber = new SubscriberClass();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
    }

    private static void test3() throws InterruptedException {
        var publisher = new PublisherClass();
        var subscriber = new SubscriberClass();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(11);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
    }
}