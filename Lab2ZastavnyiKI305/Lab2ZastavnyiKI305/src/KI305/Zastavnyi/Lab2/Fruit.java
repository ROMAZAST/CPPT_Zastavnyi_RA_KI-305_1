package KI305.Zastavnyi.Lab2;

import java.io.PrintWriter;

import static java.lang.System.out;

/**
 * Клас, що представляє об'єкт "Плід". Кожен плід може мати стан (наявний або відсутній), колір та ступінь стиглості.
 * Для спрощення можливості створення об'єктів за замовчуванням та з заданими параметрами є конструктори.
 */
public class Fruit {
    private boolean existence;  // Стан плоду (наявний - true, відсутній - false)
    private String color;       // Колір плоду
    private String ripeness;    // Стиглість плоду

    /**
     * Конструктор за замовчуванням. Встановлює всі властивості плоду на значення "Немає".
     */
    public Fruit() {
        this.existence = false;
        this.color = "Немає";
        this.ripeness = "Немає";
    }

    /**
     * Конструктор, який дозволяє встановити стан, колір та ступінь стиглості плоду при створенні об'єкта.
     *
     * @param existence Стан плоду (наявний - true, відсутній - false)
     * @param color     Колір плоду
     * @param ripeness  Стиглість плоду
     */
    public Fruit(boolean existence, String color, String ripeness) {
        this.existence = existence;
        this.color = color;
        this.ripeness = ripeness;
    }

    /**
     * Метод, що повертає стан плоду.
     *
     * @return Стан плоду (наявний - true, відсутній - false)
     */
    public boolean isExistence() {
        return existence;
    }

    /**
     * Метод, що встановлює стан плоду.
     *
     * @param existence Стан плоду (наявний - true, відсутній - false)
     */
    public void setExistence(boolean existence) {
        this.existence = existence;
    }

    /**
     * Метод, що повертає колір плоду.
     *
     * @return Колір плоду
     */
    public String getColor() {
        return color;
    }

    /**
     * Метод, що встановлює колір плоду.
     *
     * @param color Колір плоду
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Метод, що повертає ступінь стиглості плоду.
     *
     * @return Стиглість плоду
     */
    public String getRipeness() {
        return ripeness;
    }

    /**
     * Метод, що встановлює ступінь стиглості плоду.
     *
     * @param ripeness Стиглість плоду
     */
    public void setRipeness(String ripeness) {
        this.ripeness = ripeness;
    }

    /**
     * Метод, що виводить статус плоду на консоль та у файл за допомогою PrintWriter.
     *
     * @param fout PrintWriter об'єкт для запису у файл
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
