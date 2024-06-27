package com.aws.learning.sns.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.*;
import java.util.HashMap;

@RestController
@RequestMapping("/sns")

public class SnsController {

    @Autowired
    private SnsClient snsClient;

    // This endpoint creates a new topic
    @PostMapping("/createTopic")
    public String createTopic(@RequestParam String topicName) {

        CreateTopicRequest request = CreateTopicRequest.builder()
                .name(topicName)
                .build();

        CreateTopicResponse result = snsClient.createTopic(request);
        return result.topicArn();
    }

    // This endpoint subscribes an email protocol to a topic
    @PostMapping("/subscribeEmail")
    public String subscribeEmail(@RequestParam String email,@RequestParam String topicArn) {

        SubscribeRequest request = SubscribeRequest.builder()
                .protocol("email")
                .endpoint(email)
                .topicArn(topicArn)
                .build();

        SubscribeResponse result = snsClient.subscribe(request);
        return result.subscriptionArn();
    }

    // This endpoint subscribes an SMS protocol to a topic
    @PostMapping("/subscribeSMS")
    public String subscribeSMS(@RequestParam String number ,@RequestParam String topicArn) {

        SubscribeRequest request = SubscribeRequest.builder()
                .protocol("sms")
                .endpoint(number)
                .topicArn(topicArn)
                .build();

        SubscribeResponse result = snsClient.subscribe(request);
        return result.subscriptionArn();
    }

    // This endpoint publishes a message to a topic
    @GetMapping("/publish")
    public String publishMessage(@RequestParam String message,@RequestParam String topicArn) {
        PublishRequest request = PublishRequest.builder()
                .message(message)
                .topicArn(topicArn)
                .build();

        PublishResponse result = snsClient.publish(request);
        return result.messageId();
    }

    // This endpoint creates a subscription with a filter policy
    @PostMapping("/subscribeFilter")
    public String createSubscription(@RequestParam String email, @RequestBody String filterPolicyJson) {
        SubscribeRequest request = SubscribeRequest.builder()
                .protocol("email")
                .endpoint(email)
                .topicArn("arn:aws:sns:ap-south-1:211125343611:firstsnstopic")
                .attributes(new HashMap<String, String>() {{
                    put("FilterPolicy", filterPolicyJson);
                }}).build();
        snsClient.subscribe(request);

        return "Subscription request sent. Please check your email to confirm.";
    }

    // This endpoint publishes a message to a topic with a filter policy
    @GetMapping("/publishWithFilter")
    public String publishFilterMessage(@RequestParam String message,@RequestParam String topicArn) {
        PublishRequest request = PublishRequest.builder()
                .message(message)
                .topicArn(topicArn)
                .messageAttributes(new HashMap<String, MessageAttributeValue>() {{
                    put("eventType", MessageAttributeValue.builder().dataType("String").stringValue("ss").build());
                }})
                .build();
        PublishResponse result = snsClient.publish(request);
        return result.messageId();
    }

    // This endpoint subscribes an HTTP protocol to a topic
    @PostMapping("/subscribeHttp")
    public String subscribeHttp( @RequestParam String endpointUrl) {
        SubscribeRequest request = SubscribeRequest.builder()
                .protocol("https")
                .endpoint(endpointUrl)
                .topicArn("Your ARN here")
                .build();

        SubscribeResponse result = snsClient.subscribe(request);
        return result.subscriptionArn();
    }

    // This endpoint receives a notification from SNS
    @PostMapping("/receive")
    public void receiveNotification(@RequestBody String message) {
        System.out.println("Received SNS message: " + message);
    }

}
