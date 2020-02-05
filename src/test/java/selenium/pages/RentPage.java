package selenium.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RentPage extends Page {

	public static final String URL = "http://localhost/KayakProject/rent.html";
		
		//this will be useful for testing own front-end of project, it may be slower and more bulky to create a class for each page, but it is more readable.
		//on this note, a class MUST be created for each page being used.
		
		@FindBy(id="kayak")
		private WebElement kayakCheckBox;
		
		@FindBy(id="BA")
		private WebElement BACheckBox;
		
		@FindBy(id="helmet")
		private WebElement helmetCheckBox;
		
		@FindBy(id="paddle")
		private WebElement paddleCheckBox;
		
		@FindBy(id = "save-button")
		private WebElement saveButton;
		
		@FindBy(id = "total-price")
		private WebElement totalPrice;

		@FindBy(id="kayak-stock-number")
		private WebElement kayakStock;
		
		@FindBy(id="BA-stock-number")
		private WebElement BAStock;
		
		@FindBy(id="helmet-stock-number")
		private WebElement helmetStock;
		
		@FindBy(id="paddle-stock-number")
		private WebElement paddleStock;
		
		
		
		public RentPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
		public String getTotalPrice() {
			return totalPrice.getText();
		}

		public String getKayakStock() {
			return kayakStock.getText();
		}

		public String getBAStock() {
			return BAStock.getText();
		}

		public String getHelmetStock() {
			return helmetStock.getText();
		}

		public String getPaddleStock() {
			return paddleStock.getText();
		}
		
		public void pickAllEquipment() {
			kayakCheckBox.click();
			BACheckBox.click();
			helmetCheckBox.click();
			paddleCheckBox.click();
		}
		
		public void saveEquipment() {
			saveButton.click();
		}
}
