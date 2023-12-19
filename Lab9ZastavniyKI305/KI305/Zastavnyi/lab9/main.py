from Plant import Plant

class Tree(Plant):
    def __init__(self, tree_type="Немає"):
        """
        Конструктор класу Tree.

        :param tree_type: Тип дерева, за замовчуванням "Немає".
        """
        super().__init__()
        self.type = tree_type

    def get_type(self):
        """
        Отримати тип дерева.

        :return: Тип дерева.
        """
        print(self.type)
        return self.type

    def get_status(self):
        """
        Отримати статус дерева та вивести інформацію.

        :return: None
        """
        super().get_status()
        print("Тип дерева: " + self.type)

try:
    # Створення та робота з об'єктами Tree
    tree1 = Tree()
    tree1.set_name("Ялина")
    tree1.set_color("Зелений")
    tree1.set_count_of_leaves(100)
    tree1.set_humidity(70.0)
    tree1.grow_up()
    tree1.get_status()
    tree1.photosynthesis(10.0)
    tree1.death()

    tree2 = Tree("Хвойний")
    tree2.get_status()

except Exception as e:
    print("Помилка:", e)
