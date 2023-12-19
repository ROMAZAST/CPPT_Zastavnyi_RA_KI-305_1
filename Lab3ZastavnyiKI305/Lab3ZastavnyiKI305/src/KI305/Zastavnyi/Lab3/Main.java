        package KI305.Zastavnyi.Lab3;

        import java.io.IOException;
        /**
         *
         * Main class implements main method for Tree class possibilities demonstration
         *
         * @author Roman Zastavnyi
         *
         */
        public class Main {
                public static void main(String[] args) throws IOException {
                        // Створення екземпляра класу Tree
                        Tree tree = new Tree();

                        tree.getStatus(); // Виклик методу інформації про дерево
                        tree.Death(); //Виклик методу смерті дерева

                        // Створення іншого екземпляру класу Tree з конкретними параметрами
                        Tree tree1 = new Tree("Вишня","Коричневий",33, "Листопадний");
                        tree1.getStatus(); // Виклик методу інформації про дерево
                        tree1.finish();

                        // Створення екземпляра класу Tree з більшою кількістю параметрів
                        Tree tree2 = new Tree("Яблуня", new Size(1, 2, 3), "Зелений",
                                new Fruit(true, "Зелений", "Стиглі"), new Leaf("Серцеподібна", true, "Зелений"), 16, 10, "Солоденьке");

                        tree2.getStatus();
                        System.out.println("Назва рослини tree2: "+ tree2.getName()); // Вивід назви дерева tree2
                        tree2.finish();
                }
        }

