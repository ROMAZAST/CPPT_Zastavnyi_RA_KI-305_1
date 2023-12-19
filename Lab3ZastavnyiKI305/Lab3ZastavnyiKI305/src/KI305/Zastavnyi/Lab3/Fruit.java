package KI305.Zastavnyi.Lab3;

import java.io.PrintWriter;

import static java.lang.System.out;

/**
 * Клас Fruit представляє характеристики плоду рослини.
 * Включає в себе інформацію про наявність, колір та стиглість плоду.
 * Також надає метод для отримання та виведення статусу плоду.
 */
public class Fruit {
    // Властивості плоду
    private boolean existence;
    private String color;
    private String ripeness;

    /**
     * Конструктор за замовчуванням ініціалізує плід значеннями за замовчуванням.
     */
    public Fruit() {
        this.existence = false;
        this.color = "Немає";
        this.ripeness = "Немає";
    }

    /**
     * Конструктор із вказаною наявністю, коліром та стиглістю плоду.
     *
     * @param existence Наявність плоду.
     * @param color     Колір плоду.
     * @param ripeness  Стиглість плоду.
     */
    public Fruit(boolean existence, String color, String ripeness) {
        this.existence = existence;
        this.color = color;
        this.ripeness = ripeness;
    }

    /**
     * Метод, який повертає стан наявності плоду.
     *
     * @return true, якщо плід існує, false, якщо плід відсутній.
     */
    public boolean isExistence() {
        return existence;
    }

    /**
     * Метод для встановлення стану наявності плоду.
     *
     * @param existence true, якщо плід існує, false, якщо плід відсутній.
     */
    public void setExistence(boolean existence) {
        this.existence = existence;
    }

    /**
     * Метод, який повертає колір плоду.
     *
     * @return Колір плоду.
     */
    public String getColor() {
        return color;
    }

    /**
     * Метод для встановлення коліра плоду.
     *
     * @param color Колір плоду.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Метод, який повертає стиглість плоду.
     *
     * @return Стиглість плоду.
     */
    public String getRipeness() {
        return ripeness;
    }

    /**
     * Метод для встановлення стиглістю плоду.
     *
     * @param ripeness Стиглість плоду.
     */
    public void setRipeness(String ripeness) {
        this.ripeness = ripeness;
    }

    /**
     * Метод для отримання та виведення статусу плоду в консоль і у файл.
     *
     * @param fout Об'єкт PrintWriter для запису в файл.
     */
    public void getStatus(PrintWriter fout) {
        if (this.existence) {
            out.println("Плоди: Є");
            out.println("Колір: " + this.color);
            out.println("Стиглість: " + this.ripeness);

            fout.println("Плоди: Є");
            fout.println("Колір: " + this.color);
            fout.println("Стиглість: " + this.ripeness);
        } else {
            out.println("У рослини немає плодів.");

            fout.println("У рослини немає плодів.");
        }
    }
}
