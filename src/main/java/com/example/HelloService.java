package com.example;

import examples.GoodbyeReply;
import examples.GoodbyeRequest;
import examples.GreeterGrpc;
import examples.HelloReply;
import examples.HelloRequest;
import io.grpc.stub.StreamObserver;

import javax.inject.Singleton;

@Singleton
public class HelloService extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        responseObserver.onNext(HelloReply.newBuilder().setMessage("hello, " + request.getName()).setInfo("some info").setDetailedInfo("fofofof").build());
        responseObserver.onCompleted();
    }

    @Override
    public void sayGoodbye(GoodbyeRequest request, StreamObserver<GoodbyeReply> responseObserver) {
        responseObserver.onNext(GoodbyeReply.newBuilder().setMessage("goodbye, " + request.getName()).build());
        responseObserver.onCompleted();
    }
}
