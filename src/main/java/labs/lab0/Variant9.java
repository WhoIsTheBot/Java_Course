package labs.lab0;

import java.util.ArrayList;
import java.util.List;

public class Variant9 {



    public int integerNumbersTask(int k) {
        if (k < 100 || k > 999) {
            throw new IllegalArgumentException("Число повинно бути тризначним");
        }
        return k / 100;
    }

    public boolean booleanTask(int number1, int number2) {
        return (number1 % 2 != 0) || (number2 % 2 != 0);
    }

    public int[] ifTask(int a, int b) {
        if (a >= b) {
            // Обмін значеннями
            int temp = a;
            a = b;
            b = temp;
        }
        return new int[]{a, b}; // Повертаємо масив з новими значеннями
    }

    public int[] switchTask(int day, int month) {
        // Кількість днів у кожному місяці для невисокосного року
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // Перевірка на правильність дати
        if (month < 1 || month > 12 || day < 1 || day > daysInMonth[month - 1]) {
            throw new IllegalArgumentException("Неправильна дата");
        }

        // Збільшення дня
        day++;

        // Якщо день перевищує кількість днів у місяці
        if (day > daysInMonth[month - 1]) {
            day = 1; // Скидаємо день на перший
            month++; // Переходимо до наступного місяця

            // Якщо місяць перевищує 12, скидаємо його на 1 і можемо обробити рік
            if (month > 12) {
                month = 1; // Скидаємо місяць на січень
                // Тут можна додати логіку для переходу на наступний рік, якщо потрібно
            }
        }

        return new int[]{day, month}; // Повертаємо нові значення дня та місяця
    }

    public double forTask(int A, int B) {
        assert A < B : "A should be less than B";

        double sum = 0;
        for (int i = A; i <= B; i++) {
            sum += i * i; // Додаємо квадрат числа
        }
        return sum;
    }



    public int whileTask(int N) {
        assert N > 1 : "N should be greater than 1";

        int K = 1; // Починаємо з K = 1
        while (3 * K <= N) {
            K++; // Збільшуємо K, поки не знайдемо правильне значення
        }
        return K; // Повертаємо знайдене значення K
    }

    public double arrayTask(double[] array) {
        List<Double> evenNumbers = new ArrayList<>();

        // Проходимо масив з кінця до початку
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 == 0) { // Перевіряємо на парність
                evenNumbers.add(array[i]); // Додаємо парне число до списку
            }
        }

        // Виводимо парні числа
        for (double number : evenNumbers) {
            System.out.println(number);
        }

        // Повертаємо кількість парних чисел
        return evenNumbers.size();
    }

    public int[][] twoDimensionArrayTask(int[][] array) {
        // Обчислюємо кількість парних рядків
        int rowCount = (array.length + 1) / 2; // Кількість парних рядків
        int[][] result = new int[rowCount][];

        for (int i = 0; i < rowCount; i++) {
            int evenRowIndex = i * 2; // Індекс парного рядка
            if (evenRowIndex < array.length) { // Перевірка на межі
                result[i] = array[evenRowIndex]; // Копіюємо парний рядок
            }
        }

        return result; // Повертаємо нову матрицю
    }

    public static void main(String... strings) {
        System.out.println("Start of zero lab");
        System.out.println("Done!!!");
    }

}
