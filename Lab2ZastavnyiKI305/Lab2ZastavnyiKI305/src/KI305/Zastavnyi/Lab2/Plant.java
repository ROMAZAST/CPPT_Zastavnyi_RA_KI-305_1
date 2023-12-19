/**
 * Пакет, який містить класи для реалізації рослини.
 */
package KI305.Zastavnyi.Lab2;

import java.io.*;
import static java.lang.System.out;

/**
 * Клас, що представляє рослину. Рослина має ім'я, розмір, колір, плід, лист із вологістю, кількість листків,
 * та можливість виводу інформації про стан рослини.
 * Реалізує різні конструктори для зручності створення об'єктів рослини.
 *
 * @author Roman Zastavnyi
 * @version 1.0
 */
public class Plant {
    private String name;         // Ім'я рослини
    private Size size;           // Розмір рослини (об'єкт класу Size)
    private String color;        // Колір рослини
    private Fruit fruit;         // Плід рослини (об'єкт класу Fruit)
    private Leaf leaf;           // Лист рослини (об'єкт класу Leaf)
    private double humidity;     // Вологість рослини
    private int countOfLeaves;   // Кількість листків рослини
    private PrintWriter fout;    // PrintWriter для запису в файл

    /**
     * Конструктор за замовчуванням. Ініціалізує всі властивості рослини значеннями за замовчуванням
     * та створює об'єкт PrintWriter для запису в файл "Log.txt".
     *
     * @throws IOException Якщо виникає помилка при роботі з файлом
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
     * Конструктор, який дозволяє встановити ім'я, колір та кількість листків рослини при створенні об'єкта.
     * Ініціалізує розмір за замовчуванням, а інші властивості значеннями за замовчуванням.
     * Створює об'єкт PrintWriter для запису в файл "Log.txt".
     *
     * @param _name          Ім'я рослини
     * @param _color         Колір рослини
     * @param countOfLeaves  Кількість листків рослини
     * @throws IOException   Якщо виникає помилка при роботі з файлом
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
     * Конструктор, який дозволяє встановити всі властивості рослини при створенні об'єкта.
     * Створює об'єкт PrintWriter для запису в файл "Log.txt".
     *
     * @param name           Ім'я рослини
     * @param size           Розмір рослини (об'єкт класу Size)
     * @param color          Колір рослини
     * @param fruit          Плід рослини (об'єкт класу Fruit)
     * @param leaf           Лист рослини (об'єкт класу Leaf)
     * @param humidity       Вологість рослини
     * @param countOfLeaves  Кількість листків рослини
     * @throws IOException   Якщо виникає помилка при роботі з файлом
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

    // Методи для отримання та встановлення властивостей рослини

    /**
     * Метод, що повертає розмір рослини.
     *
     * @return Розмір рослини (об'єкт класу Size)
     */
    public Size getSize() {
        return size;
    }

    /**
     * Метод, що встановлює розмір рослини.
     *
     * @param size Розмір рослини (об'єкт класу Size)
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Метод, що повертає плід рослини.
     *
     * @return Плід рослини (об'єкт класу Fruit)
     */
    public Fruit getFruit() {
        return fruit;
    }

    /**
     * Метод, що встановлює плід рослини.
     *
     * @param fruit Плід рослини (об'єкт класу Fruit)
     */
    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    /**
     * Метод, що повертає лист рослини.
     *
     * @return Лист рослини (об'єкт класу Leaf)
     */
    public Leaf getLeaf() {
        return leaf;
    }

    /**
     * Метод, що встановлює лист рослини.
     *
     * @param leaf Лист рослини (об'єкт класу Leaf)
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
     * Метод, що встановлює кількість листків рослини.
     * Якщо передане значення більше 0, то встановлює його. Якщо дорівнює 0, то встановлює його
     * та стан листя на наявний. В іншому випадку виводить повідомлення про неправильне значення.
     *
     * @param countOfLeaves Кількість листків рослини
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
     * @return Кількість листків рослини
     */
    public int getCountOfLeaves() {
        return countOfLeaves;
    }

    /**
     * Метод, що сприяє росту рослини. Змінює розмір рослини на більший та збільшує кількість листків на одиницю.
     * Для росту рослини необхідна наявність вологи.
     */
    public void GrowUp() {
        if (this.humidity > 0) {
            size.changeSizeToGrow();
            setCountOfLeaves(this.countOfLeaves + 1);
        } else {
            out.println("Рослина не може рости: недостатньо вологості.");
        }
    }

    /**
     * Метод, що виводить інформацію про стан рослини на консоль та у файл за допомогою PrintWriter.
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
     * Метод, що проводить процес фотосинтезу в рослині. Результатом є виділення кисню.
     *
     * @param countLight Кількість світла для фотосинтезу
     */
    public void photosynthesis(double countLight) {
        if (countLight > 0 && this.humidity >= countLight * 0.1 && this.humidity > 0 && this.countOfLeaves > 0) {
            this.humidity -= countLight * 0.1;
            out.println("Сфотосинтезовано " + countLight * 1.2 + " кисню.");
        } else if (this.humidity <= 0) {
            out.println("Недостатньо вологості для фотосинтезу.");
        } else if (this.countOfLeaves <= 0) {
            out.println("Недостатньо листя для фотосинтезу.");
        } else {
            out.println("Недостатньо світла для фотосинтезу.");
        }
    }


    /**
     * Метод, що викликається при смерті рослини. Змінює розмір рослини на "Смерть", встановлює колір на "Немає",
     * кількість листків на 0, вологість на 0 та завершує запис у файл журналу.
     */
    public void Death() {
        size.changeSizeToDeath();
        setColor("Немає");
        setCountOfLeaves(0);
        setHumidity(0);
        finish();
    }

    /**
     * Метод, що завершує запис у файл журналу. Закриває PrintWriter, який використовується для запису в файл.
     */
    public void finish() {
        fout.close();
    }
}
