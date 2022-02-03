import io.qameta.allure.Step;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }
    @Step("Метод проверки имени на соответствие требованиям")
    public boolean checkNameToEmboss() {

        if (name.isEmpty()) { // проверяет, не пустая ли строка
            System.out.println("Имя отсутствует.");
            return false;
        } else if (name.isBlank()) { // проверяет что имя не состоит только из пробелов
            System.out.println("Имя состоит из пробелов.");
            return false;
        }
        else if (name.startsWith(" ")) { // проверяет начало строки на пробел
            System.out.println("Содержит пробел в начале строки.");
            return false;
        }
        else if (name.endsWith(" ")) { // проверяет конец строки на пробел
            System.out.println("Содержит пробел в конце строки.");
            return false;
        }
        else if (name.length() < 3) { // проверяет длину минимальную
            System.out.println("Имя слишком короткое.");
            return false;
        }
        else if (name.length() > 19) { // проверяет длину максимальную
            System.out.println("Имя слишком длинное.");
            return false;
        }
        else if (name.length() - name.replace(" ", "").length() != 1) { // проверяет пробелы
            System.out.println("Пробел отстуствует или больше одного.");
            return false;
        }
        System.out.println("Подходящее имя.");
        return true;
    }

    private static final String PATTERN_NAME = "(?=.{3,19}$)[а-яА-Яa-zA-Z]+\\s{1}[а-яА-Яa-zA-Z]+";

    private static final Pattern pattern_name = Pattern.compile(PATTERN_NAME);

    @Step ("Метод проверки имени через регулярное выражение")
    public boolean checkNameToEmbossRegular(String name) {
        Matcher matcher = pattern_name.matcher(name);
        return matcher.matches();
    }

}



