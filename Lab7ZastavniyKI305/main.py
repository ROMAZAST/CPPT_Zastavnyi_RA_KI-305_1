import sys

def create_filled_matrix(rows_num, filler):
    """
    Створює трикутну матрицю з символами-заповнювачами.

    :param rows_num: Кількість рядків у матриці.
    :param filler: Символ-заповнювач для матриці.
    :return: Трикутна матриця з символами-заповнювачами.
    """
    lst = []

    # Перевірка правильності символу-заповнювача
    if len(filler) == 1:
        filler_ord = ord(filler)
    elif len(filler) == 0:
        print("Не введено символ-заповнювач")
        sys.exit(1)
    else:
        print("Забагато символів-заповнювачів")
        sys.exit(1)

    # Створення трикутної матриці
    for i in range(rows_num):
        lst.append([])
        for j in range(rows_num - i):
            lst[i].append(filler_ord)

    return lst

def print_matrix(matrix):
    """
    Виводить трикутну матрицю на екран.

    :param matrix: Трикутна матриця.
    """
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            print(chr(matrix[i][j]), end=" ")
        print("")

if __name__ == "__main__":
    rows_num = int(input("Введіть розмір квадратної матриці: "))
    filler = input("Введіть символ-заповнювач: ")

    # Створення та вивід матриці
    matrix = create_filled_matrix(rows_num, filler)
    print_matrix(matrix)
