package com.aws.learning.controller;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.DeleteQueueResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.aws.learning.model.Queue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sqs")
public class SQSController {

    private final AmazonSQS amazonSQSClient;

    public SQSController(AmazonSQS amazonSQSClient){
        this.amazonSQSClient = amazonSQSClient;
    }

    /**
     * This endpoint used to create queue for provided region
     *  Default Queue - Standard
     * @return CreateQueueResult
     */
    @PostMapping("/create-queue")
    public CreateQueueResult createQueue(@RequestBody Map<String,String> queues){
        return amazonSQSClient.createQueue(queues.get("name"));
    }


    /**
     * This endpoint used to show list of queues for provided region
     * @return List<Queue>
     */
    @GetMapping("/list-queues")
    public List<Queue> getListOfQueue(){
        List<Queue> listOfQueues = new ArrayList();
        for (String url : amazonSQSClient.listQueues().getQueueUrls()) {
            listOfQueues.add(new Queue(url));
        }
        return listOfQueues;
    }

    /**
     * This endpoint used to get queue by name according to provided region
     * @return queue URL
     */
    @GetMapping("/queue-url")
    public String getQueueUrl(@RequestParam("name") String queueName){
        return amazonSQSClient.getQueueUrl(queueName).getQueueUrl();
    }

    /**
     * This endpoint used to queue by name
     * @return DeleteQueueResult
     */
    @DeleteMapping()
    public DeleteQueueResult deleteQueue(@RequestParam("name") String queueName){
        return amazonSQSClient.deleteQueue(queueName);
    }

    /**
     * This endpoint used to send message according to queue
     *  Default Queue - Standard
     * @return CreateQueueResult
     */
    @PostMapping("/send-message")
    public SendMessageResult sendMessages(@RequestBody Map<String,String> queue){
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queue.get("queueUrl"))
                .withMessageBody(queue.get("msg"))
                .withDelaySeconds(5);
        return amazonSQSClient.sendMessage(send_msg_request);
    }

    /**
     * This endpoint used to receive message according to queue url
     *  Default Queue - Standard
     */
    @PostMapping("/receive-message")
    public void receiveMessages(@RequestBody Map<String,String> queue){
        List<Message> messages = amazonSQSClient.receiveMessage(queue.get("queueUrl")).getMessages();

        for (Message m : messages) {
            System.out.println("messages :::::::::"+m.getBody());
            amazonSQSClient.deleteMessage(queue.get("queueUrl"), m.getReceiptHandle());
        }

    }
}
