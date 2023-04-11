package com.foodapp.foodapp.aws;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.model.HttpApiV2ProxyRequest;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.foodapp.foodapp.FoodappApplication;

// todo: future work
public class HttpV2LambdaHandler implements RequestHandler<HttpApiV2ProxyRequest, AwsProxyResponse> {
    private static final SpringBootLambdaContainerHandler<HttpApiV2ProxyRequest, AwsProxyResponse> handler;

    static {
        try {
            handler = SpringBootLambdaContainerHandler.getHttpApiV2ProxyHandler(FoodappApplication.class);
        } catch (ContainerInitializationException ex) {
            throw new RuntimeException("Unable to load spring boot application", ex);
        }
    }

    @Override
    public AwsProxyResponse handleRequest(HttpApiV2ProxyRequest input, Context context) {
        return handler.proxy(input, context);
    }
}
