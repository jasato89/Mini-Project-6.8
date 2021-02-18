

# Business Justification

![Bank-api-microservices](https://github.com/jasato89/Mini-Project-6.8/blob/main/Bank-api-microservices.png)

## Introduction

Due to the different needs of this project, we have decided that is wise to go one step further in order to improve our banking system API. Here are some reasons why we have decided to break the project down into six different microservices that will work independently.

## The six services

Three of the six services are being included for obvious reasons. We need a Eureka Service to discover all the other services. But have also considered useful to add an Edge Service that will act as a security layer and a gateway for all requests, as well as a Config Service that will allow us to have all the applications properties centralized in one place.

The other three services are **Account Service**, **Transaction Service and Third Party Service**.

### Account Service

We have decided to modularize the account service due to the amount of requests to create new accounts and access to account details, we think it is useful to have an extra layer of data separating the accounts and the transactions. We have also thought that in the future, we might want to add extra features to the accounts and that therefore it is wise to have it in a independent service that can interact with other services such as stocks, finance, mortgages or insurance.

### Third Party Service

We believe that this service should be on its own in order to have maximum flexibility with 3rd party applications. We are thinking that this service is going to be the gateway to POS, virtual POS and payment services such as Bizum or Paypal. Therefore, it is wise to keep it separated and in the near future it would be ideal to add an extra layer of security.

### Transactions

Transactions are a key operation and needs to be the core of our application. From fraud detection to records, it needs to be separated, secured and independent.



