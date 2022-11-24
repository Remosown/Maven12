package org.samples;


	import java.awt.AWTException;
	import java.awt.Frame;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.Wait;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {
		
		public static WebDriver driver;
		public static Robot r;
		public static Actions a;
		public static TakesScreenshot ts;
		public static Alert al;
		public static JavascriptExecutor js;
		public static Frame f;
		
		
		public static void LaunchBrowser() {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		}
		public static void LaunchUrl(String Url) {
			driver.get(Url);

		}
		public static void passvalue(WebElement ele,String Value) {
			ele.sendKeys(Value);
		}
		public static void press(WebElement ele) {
			ele.click();
			
		}public static void tab() throws AWTException {
			
			r = new Robot();
			
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);

		}
		public static void movecursor(WebElement ele) {
			
			a = new Actions(driver);
			a.moveToElement(ele).perform();
			
		}
		public static void rightclick(WebElement ele) {
			
			a = new Actions(driver);
			a.contextClick(ele).perform();
		}
		public static void snap(String name) throws IOException  {
			
			TakesScreenshot ts =  (TakesScreenshot)driver;
			File temp = ts.getScreenshotAs(OutputType.FILE);
			File target = new File("C:\\Users\\HP\\eclipse-workspace\\Maven11am\\Image\\"+name+".png");
			FileUtils.copyFile(temp, target);
			
		}
		public static void alert(WebElement ele) {
			
			al = driver.switchTo().alert();
			al.accept();
		}
		public static void jsclick(WebElement ele) {
			
			JavascriptExecutor js =  (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click", ele);
			
			
		}
		public static void jsGetAttribute(WebElement ele) {
			
			JavascriptExecutor js =  (JavascriptExecutor) driver;
			js.executeScript("return arguments[0].getAttribute('value')", ele);
			
		}
		public static void jsSetAttribute(WebElement ele) {
			
			JavascriptExecutor js =  (JavascriptExecutor) driver;
			js.executeScript("arguments[0].SetAttribute('value','123@')", ele);

		}
		public static void Frame(WebElement ele) {
			
			 f= new Frame();
			 driver.switchTo().frame("ele");
			 ele.click();

		}
		public static void SelectText(WebElement ele,String black) {
			
			Select s = new Select(ele);
			s.selectByVisibleText(black);
		}
			
		public static void number(WebElement ele,int num) {
			
			Select s = new Select(ele);
			s.deselectByIndex(num);

		}
		
		public static  String readfromexcel(String shNam,int row,int cell) throws IOException {
			
			
			File f = new File("C:\\Users\\HP\\eclipse-workspace\\Maven11am\\DataSheet\\Datapaper.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fis);
			Sheet s = w.getSheet("Sheet1");
			Row r = s.getRow(0);
			Cell c = r.getCell(0);
			int type = c.getCellType();
			
			
			String name="";
			
	        if (type==1) {
				
				name = c.getStringCellValue();
		
				
			}
			else if (DateUtil.isCellDateFormatted(c)) {
				
				Date d = c.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
				name = sdf.format(d);
				
			}
			else {
				
				double dd = c.getNumericCellValue();
				long l = (long)dd;
				name = String.valueOf(l);
			}
	        
	        System.out.println(name);
	        return name;
			
		}
	public static void overWrite(int st,int ro,int ce,String cond,String value ) throws IOException {
			
			
			File f = new File("C:\\Users\\HP\\eclipse-workspace\\Maven11am\\DataSheet\\New.xlsx");
			
			FileInputStream fis = new FileInputStream(f);
			
			Workbook w = new XSSFWorkbook(fis);
			
			Sheet mySheet = w.getSheetAt(st);
			
			Row r = mySheet.getRow(ro);
			
			Cell c = r.getCell(ce);
			
			String cels = c.getStringCellValue();
			
			if (cels.equals("cond")) {
				
				c.setCellValue("value");
				
			}
			
			FileOutputStream fos = new FileOutputStream(f);
			w.write(fos);
			
			System.out.println("Writted");
			
		}


		}
			


