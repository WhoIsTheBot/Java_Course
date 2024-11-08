package labs.lab0;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Variant9Test {

    ////////////////////////////////////////////////

    @Test(dataProvider = "integerProvider")
    public void inputTest(int p1, int p3) {
        assertEquals(new Variant9().integerNumbersTask(p1), p3);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] {
                { 100, 1 },
                { 139, 1 },
                { 250, 2 },
                { 999, 9 }
        };
    }

    ////////////////////////////////////////////////

    @Test(dataProvider = "ifProvider")
    public void ifTest(int p1, int p2, int expectedA, int expectedB) {
        int[] result = new Variant9().ifTask(p1, p2);
        assertEquals(result[0], expectedA);
        assertEquals(result[1], expectedB);
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] {
                { 2, 3, 2, 3 },     // A < B
                { 5, 2, 2, 5 },     // A > B
                { 0, 0, 0, 0 },     // A == B
                { -3, -1, -3, -1 }, // A < B
                { -1, -3, -3, -1 }  // A > B
        };
    }
    //////////////////////////////////////////////////

    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int p1, int p2, boolean p3) {
        assertEquals(new Variant9().booleanTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] {
                { 5, 2, true },   // A непарне
                { 4, 3, true },   // B непарне
                { 2, 4, false },  // обидва парні
                { -3, -2, true }, // A непарне
                { -4, -6, false },// обидва парні
                { 0, 1, true },   // B непарне
                { 0, 0, false }   // обидва парні
        };
    }
    //////////////////////////////////////////////////

    @Test(dataProvider = "switchProvider")
    public void switchTest(int day, int month, int expectedDay, int expectedMonth) {
        int[] result = new Variant9().switchTask(day, month);
        assertEquals(result[0], expectedDay);
        assertEquals(result[1], expectedMonth);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][] {
                { 28, 2, 1, 3 },   // Наступний день після останнього лютого
                { 30, 4, 1, 5 },   // Наступний день після останнього дня квітня
                { 31, 12, 1, 1 },  // Наступний день після останнього дня грудня
                { 15, 3, 16, 3 },   // Звичайний день
                { 31, 8, 1, 9 }    // Наступний день після останнього дня серпня
        };
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "forProvider")
    public void forTest(int A, int B, double expectedSum) {
        assertEquals(new Variant9().forTask(A, B), expectedSum, 1e-6);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] {
                { 1, 3, 14.0 },   // 1^2 + 2^2 + 3^2 = 1 + 4 + 9 = 14
                { 2, 4, 29.0 },   // 2^2 + 3^2 + 4^2 = 4 + 9 + 16 = 29
                { 3, 5, 50.0 },   // 3^2 + 4^2 + 5^2 = 9 + 16 + 25 = 50
                { -1, 1, 2.0 },   // (-1)^2 + 0^2 + 1^2 = 1 + 0 + 1 = 2
                { -3, -1, 14.0 }   // (-3)^2 + (-2)^2 + (-1)^2 = 9 + 4 + 1 = 14
        };
    }

    ///////////////////////////////////////////////////


    @Test(dataProvider = "whileProvider")
    public void whileTest(int N, int expectedK) {
        assertEquals(new Variant9().whileTask(N), expectedK);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] {
                { 10, 4 },   // 3 * 4 = 12 > 10
                { 12, 5 },   // 3 * 5 = 15 > 12
                { 13, 5 },   // 3 * 5 = 15 > 13
                { 25, 9 }   // 3 * 9 = 27 > 25
        };
    }


    //////////////////////////////////////////
    @Test(dataProvider = "arrayProvider")
    public void arrayTest(double[] array, double expectedCount) {
        assertEquals(new Variant9().arrayTask(array), expectedCount);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] {
                { new double[] { 10, 2, 3 }, 2 },   // Парні: 10, 2
                { new double[] { 10, 2, 13 }, 2 },   // Парні: 10, 2
                { new double[] { 4, 3, 5, -4, 9, 2 }, 3 }, // Парні: 4, -4, 2
                { new double[] { 1, 3, 5 }, 0 },      // Немає парних чисел
                { new double[] { -2, -4, -6 }, 3 }    // Парні: -2, -4, -6
        };
    }



    //////////////////////////////////////////

    @Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int[][] input, int[][] expectedOutput) {
        int[][] actualOutput = new Variant9().twoDimensionArrayTask(input);
        assertTrue(Arrays.deepEquals(actualOutput, expectedOutput));
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[][] input = {{2, 3, 6, 9, -9},
                {34, 98, -9, 2, 1},
                {-4, 2, 1, 6, 1},
                {-98, 8, 1, 5, 3}};

        int[][] expectedOutput1 = {{2, 3, 6, 9, -9},   // Рядок з індексом 0 (парний)
                {-4, 2, 1, 6, 1}}; // Рядок з індексом 2 (парний)

        return new Object[][] {
                {input, expectedOutput1} // Тест на вихід
        };
    }
}
