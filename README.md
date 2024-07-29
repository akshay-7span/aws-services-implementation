# aws-services-implementation
This is repository for implementing AWS services via Spring Boot application.

# AWS SQS Service Implementation

    # Description:- Amazon Simple Queue Service (Amazon SQS) offers a secure, durable, and available hosted queue 
                    that lets you integrate and decouple distributed software systems and components. 
                    Amazon SQS offers common constructs such as dead-letter queues and cost allocation tags.

# Amazon SQS offers two queue types for different application requirements:
    # Standard Queues
           - Unlimited Throughput: Standard queues support a nearly unlimited number of transactions per second (TPS) per API action.
           - At-Least-Once Delivery: A message is delivered at least once, but occasionally more than one copy of a message is delivered.
           - Best-Effort Ordering: Occasionally, messages might be delivered in an order different from which they were sent.
    
    # FIFO Queues
           - Exactly-Once Processing: A message is delivered once and remains available until a consumer processes and deletes it. Duplicates aren't introduced into the queue.
           - First-In-First-Out Delivery: The order in which messages are sent and received is strictly preserved (i.e. First-In-First-Out).


# SQS Features 
    # Publish-Subscribe Messaging 
    # Queue configuration 
    # Visibility timeout of messages
    # Poll messages


# API Endpoints :- 

    1. Create Queue :- POST /sqs/create-queue
    2. GetListOfQueue :- GET /sqs/list-queues
    3. Delete Queue by queue name :- DELETE /sqs?name={queue-name}
    4. GetQueueURL by queue name :- GET /sqs/queue-url
    5. SendMessage :- POST /sqs/send-message
    6. Recicve message :- POST /sqs/receive-message

# Prerequisites :- 
     
    1. AWS Account
    2. AWS Access Key and Secret Key
    3. AWS SQS Service knowlegde
    4. Provide region, Queue name

# Steps to run the application :-
    
    1. Clone the repository.
    2. Open the project in IDE
    3. Add AWS SQS dependency in gradle file.
    4. Add AWS Access Key , Secret Key and region in application.yml file.
    5. Run the project.
  
