import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathSelectorPractice {
    public static void main(String[] args) {
        // Set the system property for ChromeDriver (update the path to your chromedriver)
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open the sample HTML file (adjust the file path as needed)
        driver.get("file:///path/to/your/sample.html");

        // -------------------------------------------------
        // 1. Basic Element Selector: Select the first <p> element
        WebElement firstParagraph = driver.findElement(By.cssSelector("p"));
        System.out.println("First paragraph text: " + firstParagraph.getText());

        // XPath equivalent
        WebElement firstParagraphXPath = driver.findElement(By.xpath("//p"));
        System.out.println("First paragraph text (XPath): " + firstParagraphXPath.getText());

        // -------------------------------------------------
        // 2. ID Selector: Select the div with id 'header'
        WebElement headerDiv = driver.findElement(By.cssSelector("div#header"));
        System.out.println("Header Div Text: " + headerDiv.getText());

        // XPath equivalent
        WebElement headerDivXPath = driver.findElement(By.xpath("//div[@id='header']"));
        System.out.println("Header Div Text (XPath): " + headerDivXPath.getText());

        // -------------------------------------------------
        // 3. Class Selector: Select the first element with class 'container'
        WebElement containerDiv = driver.findElement(By.cssSelector("div.container"));
        System.out.println("Container Div Text: " + containerDiv.getText());

        // XPath equivalent
        WebElement containerDivXPath = driver.findElement(By.xpath("//div[contains(@class, 'container')]"));
        System.out.println("Container Div Text (XPath): " + containerDivXPath.getText());

        // -------------------------------------------------
        // 4. Attribute Selector: Select input element with type="text"
        WebElement usernameInput = driver.findElement(By.cssSelector("input[type='text']"));
        System.out.println("Username input placeholder: " + usernameInput.getAttribute("placeholder"));

        // XPath equivalent
        WebElement usernameInputXPath = driver.findElement(By.xpath("//input[@type='text']"));
        System.out.println("Username input placeholder (XPath): " + usernameInputXPath.getAttribute("placeholder"));

        // -------------------------------------------------
        // 5. Descendant Combinator:
        // Select the first <li> element inside any <ul> with class 'list'
        WebElement firstListItem = driver.findElement(By.cssSelector("ul.list li:first-child"));
        System.out.println("First list item text: " + firstListItem.getText());

        // XPath equivalent
        WebElement firstListItemXPath = driver.findElement(By.xpath("//ul[contains(@class, 'list')]/li[1]"));
        System.out.println("First list item text (XPath): " + firstListItemXPath.getText());

        // -------------------------------------------------
        // 6. Child Combinator:
        // Select the <p> element with id 'intro' that is a direct child of div.container
        WebElement introParagraph = driver.findElement(By.cssSelector("div.container > p#intro"));
        System.out.println("Intro paragraph text: " + introParagraph.getText());

        // XPath equivalent
        WebElement introParagraphXPath = driver.findElement(By.xpath("//div[contains(@class, 'container')]/p[@id='intro']"));
        System.out.println("Intro paragraph text (XPath): " + introParagraphXPath.getText());

        // -------------------------------------------------
        // 7. Adjacent Sibling Combinator:
        // Select the button that immediately follows the input[type='password']
        WebElement loginButton = driver.findElement(By.cssSelector("input[type='password'] + button.submit"));
        System.out.println("Login button text: " + loginButton.getText());

        // XPath equivalent
        WebElement loginButtonXPath = driver.findElement(By.xpath("//input[@type='password']/following-sibling::button[@class='submit']"));
        System.out.println("Login button text (XPath): " + loginButtonXPath.getText());

        // -------------------------------------------------
        // 8. General Sibling Combinator:
        // Select any <p> element that is a sibling of the <p> with id 'intro'
        WebElement siblingParagraph = driver.findElement(By.cssSelector("p#intro ~ p"));
        System.out.println("Sibling paragraph text: " + siblingParagraph.getText());

        // XPath equivalent
        WebElement siblingParagraphXPath = driver.findElement(By.xpath("//p[@id='intro']/following-sibling::p"));
        System.out.println("Sibling paragraph text (XPath): " + siblingParagraphXPath.getText());

        // -------------------------------------------------
        // 9. Relative Selection:
        // First locate the container, then search within it for the username input
        WebElement mainContainer = driver.findElement(By.cssSelector("div.container"));
        WebElement relativeUsernameInput = mainContainer.findElement(By.cssSelector("input[name='username']"));
        System.out.println("Relative username input placeholder: " + relativeUsernameInput.getAttribute("placeholder"));

        // XPath equivalent
        WebElement mainContainerXPath = driver.findElement(By.xpath("//div[contains(@class, 'container')]"));
        WebElement relativeUsernameInputXPath = mainContainerXPath.findElement(By.xpath(".//input[@name='username']"));
        System.out.println("Relative username input placeholder (XPath): " + relativeUsernameInputXPath.getAttribute("placeholder"));

        // -------------------------------------------------
        // Optional: Using a pseudo-class to select the first list item (alternative to :first-child)
        WebElement firstListItemPseudo = driver.findElement(By.cssSelector("ul.list li:nth-of-type(1)"));
        System.out.println("First list item using pseudo-class: " + firstListItemPseudo.getText());

        // XPath equivalent
        WebElement firstListItemPseudoXPath = driver.findElement(By.xpath("//ul[contains(@class, 'list')]/li[1]"));
        System.out.println("First list item using pseudo-class (XPath): " + firstListItemPseudoXPath.getText());

        // Close the browser
        driver.quit();
    }
}



/*
When to Use contains
Use contains when:

The class attribute has multiple classes (e.g., class="container main") and you want to match a part of it.
You're looking for partial matches for any other attribute.
 
In 6. Child Combinator:

<div class="container">
    <p id="intro" class="text">This is the introduction paragraph.</p>
    <p class="text">This is another paragraph inside the container.</p>
</div>

By.xpath("//div[contains(@class, 'container')]/p[@id='intro']")  // This works because contains(@class, 'container') checks whether the class attribute contains the string container.
                                                                 // It is more flexible and can match class="container main" or class="main container", where container is only part of the value.

By.xpath("//div[@class='container']/p[@id='intro']")   // This works because the class attribute of the <div> in this case has only one value: container.
                                                       // It matches exactly, so no need to use contains here.

*/