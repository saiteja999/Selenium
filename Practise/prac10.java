import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class XPathSelectorsPractice {
    public static void main(String[] args) {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Load the sample HTML file
            driver.get("file:///path/to/practice_selectors.html");

            // Locate elements using XPath selectors

            // 1. Locate input tag having value='blue'
            WebElement inputBlue = driver.findElement(By.cssSelector("input[value='blue']"));
            System.out.println("Input with value 'blue': " + inputBlue.getAttribute("id"));

            // XPath equivalent
            WebElement inputBlueXPath = driver.findElement(By.xpath("//input[@value='blue']"));
            System.out.println("Input with value 'blue' (XPath): " + inputBlueXPath.getAttribute("id"));

            // 2. Locate all elements with 'value' attribute
            List<WebElement> elementsWithValue = driver.findElements(By.cssSelector("[value]"));
            System.out.println("Number of elements with 'value' attribute: " + elementsWithValue.size());

            // XPath equivalent
            List<WebElement> elementsWithValueXPath = driver.findElements(By.xpath("//*[@value]"));
            System.out.println("Number of elements with 'value' attribute (XPath): " + elementsWithValueXPath.size());

            // 3. Locate all elements with 'id' attribute
            List<WebElement> elementsWithId = driver.findElements(By.cssSelector("[id]"));
            System.out.println("Number of elements with 'id' attribute: " + elementsWithId.size());

            // XPath equivalent
            List<WebElement> elementsWithIdXPath = driver.findElements(By.xpath("//*[@id]"));
            System.out.println("Number of elements with 'id' attribute (XPath): " + elementsWithIdXPath.size());

            // 4. Locate the first child inside the body tag
            WebElement firstChild = driver.findElement(By.cssSelector("body > *:first-child"));
            System.out.println("First child of body: " + firstChild.getTagName());

            // XPath equivalent
            WebElement firstChildXPath = driver.findElement(By.xpath("/html/body/*[1]"));
            System.out.println("First child of body (XPath): " + firstChildXPath.getTagName());

            // 5. Locate the last child inside the body tag
            WebElement lastChild = driver.findElement(By.cssSelector("body > *:last-child"));
            System.out.println("Last child of body: " + lastChild.getTagName());

            // XPath equivalent
            WebElement lastChildXPath = driver.findElement(By.xpath("/html/body/*[last()]"));
            System.out.println("Last child of body (XPath): " + lastChildXPath.getTagName());

            // 6. Locate the second child inside the body tag
            WebElement secondChild = driver.findElement(By.cssSelector("body > *:nth-child(2)"));
            System.out.println("Second child of body: " + secondChild.getTagName());

            // XPath equivalent
            WebElement secondChildXPath = driver.findElement(By.xpath("/html/body/*[2]"));
            System.out.println("Second child of body (XPath): " + secondChildXPath.getTagName());

            // 7. Locate paragraphs using p:nth-child(2)
            WebElement secondParagraph = driver.findElement(By.cssSelector("p:nth-child(2)"));
            System.out.println("Second child paragraph text: " + secondParagraph.getText());

            // XPath equivalent
            WebElement secondParagraphXPath = driver.findElement(By.xpath("//p[2]"));
            System.out.println("Second child paragraph text (XPath): " + secondParagraphXPath.getText());

            // 8. Locate paragraph using p[id='para2']:nth-child(2)
            WebElement specificParagraph = driver.findElement(By.cssSelector("p[id='para2']:nth-child(2)"));
            System.out.println("Paragraph with id 'para2' and second child: " + specificParagraph.getText());

            // XPath equivalent
            WebElement specificParagraphXPath = driver.findElement(By.xpath("//p[@id='para2' and position()=2]"));
            System.out.println("Paragraph with id 'para2' and second child (XPath): " + specificParagraphXPath.getText());

            // 9. Locate elements with class starting with 'ma'
            List<WebElement> elementsStartingWithMa = driver.findElements(By.cssSelector("p[class^='ma']"));
            System.out.println("Paragraphs with class starting with 'ma': " + elementsStartingWithMa.size());

            // XPath equivalent
            List<WebElement> elementsStartingWithMaXPath = driver.findElements(By.xpath("//p[starts-with(@class, 'ma')]"));
            System.out.println("Paragraphs with class starting with 'ma' (XPath): " + elementsStartingWithMaXPath.size());

            // 10. Highlight all elements with '*'
            List<WebElement> allElements = driver.findElements(By.cssSelector("*"));
            System.out.println("Total elements on the page: " + allElements.size());

            // XPath equivalent
            List<WebElement> allElementsXPath = driver.findElements(By.xpath("//*"));
            System.out.println("Total elements on the page (XPath): " + allElementsXPath.size());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
