# SeleniumTests
How to run the tests
 
 1) Open git basj and navigate to the directory where you want to place the project;
 2) Execute command
    $ git clone git://github.com/SpringSource/spring-data-graph-examples.git
    
 3) Open the projetc in the IDEA
 4) Navigate to the \SeleniumTests\Akamai\src\test\java\selenium_tests\runners folder
 5) Selet any class file, open it and click on the arrow next to the class name
 
 Also there is an opportunity to run the tests using testng
 1) Open \SeleniumTests\Akamai\src\test\resources\testng.xml file
 2) Uncomment 
 <!--?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Tests" verbose="5">
  <test name="Test1">
    <classes>
      <class name="selenium_tests.testNgTests.JobsSearchTest"/>
    </classes>
  </test>
</suite-->
and comment 

<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Test runner" parallel="classes" thread-count="2">
  <test name="Package with subpackages">
    <packages>
      <package name="selenium_tests.runners.*"/>
    </packages>
  </test>
</suite>

3) Go to the \SeleniumTests\Akamai\src\test\java\selenium_tests\testNgTests\JobsSearchTest.java file
4) Click arror next to any method(to run one test case) or next to the class(to run all test cases)
 
