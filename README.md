
# Project Vanilla - Selenium

This project contains source code to run automated UI tests against amazon.in.

This can be enhanced in future for adding additional test cases.





## Test case performing steps
[1] Open https://www.amazon.in/ \
[2] Click on the hamburger menu in the top left corner.\
[3] Scroll own and then Click on the TV, Appliances and Electronics link under Shop by Department section.\
[4] Then click on Televisions under Tv, Audio & Cameras sub section.\
[5] Scroll down and filter the results by Brand ‘Samsung’.\
[6] Sort the Samsung results with price High to Low.\
[7] Click on the second highest priced item (whatever that maybe at the time of automating).\
[8] Switch the Window\
[9] Assert that “About this item” section is present and log this section text to console/report.


## Dependencies

For this project to run, you would need to install below 3 dependencies on your machine:

- Java 11 (as the core programming language)
- Maven 3.8.5 (for dependency management)
- Google Chrome latest version (browser to run your tests)

`If your JAVA_HOME is set to anything other than JDK 11, you would need to update the path. Else your project will not run. Also, do remember to set the correct JDK settings in your IDE.`
## Run Locally

Clone the project

```bash
  git clone https://github.com/isitsid/vanilla.git
```

Go to the project directory in IntelliJ

```bash
 Open the project in IntelliJ
```


```bash

 Then Do run on test in : test -> java -> TestSandbox class

```
 Voila - Test Passes !


 
 *Happy coding!*



