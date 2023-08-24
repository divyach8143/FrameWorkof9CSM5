package genericlibraries;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.AddAddresFormPge;
import pomPages.CartPage;
import pomPages.HeadPhonesPage;
import pomPages.HomePage;
import pomPages.MyAddressesPage;
import pomPages.MyProfilePage;
import pomPages.ShopperStackLoginPage;
import pomPages.SignUpPage;
import pomPages.WelcomePage;

public class BaseClass {
	

		protected PropertiesUtilities property;
		protected Excelutility excel;
		protected JavaUtility jutil;
		protected WebDriverUtility webUtil;
		public WebDriver driver;
		public static WebDriver sdriver;
		
		protected WelcomePage welcome;
		protected ShopperStackLoginPage login;
		protected HomePage home;
		protected SignUpPage signUp;
		protected MyProfilePage myProfile;
		protected MyAddressesPage myAddress;
		protected HeadPhonesPage headPhone;
		protected CartPage cart;
		protected AddAddresFormPge address;
		
		//@BeforeSuite
		//@BeforeTest
		
		@BeforeClass
		public void classConfiguration() {
			property = new PropertiesUtilities();
			excel = new Excelutility();
			jutil = new JavaUtility();
			webUtil = new WebDriverUtility();
			
			property.propertiesInit(Iconstatntpath.PROPERTIES_PATH);
			excel.excelInit(Iconstatntpath.EXCEL_PATH);
		}
		
		@BeforeMethod
		public void methodConfiguration() {
			driver = webUtil.navigateToApp(property.getData("browser"), 
					property.getData("url"), 
					Long.parseLong(property.getData("time")));
			sdriver = driver;
			
			welcome = new WelcomePage(driver);
			login = new ShopperStackLoginPage(driver);
			home = new HomePage(driver);
			signUp = new SignUpPage(driver);
			myProfile = new MyProfilePage(driver);
			myAddress = new MyAddressesPage(driver);
			headPhone = new HeadPhonesPage(driver);
			cart = new CartPage(driver);
			address = new AddAddresFormPge(driver);		
		}
		
		@AfterMethod
		public void methodTeardown() {
			home.clickProfileButton();
			home.clickLogout();
			webUtil.closeAllBrowsers();
		}
		
		@AfterClass
		public void classTeardown() {
			excel.closeExcel();
		}
		
		//@AfterTest
		//@AfterSuite
	}

