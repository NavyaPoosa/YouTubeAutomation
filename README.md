## Project Name - Project Author
Youtube Automation - Navya Poosa 

## Project Name and Description:
Youtube Automation - Automate the youtube and check the Films, Music and News tab.

## Installation Instructions:
Set up a local environment -> Install IDE, Java, Gradle, Git, TestNG to run the project.
Set up a TestNG framework -> Modify Build.Gradle file, Introduce testng.xml file

Instructions to Integrate:
1. Add TestNG Dependency to build.gradle
2. Create Folder Structure
   Create a test folder under src. The Test folder should contain the following subfolders one after the other.
   src->test->java->demo
   Inside the demo folder, create a TestCases.java file. In this file we write all our testcases.
3. Configure TestNG with test Task
   Create a folder under test, and parallel to the java folder, named “resources”.
   Within the build.gradle file, configure the test task to use TestNG and specify the location of your testng.xml file. This is how you instruct Gradle to use TestNG    for running tests instead of the default JUnit.
   Ensure the path to testng.xml is correct. You might need to adjust the path based on where your testng.xml file is located in your project structure.
4. Creating the testng.xml File
   Create a testng.xml file in the specified directory, typically under src/test/resources/ in a standard project structure. This XML file is where you define your 
   test suites and specify which test classes or     
   methods  to run
5. Running the Tests
   With the dependency added and the testng.xml file configured, you can now run your TestNG tests through Gradle by executing the following command in your terminal or command prompt:  "./gradlew test"
   This command will run all tests specified in your testng.xml file using TestNG.

## Usage and Examples:

Testcase01- Go to YouTube.com and Assert you are on the correct URL. Click on “About” at the bottom of the sidebar, and print the message on the screen.
             use driver.getCurrentUrl() and peform hard assert.
Testcase02- Go to the “Films” tab and in the “Top Selling” section, scroll to the extreme right. Apply a Soft Assert on whether the movie is marked “A” for Mature or not. Apply a Soft assert on whether the movie is               either “Comedy” or “Animation”.
             use getText() ans apply softassert to verify the data.
Testcase03- Go to the “Music” tab and in the 1st section, scroll to the extreme right. Print the name of the playlist. Soft Assert on whether the number of tracks listed is less than or equal to 50.
             use getText() to print the text of the element.
             to check the number of tracks lesson than or equal to 50 convert the string to Integer using regex and parseInt and check then check the condition in softassert.
Testcase04- Go to “News” tab and print the title and body of the 1st 3 “Latest News Posts” along with the sum of number of likes on all 3 of them. No likes given means 0.
             create a list for title, body, and likes and store the values.
             use for loop to get first 3 posts titles, body and likes.
             convert the string to Integer using regex and parseInt , if string is null convert to 0 as its value. 
             find the sum of likes of first 3 posts.



 
