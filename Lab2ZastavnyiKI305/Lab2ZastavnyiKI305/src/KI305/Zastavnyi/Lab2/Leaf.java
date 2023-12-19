package KI305.Zastavnyi.Lab2;

import java.io.PrintWriter;

import static java.lang.System.out;

/**
 * Клас, що представляє об'єкт "Лист". Кожен лист може мати форму, стан (наявний або відсутній) та колір.
 * Для спрощення можливості створення об'єктів за замовчуванням та з заданими параметрами є конструктори.
 */
public class Leaf {
    private String shape;  // Форма листя
    private boolean state; // Наявність листя (наявний - true, відсутній - false)
    private String color;  // Колір листя

    /**
     * Конструктор за замовчуванням. Встановлює всі властивості листя на значення "Немає".
     */
    public Leaf() {
        this.shape = "Немає";
        this.state = false;
        this.color = "Немає";
    }

    /**
     * Конструктор, який дозволяє встановити стан листя при створенні об'єкта.
     *
     * @param state Стан листя (наявний - true, відсутній - false)
     */
    public Leaf(boolean state) {
        this.shape = "Немає";
        this.state = state;
        this.color = "Немає";
    }

    /**
     * Конструктор, який дозволяє встановити форму, стан та колір листя при створенні об'єкта.
     *
     * @param shape Форма листя
     * @param state Стан листя (наявний - true, відсутній - false)
     * @param color Колір листя
     */
    public Leaf(String shape, boolean state, String color) {
        this.shape = shape;
        this.state = state;
        this.color = color;
    }

    /**
     * Метод, що повертає форму листя.
     *
     * @return Форма листя
     */
    public String getShape() {
        return shape;
    }

    /**
     * Метод, що встановлює форму листя.
     *
     * @param shape Форма листя
     */
    public void setShape(String shape) {
        this.shape = shape;
    }

    /**
     * Метод, що повертає стан листя.
     *
     * @return Стан листя (наявний - true, відсутній - false)
     */
    public boolean getState() {
        return state;
    }

    /**
     * Метод, що встановлює стан листя.
     *
     * @param state Стан листя (наявний - true, відсутній - false)
     */
    public void setState(boolean state) {
        this.state = state;
    }

    /**
     * Метод, що повертає колір листя.
     *
     * @return Колір листя
     */
    public String getColor() {
        return color;
    }

    /**
     * Метод, що встановлює колір листя.
     *
     * @param color Колір листя
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Метод, що виводить статус листя на консоль та у файл за допомогою PrintWriter.
     *
     * @param fout PrintWriter об'єкт для запису у файл
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
