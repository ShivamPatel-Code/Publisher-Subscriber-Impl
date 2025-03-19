package com.reactive.publisher;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class PublisherClass implements Publisher<String> {
    @Override
    public void subscribe(Subscriber<? super String> subscriber) {
        var subscription = new SubcriptionClass(subscriber);
        subscriber.onSubscribe(subscription);
    }
}
