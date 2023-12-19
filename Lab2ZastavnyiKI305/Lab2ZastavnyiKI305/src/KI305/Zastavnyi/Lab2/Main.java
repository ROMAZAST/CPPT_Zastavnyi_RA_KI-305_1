package KI305.Zastavnyi.Lab2;

import java.io.IOException;
/**
 *
 * Main class implements main method for Ship class possibilities demonstration
 *
 * @author Roman Zastavnyi
 *
 */
public class Main {
        public static void main(String[] args) throws IOException {
                // Створення екземпляру класу Plant
                Plant plant = new Plant();


                plant.getStatus(); // Виклик методу інформації про рослину
                plant.Death(); //Виклик методу смерті рослини

                // Створення іншого екземпляру класу Plant з конкретними параметрами
                Plant tree = new Plant("Дуб", "Коричневий", 100);

                // Виклик методів та встановлення властивостей для екземпляру tree
                tree.getStatus();// Виклик методу інформації про рослину
                tree.photosynthesis(10);// Спроба фотосинтезу з кількістю світла 10
                int hum = 10;
                tree.setHumidity(hum); // Встановлення вологості в рослині, у кількості 10
                System.out.println("Встановлено " + hum + " вологості у рослині: " + tree.getName());
                tree.photosynthesis(11);// Спроба фотосинтезу з кількістю світла 11
                System.out.println();
                tree.getStatus();
                tree.finish();

                // Створення екземпляру класу Plant з більшою кількістю параметрів
                Plant plant1 = new Plant("Яблуня", new Size(1, 2, 3), "Зелений",
                        new Fruit(true, "Зелений", "Стиглі"), new Leaf("Серцеподібна", true, "Зелений"), 16, 10);


                plant1.getStatus();
                System.out.println("Назва рослини plant1: "+plant1.getName()); // Вивід назви рослини plant1
                plant1.finish();
        }
}

