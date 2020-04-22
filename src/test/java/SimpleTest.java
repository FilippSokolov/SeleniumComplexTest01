import io.qameta.allure.Owner;
import org.testng.annotations.Test;

//#####TEST - https://youtrack.jetbrains.com/issue/IDEA-236855
//Selenium: find usages action shows two elements for Allure owner

@Owner("user.name")
public class SimpleTest {
    @Test
    public void testName() {
    }
}