package selenium.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends Page {

	public static final String URL = "http://3.10.143.120/KayakProject/index.html";
		
		//this will be useful for testing own front-end of project, it may be slower and more bulky to create a class for each page, but it is more readable.
		//on this note, a class MUST be created for each page being used.
		
		
		
		@FindBy(id = "newCustFirstName")
		private WebElement custFirstNameField;
		
		@FindBy(id = "newCustSurname")
		private WebElement custSurnameField;
		
		@FindBy(id = "newEmergFirstName")
		private WebElement emergFirstNameField;
		
		@FindBy(id = "newEmergSurname")
		private WebElement emergSurnameField;
		
		@FindBy(id = "newEmergContactNumber")
		private WebElement emergContactNumberField;
		
		@FindBy(id = "newEmergRelation")
		private WebElement emergRelationField;
		
		@FindBy(id = "add-button")
		private WebElement addCustButton;

		@FindBy(id = "capacity")
		private WebElement capacity;
		
		@FindBy(id = "safety-circle")
		private WebElement safetyCircle;
		
		@FindBy(id = "remove-select")
		private WebElement removeOne;
		
		@FindBy(id = "remove-all")
		private WebElement removeAll;
	
		
		
		public HomePage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
		public void createCustomer(List<String> custInfo) {
			custFirstNameField.sendKeys(custInfo.get(0));
			custSurnameField.sendKeys(custInfo.get(1));
			emergFirstNameField.sendKeys(custInfo.get(2));
			emergSurnameField.sendKeys(custInfo.get(3));
			emergContactNumberField.sendKeys(custInfo.get(4));
			emergRelationField.sendKeys(custInfo.get(5));
			addCustButton.click();
		}
		
		public void deleteOneCustomer() {
			removeOne.click();
		}
		
		public void deleteAllCustomers() {
			removeAll.click();
		}
		
		public String getCapacity() {
			return capacity.getText();
		}

		public void createTenCustomers(List<String> custInfo) throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver,30);

			for	(int i = 0; i < 10; i++) {
				createCustomer(custInfo);
				wait.until(ExpectedConditions.alertIsPresent());
				alertOK();
			}
		}
		
		public void create150Customers(List<String> custInfo) throws InterruptedException {
			for (int i = 0; i < 15; i++) {
				createTenCustomers(custInfo);
			}
		}
		
		public void create100Customers(List<String> custInfo) throws InterruptedException {
			for (int i = 0; i < 10; i++) {
				createTenCustomers(custInfo);
			}
		}
		
		public String getSafetyCircleColour() {
			return safetyCircle.getCssValue("background-color");
		}
		
}
