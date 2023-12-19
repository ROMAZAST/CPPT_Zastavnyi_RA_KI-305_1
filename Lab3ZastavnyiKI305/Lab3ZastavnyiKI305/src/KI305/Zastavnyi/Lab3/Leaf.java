package KI305.Zastavnyi.Lab3;

import java.io.PrintWriter;

import static java.lang.System.out;
/**
 * Клас Leaf представляє характеристики листка рослини.
 * Містить інформацію про форму, стан та колір листка.
 */
public class Leaf {
    // Властивості листка
    private String shape;
    private boolean state;
    private String color;

    /**
     * Конструктор за замовчуванням ініціалізує листок значеннями за замовчуванням.
     */
    public Leaf() {
        this.shape = "Немає";
        this.state = false;
        this.color = "Немає";
    }

    /**
     * Конструктор з вказаним станом ініціалізує листок формою та кольором за замовчуванням,
     * але з вказаним станом.
     *
     * @param state Стан листка.
     */
    public Leaf(boolean state) {
        this.shape = "Немає";
        this.state = state;
        this.color = "Немає";
    }

    /**
     * Конструктор із вказаною формою, станом та кольором листка.
     *
     * @param shape Форма листка.
     * @param state Стан листка.
     * @param color Колір листка.
     */
    public Leaf(String shape, boolean state, String color) {
        this.shape = shape;
        this.state = state;
        this.color = color;
    }

    /**
     * Метод, який повертає форму листка.
     *
     * @return Форма листка.
     */
    public String getShape() {
        return shape;
    }

    /**
     * Метод для встановлення форми листка.
     *
     * @param shape Форма листка.
     */
    public void setShape(String shape) {
        this.shape = shape;
    }

    /**
     * Метод, який повертає стан листка.
     *
     * @return Стан листка.
     */
    public boolean getState() {
        return state;
    }

    /**
     * Метод для встановлення стану листка.
     *
     * @param state Стан листка.
     */
    public void setState(boolean state) {
        this.state = state;
    }

    /**
     * Метод, який повертає колір листка.
     *
     * @return Колір листка.
     */
    public String getColor() {
        return color;
    }

    /**
     * Метод для встановлення коліра листка.
     *
     * @param color Колір листка.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Метод для отримання та виведення статусу листка в консоль і у файл.
     *
     * @param fout Об'єкт PrintWriter для запису в файл.
     */
    public void getStatus(PrintWriter fout) {
        if (state) {
            out.println("Листя: Є");
            fout.println("Листя: Є");
        } else {
            out.println("Листя: Немає");
            fout.println("Листя: Немає");
        }
        out.println("Форма: " + this.shape);
        out.println("Колір: " + this.color);

        fout.println("Форма: " + this.shape);
        fout.println("Колір: " + this.color);
    }
}

