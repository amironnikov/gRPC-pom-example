package ru.amironnikov;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import ru.amironnikov.grpc.GreetingServiceImpl;

import java.io.IOException;

public class App
{
    public static void main( String[] args ) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9000).addService(new GreetingServiceImpl())
                        .build();
        server.start();
        System.out.println( "Simple Server started" );
        server.awaitTermination();
    }
}
