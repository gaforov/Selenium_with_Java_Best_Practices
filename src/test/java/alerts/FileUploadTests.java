package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testUploadFile() {
        var uploadPage = homePage.clickFileUpload();
        String filePath = System.getProperty("user.dir");
        uploadPage.uploadFile(filePath + "/resources/chromedriver.exe");
        assertEquals(uploadPage.uploadedFileName(),"chromedriver.exe", "Uploaded filename is incorrect");
    }
}
