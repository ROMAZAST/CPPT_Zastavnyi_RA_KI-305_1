package KI305.Zastavnyi.Lab3;

import java.io.PrintWriter;

import static java.lang.System.out;

/**
 * Клас, що представляє розміри об'єкта. Кожен розмір може мати ширину, висоту та довжину.
 * Для спрощення можливості створення об'єктів за замовчуванням та з заданими параметрами є конструктори.
 */
public class Size {
    private double width;   // Ширина
    private double height;  // Висота
    private double length;  // Довжина

    /**
     * Конструктор за замовчуванням. Встановлює всі властивості розміру на значення 0.
     */
    public Size() {
        this.width = 0;
        this.height = 0;
        this.length = 0;
    }

    /**
     * Конструктор, який дозволяє встановити ширину, висоту та довжину розміру при створенні об'єкта.
     *
     * @param width  Ширина
     * @param height Висота
     * @param length Довжина
     */
    public Size(double width, double height, double length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    /**
     * Метод, що повертає ширину розміру.
     *
     * @return Ширина
     */
    public double getWidth() {
        return width;
    }

    /**
     * Метод, що встановлює ширину розміру.
     *
     * @param width Ширина
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Метод, що повертає висоту розміру.
     *
     * @return Висота
     */
    public double getHeight() {
        return height;
    }

    /**
     * Метод, що встановлює висоту розміру.
     *
     * @param height Висота
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Метод, що повертає довжину розміру.
     *
     * @return Довжина
     */
    public double getLength() {
        return length;
    }

    /**
     * Метод, що встановлює довжину розміру.
     *
     * @param length Довжина
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Метод, що виводить статус розміру на консоль та у файл за допомогою PrintWriter.
     *
     * @param fout PrintWriter об'єкт для запису у файл
     */
    public void getStatus(PrintWriter fout) {
        out.println("Ширина: " + this.width);
        out.println("Довжина: " + this.length);
        out.println("Висота: " + this.height);

        fout.println("Ширина: " + this.width);
        fout.println("Довжина: " + this.length);
        fout.println("Висота: " + this.height);
    }

    /**
     * Метод, що змінює розмір на зростання.
     */
    public void changeSizeToGrow() {
        setWidth(this.width + 1.1);
        setHeight(this.height + 1.1);
        setLength(this.length + 1.1);
    }

    /**
     * Метод, що змінює розмір на "Смерть", встановлюючи всі властивості розміру на значення 0.
     */
    public void changeSizeToDeath() {
        setWidth(0);
        setHeight(0);
        setLength(0);
    }
}
