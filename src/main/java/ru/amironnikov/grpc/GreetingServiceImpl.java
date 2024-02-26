package ru.amironnikov.grpc;

import io.grpc.stub.StreamObserver;

/**
 * @author a.mironnikov
 */
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(GreetingServiceOuterClass.HelloRequest request,
                         StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {
        for (int i = 0; i < 50000; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse.
                    newBuilder()
                    .setGreeting("Test message from gRPC server for: " + request.getName())
                    .build();
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }
}
