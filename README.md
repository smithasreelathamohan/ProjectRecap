Reporting:
Note:
Surefire to get the reports first
- name: Upload Test Reports
          uses: actions/upload-artifact@v4
          if: always()
          with:
            name: test-reports
            path: target/surefire-reports/

added in yml file for github actions

Note:
to get Allure report first do the above because it is based on that
🧩 1. Add Allure Dependencies (Maven)

In your pom.xml, add:

🔹 Allure JUnit5 (most common for Spring Boot tests)
<dependency>
    <groupId>io.qameta.allure</groupId>
    <artifactId>allure-junit5</artifactId>
    <version>2.27.0</version>
    <scope>test</scope>
</dependency>
🔹 Optional (for better annotations)
<dependency>
    <groupId>io.qameta.allure</groupId>
    <artifactId>allure-java-commons</artifactId>
    <version>2.27.0</version>
</dependency>
🧪 2. Configure Surefire Plugin (IMPORTANT)

Allure needs test results in allure-results.

<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.2.5</version>
    <configuration>
        <systemPropertyVariables>
            <allure.results.directory>${project.build.directory}/allure-results</allure.results.directory>
        </systemPropertyVariables>
    </configuration>
</plugin>
✍️ 3. Add Allure Annotations in Tests

Example JUnit test:

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Calculator Module")
@Feature("Addition Feature")
class CalculatorTest {

    @Test
    @Story("Add two numbers")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify addition of two integers")
    void testAddition() {
        int result = 2 + 3;
        assertEquals(5, result);
    }
}

▶️ 4. Run Tests in VS Code

Run:

mvn clean test

This generates:

target/allure-results/


📊 5. Install Allure CLI (Local Machine)
macOS
brew install allure
Windows (Chocolatey)
<<<<>>>>
to correctly install allure
Correct ways to install Allure on Windows
⭐ Option 1 (Recommended): Install via Scoop (best for Windows devs)
Step 1: Install Scoop (if not installed)

Open PowerShell (normal, not admin is fine):

Set-ExecutionPolicy RemoteSigned -Scope CurrentUser
irm get.scoop.sh | iex
Step 2: Install Allure
scoop bucket add extras
scoop install allure
Step 3: Verify
allure --version


⭐ Option 2: Manual Installation (100% reliable)
Step 1: Download Allure CLI

Go here:
👉 https://github.com/allure-framework/allure2/releases

Download:

allure-2.xx.x.zip
Step 2: Extract

Example:

C:\allure

You should have:

C:\allure\bin\allure.bat
Step 3: Add to PATH

Add:

C:\allure\bin

to Windows Environment Variables → PATH
<<<>>>>>>>
choco install allure
Verify:
allure --version

👀 6. Generate & Open Report (VS Code terminal)
allure serve target/allure-results

OR

allure generate target/allure-results -o target/allure-report --clean
allure open target/allure-report

to run locally
>mvn clean test 
> allure serve target/allure-results


CICD how to see the results now. 
its in artifacts but cannot be opened in local browser page another setup is needed

- name: Deploy Allure Report to GitHub Pages
  uses: peaceiris/actions-gh-pages@v4
  with:
    github_token: ${{ secrets.GITHUB_TOKEN }}
    publish_dir: allure-report
Then enable:
Repo → Settings → Pages → Deploy from branch (gh-pages)
You get:
https://your-user.github.io/your-repo/


STEP 1: Fix GitHub Pages settings

Go to your screen and set:

Set this:
Source: Deploy from a branch
Branch: gh-pages
Folder: / (root)

Note: 
after cicd run in github actions
check result in https://smithasreelathamohan.github.io/ProjectRecap/ 


