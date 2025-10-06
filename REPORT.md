# Lab 2 Web Server -- Project Report

## Description of Changes
The following have been added:
- An error page with better user experience than the default Whitelabel, taking advantage of Spring's automatic error mapping to error.html in the templates directory.
- A controller that uses an injected service that provides local time, through an interface and a DTO.
- Support for SSL and HTTP2 with a self-signed certificate.

## Technical Decisions
No major technical decisions have been made because the script containing all the necessary information was followed. Only two decisions were made:
- Keep all TimeComponent development within the same file _TimeComponent.kt_, since it's a simple component that we know won't be more complicated than it already is, it's not worth separating into multiple files.
- Develop the requested tests as integration tests. Since only one test was requested for each feature, it seemed most appropriate to make them integration tests (in the first case because it's necessary for it to return HTML) and in the second case because it was simple to test the endpoint and controller functionality.

## Learning Outcomes
In this lab I have learned how to create a generic error template and how to make Spring Boot return it automatically when a URL mapping is not found, and how to enable SSL and HTTP/2. Since in the previous lab I already implemented the functionality to greet the user according to time, that section only served to consolidate my knowledge.
I have also seen how to create tests that accept self-signed certificates and can use https.

## AI Disclosure
### AI Tools Used
For the development of this lab, the following was used:
- ChatGPT 5

### AI-Assisted Work
I asked ChatGPT to help me create the error.html page, and it did work that aligns with my HTML and CSS knowledge, which means it did the same thing I could have done, just faster.
It also helped me generate the TestConfig.kt file so that the tests would work using https with a self-signed certificate, generating a REST template for tests.
The percentage is around 80% original work versus 20% AI-assisted work.

### Original Work
All the rest of the lab has been done by me (although copying the instructions from the script).
These were simple tasks that didn't require much effort or understanding process beyond reading the script and understanding what it explains.