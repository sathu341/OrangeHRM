 import org.testng.annotations.*;
 import org.testng.asserts.SoftAssert;
public class AssertTest {
 @Test
 public void Testone()
 {
	 SoftAssert sft=new SoftAssert();
	 
	 sft.assertTrue(false,"The Message Box is not Displayed");
	 System.out.println("Assertion Continue");
	 sft.assertAll();
	 
 }
}
