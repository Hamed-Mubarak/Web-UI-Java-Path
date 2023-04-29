package tests.dropdown;

import main.pages.DropDownPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTests;

import java.util.List;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption() {
        DropDownPage dropDownPage = homePage.clickOnDropDown();
        String option = "Option 1" ;
        dropDownPage.selectFromDropdown(option);
        List <String> selectedOptions = dropDownPage.getSelectedOptions();
        Assert.assertEquals(selectedOptions.size(), 1, "InCorrect number of selections");
        Assert.assertTrue(selectedOptions.contains(option), "Option 1 not selected");
    }
}
