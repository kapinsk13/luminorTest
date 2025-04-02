## Dependencies

The project is built using Maven. Key dependencies include:

- **Selenide**: Simplifies browser automation (bundles Selenium WebDriver internally).
- **TestNG**: Provides a testing framework.
- **Allure TestNG**: Generates attractive test reports.

See the `pom.xml` for full dependency details.

## Prerequisites

- **Java 21**: Ensure Java 21 is installed.
- **Maven**: Make sure Maven is installed and configured.
- **Chrome Browser**: The tests are configured to run in Chrome. Ensure the Chrome browser and matching ChromeDriver are
  installed.

## Setup

1. **Clone the repository:**
   ```bash
   git clone git@github.com:kapinsk13/luminorTest.git
   
   cd luminorTest

2. **Install Dependencies:**
    ```bash
    mvn clean install

3. **Running Tests:**
    ```bash
   mvn clean test