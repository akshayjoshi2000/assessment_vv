# Selenium Web Testing Project

This project leverages Selenium WebDriver and the Page Object Model (POM) design pattern for automating UI testing in a web application. The classes represent specific pages, each encapsulating web elements and actions to streamline the creation and maintenance of test scripts.

---

## Table of Contents
- [Configuration](#configuration)
  - [Dependencies](#dependencies)
  - [Configuring Properties](#configuring-properties)
- [Running the Test Suite](#running-the-test-suite)
- [Page Objects](#page-objects)
  - [AllClipsPage](#allclipspage)
  - [DashboardPage](#dashboardpage)
  - [EditPage](#editpage)
  - [LoginPage](#loginpage)

---

## Configuration

### Dependencies

- Ensure that **Maven** or a similar build tool is configured to manage Selenium WebDriver , TestNgand other dependencies.
  
---

## Running the Test Suite

To run the test suite using TestNG:

1. Locate the `testng.xml` file in the root directory of your project.
2. Right-click on `testng.xml`.
3. Select **Run As > TestNG Suite** from the context menu.
   - This action will execute all tests defined in `testng.xml` in the specified order.
4. This is a Demo, make sure There is no `AutoFlip` already created 
---

## Page Objects

### AllClipsPage
- **Class**: `AllClipsPage.java`
- **Description**: Represents the All Clips page, allowing actions such as selecting a video to edit, selecting the "Auto Flip" option, and deleting clips.
- **Methods**:
  - `selectVideoThumbnailToEdit()`: Selects a video thumbnail to edit.
  - `selectAutoFlipOption()`: Chooses the "Auto Flip" option for a video.
  - `deleteFromAllClips()`: Deletes a selected video from the All Clips section.

### DashboardPage
- **Class**: `DashboardPage.java`
- **Description**: Represents the main Dashboard of the application, with options for navigating to videos and returning to the dashboard.
- **Methods**:
  - `clickOnVideo()`: Clicks the video button and verifies navigation.
  - `goToDashboard()`: Navigates to the dashboard.
  - `verifyVideoPage()`: Asserts that the page title matches the expected title for the video page.

### EditPage
- **Class**: `EditPage.java`
- **Description**: Provides video editing functionality, including trimming, applying filters, flipping, and saving changes.
- **Methods**:
  - `trimVideo()`: Sets start and end times for video trimming, saves changes, and verifies the clip.
  - `flipClip()`: Applies a 9:16 aspect ratio flip to the video and downloads it.
  - `hexCode()`: Generates a random hexadecimal string for unique naming.
  - `fluentWaitForElement(WebElement element)`: Implements a fluent wait strategy for dynamic elements.

### LoginPage
- **Class**: `LoginPage.java`
- **Description**: Automates login functionality by entering email and password to authenticate the user.
- **Methods**:
  - `login()`: Logs in using credentials from a properties file.
  - `verifyDashboardPage()`: Confirms successful login by checking the dashboard page title.

---
