package KI305.Zastavnyi.Lab3;

import java.io.IOException;

import static java.lang.System.out;

/**
 * Клас, що представляє об'єкт "Дерево", яке розширює клас "Рослина" та реалізує інтерфейс "GrowUp".
 * Дерево має додаткове поле "тип".
 */
public class Tree extends Plant implements GrowUp {
    private String type;  // Тип дерева

    /**
     * Конструктор за замовчуванням. Викликає конструктор базового класу та ініціалізує тип дерева на "Немає".
     *
     * @throws IOException
     */
    public Tree() throws IOException {
        super();
        this.type = "Немає";
    }

    /**
     * Конструктор, який дозволяє встановити ім'я, колір, кількість листків та тип дерева при створенні об'єкта.
     *
     * @param _name          Ім'я дерева
     * @param _color         Колір дерева
     * @param countOfLeaves  Кількість листків
     * @param type           Тип дерева
     * @throws IOException
     */
    public Tree(String _name, String _color, int countOfLeaves, String type) throws IOException {
        super(_name, _color, countOfLeaves);
        this.type = type;
    }

    /**
     * Конструктор, який дозволяє встановити всі властивості дерева при створенні об'єкта.
     *
     * @param name           Ім'я дерева
     * @param size           Розмір дерева
     * @param color          Колір дерева
     * @param fruit          Плід дерева
     * @param leaf           Листок дерева
     * @param humidity       Вологість дерева
     * @param countOfLeaves  Кількість листків
     * @param type           Тип дерева
     * @throws IOException
     */
    public Tree(String name, Size size, String color, Fruit fruit, Leaf leaf, double humidity, int countOfLeaves, String type) throws IOException {
        super(name, size, color, fruit, leaf, humidity, countOfLeaves);
        this.type = type;
    }

    /**
     * Метод, який визначає зростання дерева. Змінює розмір та кількість листків за певних умов.
     */
    @Override
    public void Grow() {
        if (this.HumidityToGrow()) {
            this.getSize().changeSizeToGrow();
            setCountOfLeaves(this.getCountOfLeaves() + 1);
        } else {
            out.println("Дерево не може рости: недостатньо вологості.");
        }
    }

    /**
     * Метод, який визначає, чи є достатньо вологості для зростання дерева.
     *
     * @return true, якщо вологість менше 10, інакше false.
     */
    @Override
    public boolean HumidityToGrow() {
        return this.getHumidity() < 10;
    }

    /**
     * Метод, який виводить статус дерева на консоль та у файл за допомогою PrintWriter.
     */
    public void getStatus() {
        super.getStatus();
        out.println("Тип: " + this.type);
        getFout().println("Тип: " + this.type);
    }
}
