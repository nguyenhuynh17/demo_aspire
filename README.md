# demo_aspire

# Prerequisite #
**Install maven: https://maven.apache.org/install.html**

## Steps to run the project ##

1. Create ".CREDENTIALS.json" at folder path "src/main/resources/"
2. Run the project by commnand line
3. Update testng.xml file if user wants to run testing on multi browsers



**File ".CREDENTIALS.json" format:**
```
{
    "email": "<valid_email>",
    "password": "<valid_password"
}
```

**Run the project by commnand line:**
1. Change directory to project folder: cd <your_folder_project>
2. Run command: `mvn clean test`

**Update testng.xml file if user wants to run testing on multi browsers:**
1. Open testng.xml file
2. Uncomment `<test></test>`: for example(*<test name="TestOnFirefox">*)
3. Run testng.xml file
