import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest  {
    private final String name;
    private boolean expected;

    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getNameData() {
        return new Object[][]{
                {"ПетрПервый", false},
                {" Петр Первый", false},
                {"Петр Первый ", false},
                {"Петр ПервыйВторойТре", false},
                {"Пе",false},
                {"", false},
                {"    ", false},
                {null, false},
                {"Петр Первый", true},
                {"Петр ПервыйВторойТ", true},
                {"Петр ПервыйВторойТр", true},
                {"П е",true},
                {"Пе т",true},
        };
    }

    @Test
    @DisplayName("name Validation Test")
    @Description("Проверка метода на КЭ и ГЗ")
    public void nameValidationTest() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmbossRegular(name);
        assertEquals(expected, actual);
    }
}