/**
 * KI305.Zastavnyi.Lab2package
 */
package KI305.Zastavnyi.Lab3;
import java.io.*;
import static java.lang.System.out;
/**
 * Клас, що представляє абстрактний об'єкт "Рослина". Реалізує функціонал рослини та містить абстрактні методи,
         * які повинні бути реалізовані в конкретних рослинах.
         *
         * @author Roman Zastavnyi
        * @version 1.0
        */
public abstract class Plant {
    private String name;            // Ім'я рослини
    private Size size;              // Розмір рослини
    private String color;           // Колір рослини
    private Fruit fruit;            // Плід рослини
    private Leaf leaf;              // Листок рослини
    private double humidity;        // Вологість рослини
    private int countOfLeaves;      // Кількість листків
    private PrintWriter fout;       // Об'єкт для запису у файл

    /**
     * Конструктор за замовчуванням. Ініціалізує всі властивості рослини на значення за замовчуванням та створює
     * об'єкт PrintWriter для запису у файл "Log.txt".
     *
     * @throws IOException
     */
    public Plant() throws IOException {
        this.name = "Немає";
        this.size = new Size();
        this.color = "Немає";
        this.fruit = new Fruit();
        this.leaf = new Leaf();
        this.humidity = 0;
        this.countOfLeaves = 0;
        fout = new PrintWriter(new FileWriter("Log.txt", true));
    }

    /**
     * Конструктор, що дозволяє встановити ім'я, колір та кількість листків рослини при створенні об'єкта.
     *
     * @param _name          Ім'я рослини
     * @param _color         Колір рослини
     * @param countOfLeaves  Кількість листків
     * @throws IOException
     */
    public Plant(String _name, String _color, int countOfLeaves) throws IOException {
        this.name = _name;
        this.size = new Size();
        this.color = _color;
        this.fruit = new Fruit();
        this.leaf = new Leaf(true);
        this.humidity = 0;
        this.countOfLeaves = countOfLeaves;
        fout = new PrintWriter(new FileWriter("Log.txt", true));
    }

    /**
     * Конструктор, що дозволяє встановити всі властивості рослини при створенні об'єкта.
     *
     * @param name           Ім'я рослини
     * @param size           Розмір рослини
     * @param color          Колір рослини
     * @param fruit          Плід рослини
     * @param leaf           Листок рослини
     * @param humidity       Вологість рослини
     * @param countOfLeaves  Кількість листків
     * @throws IOException
     */
    public Plant(String name, Size size, String color, Fruit fruit, Leaf leaf, double humidity, int countOfLeaves) throws IOException {
        this.name = name;
        this.size = size;
        this.color = color;
        this.fruit = fruit;
        this.leaf = leaf;
        this.humidity = humidity;
        this.countOfLeaves = countOfLeaves;
        fout = new PrintWriter(new FileWriter("Log.txt", true));
    }

    /**
     * Mетод, який повертає PrintWriter об'єкт для запису у файл.
     *
     * @return PrintWriter об'єкт
     */
    public PrintWriter getFout()
    {
        return fout;
    }

    /**
     * Метод, що повертає розмір рослини.
     *
     * @return Розмір рослини
     */
    public Size getSize() {
        return size;
    }

    /**
     * Метод, що встановлює розмір рослини.
     *
     * @param size Розмір рослини
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Метод, що повертає плід рослини.
     *
     * @return Плід рослини
     */
    public Fruit getFruit() {
        return fruit;
    }

    /**
     * Метод, що встановлює плід рослини.
     *
     * @param fruit Плід рослини
     */
    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    /**
     * Метод, що повертає листок рослини.
     *
     * @return Листок рослини
     */
    public Leaf getLeaf() {
        return leaf;
    }

    /**
     * Метод, що встановлює листок рослини.
     *
     * @param leaf Листок рослини
     */
    public void setLeaf(Leaf leaf) {
        this.leaf = leaf;
    }

    /**
     * Метод, що встановлює ім'я рослини.
     *
     * @param name Ім'я рослини
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод, що встановлює колір рослини.
     *
     * @param color Колір рослини
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Метод, що встановлює вологість рослини.
     *
     * @param humidity Вологість рослини
     */
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    /**
     * Метод, що встановлює кількість листків рослини. Якщо передано від'ємне значення, виводить повідомлення про помилку.
     * Якщо передано значення 0, встановлює кількість листків на 0 та встановлює стан листка на true.
     *
     * @param countOfLeaves Кількість листків
     */
    public void setCountOfLeaves(int countOfLeaves) {
        if (countOfLeaves > 0)
            this.countOfLeaves = countOfLeaves;
        else if (countOfLeaves == 0) {
            this.countOfLeaves = countOfLeaves;
            this.leaf.setState(true);
        } else {
            out.println("Вказано неправильне значення кількості листків");
        }
    }

    /**
     * Метод, що повертає ім'я рослини.
     *
     * @return Ім'я рослини
     */
    public String getName() {
        return name;
    }

    /**
     * Метод, що повертає колір рослини.
     *
     * @return Колір рослини
     */
    public String getColor() {
        return color;
    }

    /**
     * Метод, що повертає вологість рослини.
     *
     * @return Вологість рослини
     */
    public double getHumidity() {
        return humidity;
    }

    /**
     * Метод, що повертає кількість листків рослини.
     *
     * @return Кількість листків
     */
    public int getCountOfLeaves() {
        return countOfLeaves;
    }

    /**
     * Абстрактний метод, що представляє процес зростання рослини.
     */
    public void GrowUp() {
        if(this.humidity > 0) {
            size.changeSizeToGrow();
            setCountOfLeaves(this.countOfLeaves + 1);
        }
        else {
            out.println("Рослина не може рости: недостатньо вологості.");
        }
    }
    /**
     * Метод, що виводить статус рослини на консоль та у файл за допомогою PrintWriter.
     */
    public void getStatus() {
        out.println("Рослина: " + this.name);
        out.println("Колір: " + this.color);
        out.println("Вологість: " + this.humidity);

        fout.println("Рослина: " + this.name);
        fout.println("Колір: " + this.color);
        fout.println("Вологість: " + this.humidity);

        size.getStatus(fout);

        out.println("Кількість листків: " + this.countOfLeaves);

        fout.println("Кількість листків: " + this.countOfLeaves);

        leaf.getStatus(fout);
        fruit.getStatus(fout);
        out.println();
        fout.append("\n");
    }

    /**
     * Абстрактний метод, що представляє процес фотосинтезу рослини.
     *
     * @param countLight Кількість світла для фотосинтезу
     */
    public void photosynthesis(double countLight) {
        if (countLight > 0 && this.humidity >= countLight * 0.1 && this.humidity > 0&&this.countOfLeaves > 0) {
            this.humidity -= countLight * 0.1;
            out.println("Сфотосинтезовано " + countLight * 1.2 + " кисню.");
        } else if(this.humidity <= 0){
            out.println("Недостатньо вологості для фотосинтезу.");
        }else if(this.countOfLeaves <=0){
            out.println("Недостатньо листя для фотосинтезу.");
        }else {
            out.println("Недостатньо світла для фотосинтезу.");
        }
    }

    /**
     * Метод, що представляє процес "смерті" рослини, встановлюючи всі властивості рослини на відповідні значення.
     */
    public void Death() {
        size.changeSizeToDeath();
        setColor("Немає");
        setCountOfLeaves(0);
        setHumidity(0);
        finish();
    }

    /**
     * Метод, що викликається при завершенні роботи з рослиною та закриває PrintWriter.
     */
    public void finish() {
        fout.close();
    }
}
