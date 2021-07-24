import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ListBox
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "X:\\Selenium jar and drivers\\drivers\\ChromeDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/Arshad/IdeaProjects/SelectClass/src/SelectionBox.html");

        WebElement list = driver.findElement(By.id("mtr"));
        Select s = new Select(list);
        List<WebElement> options = s.getOptions();
        int size = options.size();
        System.out.println("Number of elements present inside the listbox is : "+ size);

        //Print all the elements present in the list box
        for (WebElement webElement : options) {
            String text = webElement.getText();
            System.out.println(text);
        }

        s.selectByIndex(0);
        s.selectByValue("d");
        s.selectByVisibleText("POORI");

        System.out.println("************Print all selected options***********");

        List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
        int size2 = allSelectedOptions.size();
        System.out.println("Number of items that is selected in the list box is : "+size2);
        System.out.println(" Selected items are printed below ");
        for (WebElement webElement : allSelectedOptions) {
            System.out.println(webElement.getText());
        }

        System.out.println("check whether it is a multiple select listbox or not");
        boolean multiple = s.isMultiple();
        System.out.println(multiple +" yes , it is multi select");

        if (multiple) {
            //Print the first selected option in the list box
            WebElement firstSelectedOption = s.getFirstSelectedOption();
            System.out.println(firstSelectedOption.getText()+" is the first selected item in the list box");
            //deselect the item present in 0th index.
            s.deselectByIndex(0);

            //Print the first selected option in the list box
            WebElement firstSelectedOption1 = s.getFirstSelectedOption();
            System.out.println(firstSelectedOption1.getText()+" is the first selected item");
            //deselect an item which has an attribute called value and its value is "v"
            s.deselectByValue("d");

            //Print the first selected option in the list box
            WebElement firstSelectedOption2 = s.getFirstSelectedOption();
            System.out.println(firstSelectedOption2.getText()+" is the first selected item");
            s.deselectByVisibleText("POORI");
        }
        driver.quit();
    }
}
