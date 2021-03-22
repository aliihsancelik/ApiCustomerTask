API Automation Task

#### Codes and Test Prepared by:
**Ali Ihsan Celik*

*Software QA Engineer*

aliihsancelik1@gmail.com

www.linkedin.com/in/aliihsancelik
``

**- Build Tool:** Maven

**- Test Framework:** Cucumber BBD (with JUnit Assertions)

------------
##### Environment: 
`https://ipw5pjxxsh.execute-api.eu-west-1.amazonaws.com/api/hotel/customer`

------------
#### System Requirements: 
- Java 8 + JDK

------------
## Test RUN 

Note: To run the scenarios, use `@flowTest` tag for creating, getting and deleting a customer features flow test and 
use `@positiveCreateCustomer` tag for creating a customer feature positive test and 
use `@negativeCreateCustomer` tag for creating a customer feature negative test in the CukesRunner class/Cucumber Options.

#### 1. Way:
 - Clone the projects
 - Import maven dependencies from POM
 - Go **src -> test > java > Runners > CukesRunner** and Run
 - To generate "HTML Maven Cucumber Report" ; 
    > Open Maven right side panel
    > Double Click Project's Lifecycle
    > Click "verify"
                                                  
#### 2. Way:
 - Run from command line invoke `mvn clean verify` 

------------

## Test Reports Locations
1- Cucumber HTML Plugin Reports
**target -> cucumber-html-reports > overview-steps.html** 
(Right Click and Open in any Browser )

2- When you run my project, Cucumber will create automatically online report link. You can click the link
with in the 24 hours and check the all test steps and status. 

------------
 
## Cucumber Test Feature Scenarios:

<<<<<<< @flowTest in CustomerFlow.feature file
####) Validate creating, getting and deleting a customer with a flow test

 a- In this Scenario, it tests the flow of creating, getting and deleting a customer
 
 b- To run this scenario, use the `@flowTest` tag in the CukesRunner class/Cucumber Options
 
 
<<<<<<< @positiveCreate in PositiveCrateCustomer.feature file
####) Validate creating a customer feauture with the valid datas

 a- In this Scenario, it tests the creating a customer feature with the all valid information
 
 b- To run this scenario, use the `@positiveCreate` tag in the CukesRunner class/Cucumber Options
 
 
 <<<<<<< @negativeCreate in NegativeCrateCustomer.feature file
 ####) Validate creating a customer feauture with the missing mandatory datas
 
  a- In this Scenario, it tests the creating a customer feature with the missing mandatory datas
  
  b- To run this scenario, use the `@negativeCreate` tag in the CukesRunner class/Cucumber Options
 
------------

2021 March;
https://github.com/aliihsancelik

### End

------------
