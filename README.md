# aws-sdk-demo
A basic project to demonstrate the usage of AWS SDK (in Java)

This maven-based project shows the usage of 2 AWS SDK APIs for DynamoDB:
1. List tables
2. Describe table

How to run this project:
1. Setup AWS credentials in your terminal (there are other ways too, see [this link](https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html) for details)
2. Run the `main` function in `Main.java`
3. This should give an output of the available DynamoDB tables in the AWS account that has been configured. It then seeks to print the details of a table named `student`. This table needs to be made in your AWS account in order to be able to print its details


Scope for refactoring:
- Adding unit tests
