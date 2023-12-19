class Size:
    def __init__(self, width=0, height=0, length=0):
        """
        Конструктор класу Size.

        Ініціалізує атрибути розміру рослини.

        Args:
        - width (float): Ширина рослини.
        - height (float): Висота рослини.
        - length (float): Довжина рослини.

        """
        self.width = width
        self.height = height
        self.length = length

    def get_width(self):
        """
        Отримання ширини рослини.

        Returns:
        - float: Ширина рослини.

        """
        return self.width

    def set_width(self, width):
        """
        Встановлення ширини рослини.

        Args:
        - width (float): Ширина рослини.

        """
        self.width = width

    def get_height(self):
        """
        Отримання висоти рослини.

        Returns:
        - float: Висота рослини.

        """
        return self.height

    def set_height(self, height):
        """
        Встановлення висоти рослини.

        Args:
        - height (float): Висота рослини.

        """
        self.height = height

    def get_length(self):
        """
        Отримання довжини рослини.

        Returns:
        - float: Довжина рослини.

        """
        return self.length

    def set_length(self, length):
        """
        Встановлення довжини рослини.

        Args:
        - length (float): Довжина рослини.

        """
        self.length = length

    def get_status(self, fout):
        """
        Виведення статусу розміру рослини.

        Args:
        - fout (File): Файловий об'єкт для запису.

        """
        print("Ширина:", self.width)
        print("Довжина:", self.length)
        print("Висота:", self.height)

        fout.write("Ширина: " + str(self.width) + "\n")
        fout.write("Довжина: " + str(self.length) + "\n")
        fout.write("Висота: " + str(self.height) + "\n")

    def change_size_to_grow(self):
        """
        Збільшення розміру рослини.

        """
        self.set_width(self.width + 1.1)
        self.set_height(self.height + 1.1)
        self.set_length(self.length + 1.1)

    def change_size_to_death(self):
        """
        Зміна розміру рослини на нуль (для "смерті").

        """
        self.set_width(0)
        self.set_height(0)
        self.set_length(0)
