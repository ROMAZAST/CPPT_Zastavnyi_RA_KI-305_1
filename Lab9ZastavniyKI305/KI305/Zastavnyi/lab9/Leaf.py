class Leaf:
    def __init__(self, shape="Немає", state=False, color="Немає"):
        """
        Конструктор класу Leaf.

        Ініціалізує атрибути листка рослини.

        Args:
        - shape (str): Форма листка.
        - state (bool): Стан листка (присутній/відсутній).
        - color (str): Колір листка.

        """
        self.shape = shape
        self.state = state
        self.color = color

    def get_shape(self):
        """
        Отримання форми листка.

        Returns:
        - str: Форма листка.

        """
        return self.shape

    def set_shape(self, shape):
        """
        Встановлення форми листка.

        Args:
        - shape (str): Форма листка.

        """
        self.shape = shape

    def get_state(self):
        """
        Отримання стану листка.

        Returns:
        - bool: Стан листка (присутній/відсутній).

        """
        return self.state

    def set_state(self, state):
        """
        Встановлення стану листка.

        Args:
        - state (bool): Стан листка (присутній/відсутній).

        """
        self.state = state

    def get_color(self):
        """
        Отримання коліру листка.

        Returns:
        - str: Колір листка.

        """
        return self.color

    def set_color(self, color):
        """
        Встановлення коліру листка.

        Args:
        - color (str): Колір листка.

        """
        self.color = color

    def get_status(self, fout):
        """
        Виведення статусу листка.

        Args:
        - fout (File): Файловий об'єкт для запису.

        """
        if self.state:
            print("Листя: Є")
            fout.write("Листя: Є\n")
        else:
            print("Листя: Немає")
            fout.write("Листя: Немає\n")

        print("Форма:", self.shape)
        print("Колір:", self.color)

        fout.write("Форма: " + self.shape + "\n")
        fout.write("Колір: " + self.color + "\n")
