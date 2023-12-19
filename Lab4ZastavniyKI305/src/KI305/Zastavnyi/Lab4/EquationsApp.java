package KI305.Zastavnyi.Lab4;
import java.io.*;
import java.util.Scanner;
import static java.lang.System.out;

/**
 * Клас EquationsApp містить метод main для демонстрації обчислень та операцій з файлами.
 * Використовує клас Equations для обчислення виразу ((tg(x)) / 3x).
 * Здійснює запис результатів у файл та обробляє можливі виняткові ситуації.
 * Являє собою консольний додаток для введення користувачем імені файлу та значення X для обчислень.
 */
public class EquationsApp {

    /**
     * Головний метод додатку.
     *
     * @param args Аргументи командного рядка (не використовуються в цьому додатку).
     */
    public static void main(String[] args) {
        try {
            out.print("Введіть ім'я файлу: ");
            Scanner in = new Scanner(System.in);
            String fName = in.nextLine();
            PrintWriter fout = new PrintWriter(new File(fName));

            try {
                try {
                    Equations eq = new Equations();
                    out.print("Введіть X: ");
                    fout.print(eq.calculate(in.nextInt()));
                } finally {
                    // Цей блок виконається за будь-яких обставин
                    fout.flush();
                    fout.close();
                }
            } catch (CalcException ex) {
                // Блок перехоплює помилки обчислень виразу
                out.print(ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            // Блок перехоплює помилки роботи з файлом навіть якщо вони виникли у блоці finally
            out.print("Причина винятку: Можливо, невірний шлях до файлу");
        }
    }
}

/**
 * Клас CalcException розширює клас ArithmeticException та надає більш точну інформацію про помилку під час обчислень.
 * Використовується для виняткових ситуацій під час обчислення виразу в класі Equations.
 * Автор: Roman Zasvanyi.
 */
class CalcException extends ArithmeticException {

    /**
     * Конструктор без параметрів.
     */
    public CalcException() {}

    /**
     * Конструктор з параметром, який приймає причину помилки.
     *
     * @param cause причина помилки
     */
    public CalcException(String cause) {
        super(cause);
    }
}

/**
 * Клас Equations реалізує метод для обчислення виразу ((tg(x)) / 3x).
 * Використовується у додатку EquationsApp для проведення обчислень.
 * Автор: Roman Zasvanyi.
 */
class Equations {

    /**
     * Метод обчислює вираз ((tg(x)) / 3x).
     *
     * @param x значення x для обчислення виразу
     * @return результат виразу
     * @throws CalcException виникає в разі некоректних обчислень
     */
    public double calculate(int x) throws CalcException {
        double y, rad;
        rad = x * Math.PI / 180.0;

        try {
            y = (Math.tan(rad)) / 3 * x;

            // Якщо результат не є числом, генеруємо виняток
            if (Double.isNaN(y) || Double.isInfinite(y) || x == 90 || x == -90)
                throw new ArithmeticException();

        } catch (ArithmeticException ex) {
            // Створюємо виняток вищого рівня з поясненням причини помилки
            if (rad == Math.PI / 2.0 || rad == -Math.PI / 2.0)
                throw new CalcException("Причина винятку: Неправильне значення X для обчислення тангенсу");
            else if (x == 0)
                throw new CalcException("Причина винятку: X = 0");
            else
                throw new CalcException("Невідома причина винятку під час обчислення виразу");
        }

        return y;
    }
}
