class Fruit:
    def __init__(self, existence=False, color="Немає", ripeness="Немає"):
        """
        Конструктор класу Fruit.

        Ініціалізує атрибути фрукта рослини.

        Args:
        - existence (bool): Наявність фруктів.
        - color (str): Колір фруктів.
        - ripeness (str): Стиглість фруктів.

        """
        self.existence = existence
        self.color = color
        self.ripeness = ripeness

    def is_existence(self):
        """
        Отримання інформації про наявність фруктів.

        Returns:
        - bool: Наявність фруктів.

        """
        return self.existence

    def set_existence(self, existence):
        """
        Встановлення наявності фруктів.

        Args:
        - existence (bool): Наявність фруктів.

        """
        self.existence = existence

    def get_color(self):
        """
        Отримання кольору фруктів.

        Returns:
        - str: Колір фруктів.

        """
        return self.color

    def set_color(self, color):
        """
        Встановлення кольору фруктів.

        Args:
        - color (str): Колір фруктів.

        """
        self.color = color

    def get_ripeness(self):
        """
        Отримання стиглості фруктів.

        Returns:
        - str: Стиглість фруктів.

        """
        return self.ripeness

    def set_ripeness(self, ripeness):
        """
        Встановлення стиглості фруктів.

        Args:
        - ripeness (str): Стиглість фруктів.

        """
        self.ripeness = ripeness

    def get_status(self, fout):
        """
        Виведення статусу фруктів рослини.

        Args:
        - fout (File): Файловий об'єкт для запису.

        """
        if self.existence:
            print("Плоди: Є")
            print("Колір: " + self.color)
            print("Стиглість: " + self.ripeness)

            fout.write("Плоди: Є\n")
            fout.write("Колір: " + self.color + "\n")
            fout.write("Стиглість: " + self.ripeness + "\n")
        else:
            print("У рослини немає плодів.")

            fout.write("У рослини немає плодів.\n")
