# aws-services-implementation
This is repository for implementing AWS services via Springboot application.


# AWS SNS Service Implementation

    # Description:- Amazon Simple Notification Service (SNS) is a fully managed messaging service that 
              facilitates the delivery of messages from publishers (producers) to subscribers 
              (consumers) using a publish-subscribe model. It is highly scalable, flexible, and 
              cost-effective,making it suitable for a wide range of applications.

    # SNS Features :- Publish-Subscribe Messaging , Topic creation , Subscription creation.

    # API Endpoints :- 

    1. Create Topic :- POST /sns/create-topic
    2. Subscribe Email :- POST /sns/subscribeEmail
    3. Subscribe SMS :- POST /sns/subscribeSMS
    4. Publish Message :- GET /sns/publish
    5. Subscribe With Filter Policy :- POST /sns/subscribeFilter
    6. Publish With Filter Policy :- GET /sns/publishFilter
    7. Subscribe Endpoint :- POST /sns/subscribeHttp

    # Prerequisites :- 
     
    1. AWS Account
    2. AWS Access Key and Secret Key
    3. AWS SNS Service knowlegde

    # Steps to run the application :-
    
    1. Clone the repository.
    2. Open the project in IDE
    3. Add AWS SNS dependency in gradle file.
    4. Add AWS Access Key , Secret Key and region in application.yml file.
    5. Run the project.
  
