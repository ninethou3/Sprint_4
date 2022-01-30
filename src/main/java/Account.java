import io.qameta.allure.Step;

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

}



