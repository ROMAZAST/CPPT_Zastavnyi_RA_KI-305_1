import os
from Leaf import Leaf
from Size import Size
from Fruit import Fruit

class Plant:
    def __init__(self):
        """
        Конструктор класу Plant.

        Ініціалізує атрибути рослини.

        Attributes:
        - name (str): Ім'я рослини.
        - size (Size): Об'єкт класу Size, представляє розмір рослини.
        - color (str): Колір рослини.
        - fruit (Fruit): Об'єкт класу Fruit, представляє фрукти рослини.
        - leaf (Leaf): Об'єкт класу Leaf, представляє листя рослини.
        - humidity (float): Вологість рослини.
        - count_of_leaves (int): Кількість листків рослини.
        - fout (File): Файловий об'єкт для ведення логу.

        """
        self.name = "Немає"
        self.size = Size()
        self.color = "Немає"
        self.fruit = Fruit()
        self.leaf = Leaf()
        self.humidity = 0
        self.count_of_leaves = 0
        self.fout = open("./Log.txt", "a")

    def __del__(self):
        """
        Деструктор класу Plant.

        Закриває відкритий файл і завершує запис у файл логу.

        """
        if hasattr(self, 'fout') and self.fout:
            self.finish()

    def finish(self):
        """
        Завершення запису у файл логу.

        Закриває файл, якщо він відкритий.

        """
        if hasattr(self, 'fout') and self.fout:
            self.fout.close()

    def grow_up(self):
        """
        Збільшення розміру рослини та кількості листя при відповідних умовах.

        Raises:
        - ValueError: Якщо вологість рослини менше або дорівнює 0.

        """
        if self.humidity <= 0:
            raise ValueError("Рослина не може рости: недостатньо вологості.")
        else:
            self.size.change_size_to_grow()
            self.set_count_of_leaves(self.count_of_leaves + 1)

    def set_count_of_leaves(self, count_of_leaves):
        """
        Встановлення кількості листя рослини.

        Args:
        - count_of_leaves (int): Кількість листя.

        Raises:
        - ValueError: Якщо передано від'ємне значення.

        """
        if count_of_leaves < 0:
            raise ValueError("Вказано неправильне значення кількості листків")
        elif count_of_leaves == 0:
            self.count_of_leaves = count_of_leaves
            self.leaf.state = True
        else:
            self.count_of_leaves = count_of_leaves

    def get_status(self):
        """
        Виведення статусу рослини.

        Виводить інформацію про ім'я, колір, вологість, розмір, кількість листя, листя та фрукти.

        """
        print("Рослина:", self.name)
        print("Колір:", self.color)
        print("Вологість:", self.humidity)

        self.fout.write("Рослина: " + self.name + "\n")
        self.fout.write("Колір: " + self.color + "\n")
        self.fout.write("Вологість: " + str(self.humidity) + "\n")

        self.size.get_status(self.fout)

        print("Кількість листків:", self.count_of_leaves)

        self.fout.write("Кількість листків: " + str(self.count_of_leaves) + "\n")

        self.leaf.get_status(self.fout)
        self.fruit.get_status(self.fout)
        print()
        self.fout.write("\n")

    def photosynthesis(self, count_light):
        """
        Виконання процесу фотосинтезу рослини.

        Args:
        - count_light (float): Кількість світла.

        Raises:
        - ValueError: Якщо передано від'ємне або нульове значення кількості світла.

        """
        if count_light <= 0:
            raise ValueError("Недостатньо світла для фотосинтезу.")
        elif self.humidity < count_light * 0.1 or self.count_of_leaves <= 0:
            raise ValueError("Недостатньо вологості або листя для фотосинтезу.")
        else:
            self.humidity -= count_light * 0.1
            print("Сфотосинтезовано", count_light * 1.2, "кисню.")

    def death(self):
        """
        Процес вмирання рослини.

        Змінює розмір рослини, колір, кількість листя та вологість.

        """
        self.size.change_size_to_death()
        self.set_color("Немає")
        self.set_count_of_leaves(0)
        self.set_humidity(0)
        self.finish()

    def set_name(self, name):
        """
        Встановлення ім'я рослини.

        Args:
        - name (str): Ім'я рослини.

        """
        self.name = name

    def set_color(self, color):
        """
        Встановлення коліру рослини.

        Args:
        - color (str): Колір рослини.

        """
        self.color = color

    def set_humidity(self, humidity):
        """
        Встановлення вологості рослини.

        Args:
        - humidity (float): Вологість рослини.

        Raises:
        - ValueError: Якщо передано від'ємне значення вологості.

        """
        if humidity < 0:
            raise ValueError("Вологість не може бути від'ємною.")
        self.humidity = humidity

    def set_fruit(self, fruit):
        """
        Встановлення об'єкта фруктів для рослини.

        Args:
        - fruit (Fruit): Об'єкт класу Fruit.

        """
        self.fruit = fruit

    def set_leaf(self, leaf):
        """
        Встановлення об'єкта листя для рослини.

        Args:
        - leaf (Leaf): Об'єкт класу Leaf.

        """
        self.leaf = leaf

    def set_size(self, size):
        """
        Встановлення об'єкта розміру для рослини.

        Args:
        - size (Size): Об'єкт класу Size.

        """
        self.size = size

    def set_count_of_leaves(self, count_of_leaves):
        """
        Встановлення кількості листя для рослини.

        Args:
        - count_of_leaves (int): Кількість листя.

        """
        self.count_of_leaves = count_of_leaves

    def set_fout(self, fout):
        """
        Встановлення файлового об'єкта для запису у файл логу.

        Args:
        - fout (File): Файловий об'єкт.

        """
        self.fout = fout


# # Приклад використання:
# try:
#     plant1 = Plant()
#     plant1.set_name("Соняшник")
#     plant1.set_color("Жовтий")
#     plant1.set_count_of_leaves(10)
#     plant1.set_humidity(50.0)
#     plant1.set_leaf(Leaf("n","true","m"))
#     plant1.grow_up()
#     plant1.get_status()
#     plant1.photosynthesis(5.0)
#     plant1.death()
#
# except Exception as e:
#     print("Помилка:", e)
