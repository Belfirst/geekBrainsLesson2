import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.Arrays;

public class lesson2 {

    public static void main(String[] args) {

        // Задание 1

        // Создаем произвольный массив состоящий только из 0 и 1.
        int[] arrayBinary = new int[8];
        for (int i = 0; i < arrayBinary.length; i++) {
            arrayBinary[i] = (int) Math.round(Math.random());

        }
        System.out.println(Arrays.toString(arrayBinary));

        // Меняем все цифры на противоположные
        for (int i = 0; i < arrayBinary.length; i++) {
            if (arrayBinary[i] == 1)
                arrayBinary[i] = 0;
            else
                arrayBinary[i] = 1;
        }
        System.out.println(Arrays.toString(arrayBinary));

        // Задание 2 заполняем числами кратными 3

        int num = 0;
        int[] arrayFull = new int[8];
        for (int i = 0; i < arrayFull.length; i++) {
            arrayFull[i] = num;
            num += 3;
        }
        System.out.println(Arrays.toString(arrayFull));

        // Задание 3 числа меньше 6 умножаем на 2

        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6)
                array[i] = array[i] * 2;
        }
        System.out.println(Arrays.toString(array));

        // Задание 4 заполняем 1 по диаганали

        int n = 0;
        int[][] matrix = new int[5][5];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }

            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println("Массив с 1 по диаганали");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j + n] = 1;
                ++n;
                break;
            }
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println("Или надо было так???");

        n = 0;
        matrix = new int[5][5];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                matrix[i][j + n] = 1;
                ++n;
                break;

            }
            System.out.println(Arrays.toString(matrix[i]));
        }

        // Задание 5 находим max и min числа в массиве
        // Используем массив из третьего задания
        int max = array[0];
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            } else if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("max " + max + " min " + min);

        // Задание 6 проверка суммы сторон

        int[] checkArray = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(checkArray));

        // Задание 7 смещение массива на n

        int[] ar = {1,2,3};
        offsetArray( ar,1);

    }


    public static boolean checkBalance(int[] arr) {

        int left = 0;
        int right = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 == 0) {
            sum /= 2;
            for (int i = 0; i < arr.length; i++) {
                if(sum > left) left += arr[i];
                if(sum > right) right += arr[arr.length - 1 - i];
            }
            if(left > sum || right > sum) return  false;
            else return true;
        }
         return false;
    }

    public static void offsetArray(int[] arr, int n){

        int keep;

        if(n > 0){

            for (int i = 0; i < n; i++) {
                keep = arr[0];
                for (int j = 0; j < arr.length; j++) {
                    if(j != arr.length -1) arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = keep;
            }
        }
        else {
            for (int i = 0; i > n; i--) {
                keep = arr[arr.length - 1];
                for (int j = 0; j < arr.length; j++) {
                    if(j != arr.length - 1) arr[arr.length - 1 - j] = arr[arr.length - 2 - j];
                }
                arr[0] = keep;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

