import os
import struct
import sys
import math

def writeResTxt(fName, result):
    """
    Записує результат у текстовий файл.

    :param fName: Назва текстового файлу для запису
    :param result: Результат обчислень
    """
    with open(fName, 'w') as f:
        f.write(str(result))

def readResTxt(fName):
    """
    Зчитує результат з текстового файлу.

    :param fName: Назва текстового файлу для зчитування
    :return: Результат зчитування або 0.0, якщо файл не знайдено
    """
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'r') as f:
                result = f.read()
        else:
            raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
        print(e)
    return result

def writeResBin(fName, result):
    """
    Записує результат у бінарний файл.

    :param fName: Назва бінарного файлу для запису
    :param result: Результат обчислень
    """
    with open(fName, 'wb') as f:
        # Див. https://docs.python.org/3/library/struct.html
        f.write(struct.pack('f', result))

def readResBin(fName):
    """
    Зчитує результат з бінарного файлу.

    :param fName: Назва бінарного файлу для зчитування
    :return: Результат зчитування або 0.0, якщо файл не знайдено
    """
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'rb') as f:
                # Див. https://docs.python.org/3/library/struct.html
                result = struct.unpack('f', f.read())[0]
        else:
            raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
        print(e)
    return result

def calculate(X):
    """
    Обчислює вираз ((tg(x)) / 3x).

    :param X: Значення x для обчислення виразу
    :return: Результат обчислення
    """
    rad = X * math.pi / 180.0
    result = math.tan(rad) / (3 * X)
    return result

if __name__ == "__main__":
    try:
        data = float(input("Enter data: "))
        result = calculate(data)
        print(f"Result is: {result}")

        # Запис результатів у файли та їх зчитування
        writeResTxt("textRes.txt", result)
        writeResBin("binRes.bin", result)
        print("Result is: {0}".format(readResBin("binRes.bin")))
        print("Result is: {0}".format(readResTxt("textRes.txt")))

    except FileNotFoundError as e:
        print(e)
        sys.exit(1)
