package KI305.Zastavnyi.Lab5;

import java.io.*;
import java.util.Scanner;

/**
 * Клас EquationsApp демонструє обчислення та операції з файлами.
 * Використовує клас CalcWFio для обчислень та обробки винятків.
 * Це консольний додаток, де користувач вводить дані, а результат виводиться та зберігається в файлах.
 */
public class EquationsApp {

    /**
     * Головний метод класу EquationsApp.
     * Створює екземпляр CalcWFio, отримує введення користувача, виконує обчислення та демонструє операції з файлами.
     *
     * @param args Масив аргументів командного рядка.
     */
    public static void main(String[] args) {
        CalcWFio obj = new CalcWFio();
        Scanner s = new Scanner(System.in);

        try {
            System.out.print("Введіть дані: ");
            double data = s.nextDouble();

            obj.calculate(data);
            System.out.println("Результат: " + obj.getResult());

            obj.writeResTxt("textRes.txt");
            obj.writeResBin("BinRes.bin");

            obj.readResBin("BinRes.bin");
            System.out.println("Результат: " + obj.getResult());

            obj.readResTxt("textRes.txt");
            System.out.println("Результат: " + obj.getResult());
        } catch (FileNotFoundException ex) {
            System.out.println("Причина винятку: Файл не знайдено");
        } catch (IOException ex) {
            System.out.println("Причина винятку: Помилка введення/виведення");
        } catch (ArithmeticException ex) {
            System.out.println("Причина винятку: " + ex.getMessage());
        }
    }
}

/**
 * Клас CalcWFio виконує обчислення та операції з файлами для результатів.
 */
class CalcWFio {
    private double result;

    /**
     * Записує результат в текстовий файл.
     *
     * @param fName Ім'я файлу для запису результату.
     * @throws FileNotFoundException Виникає, якщо файл не знайдено.
     */
    public void writeResTxt(String fName) throws FileNotFoundException {
        PrintWriter f = new PrintWriter(fName);
        f.printf("%f ", result);
        f.close();
    }

    /**
     * Зчитує результат з текстового файлу.
     *
     * @param fName Ім'я файлу для зчитування результату.
     */
    public void readResTxt(String fName) {
        try {
            File f = new File(fName);
            if (f.exists()) {
                Scanner s = new Scanner(f);
                result = s.nextDouble();
                s.close();
            } else {
                throw new FileNotFoundException("Файл " + fName + " не знайдено");
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Записує результат в двійковий файл.
     *
     * @param fName Ім'я файлу для запису результату.
     * @throws FileNotFoundException Виникає, якщо файл не знайдено.
     * @throws IOException           Виникає, якщо виникає помилка введення/виведення.
     */
    public void writeResBin(String fName) throws FileNotFoundException, IOException {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
        f.writeDouble(result);
        f.close();
    }

    /**
     * Зчитує результат з двійкового файлу.
     *
     * @param fName Ім'я файлу для зчитування результату.
     * @throws FileNotFoundException Виникає, якщо файл не знайдено.
     * @throws IOException           Виникає, якщо виникає помилка введення/виведення.
     */
    public void readResBin(String fName) throws FileNotFoundException, IOException {
        DataInputStream f = new DataInputStream(new FileInputStream(fName));
        result = f.readDouble();
        f.close();
    }

    /**
     * Виконує обчислення на основі введених даних.
     *
     * @param x Вхідні дані для обчислення виразу.
     */
    public void calculate(double x) {
        double y, rad;
        rad = x * Math.PI / 180.0;

        if (rad == Math.PI / 2.0 || rad == -Math.PI / 2.0) {
            throw new ArithmeticException("Причина винятку: Неправильне значення даних для обчислення тангенсу");
        } else if (x == 0) {
            throw new ArithmeticException("Причина винятку: Дані = 0");
        } else {
            y = (Math.tan(rad)) / 3 * x;
            result = y;
        }
    }

    /**
     * Повертає результат обчислення.
     *
     * @return Результат обчислення.
     */
    public double getResult() {
        return result;
    }
}
