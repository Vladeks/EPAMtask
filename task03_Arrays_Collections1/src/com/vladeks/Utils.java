package com.vladeks;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Utils {

    /*
        A. Дано два масиви. Сформувати третій масив, що складається з тих елементів, які:
        а) присутні в обох масивах;
        б) присутні тільки в одному з масивів.
    */
    public static  <T> T[] compare(T[] first, T[] second, boolean isCommon) {

        int[] indexes =  new int[first.length + second.length];
        int count = 0;



        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if(equal(first[i],second[j], isCommon)) {
                    indexes[count++] = j;
                }
            }
        }

        T[] result = (T[]) Array.newInstance(first.getClass().getComponentType(),count);

        for (int i = 0; i < result.length; i++) {
            result[i] = second[indexes[i]];
        }

        return result;
    }

    private static <T> boolean equal(T first, T second, boolean isCommon ) {
        if (isCommon) {
            return first.equals(second);
        } else {
            return !first.equals(second);
        }
    }

    /*B. Видалити в масиві всі числа, які повторюються більше двох разів.
    * C. Знайти в масиві всі серії однакових елементів, які йдуть підряд, і видалити з них всі елементи крім одного.
    * */
    public static <T> T[] delateDuplicate(T[] array, int repeatCount) {

        int n = array.length;

        for ( int i = 0, m = 0; i != n; i++, n = m )
        {
            for ( int j = m = i + 1; j != n; j++ )
            {
                if ( array[j] != array[i] )
                {
                    if ( m != j ) {
                        array[m] = array[j];
                    }
                    m++;
                }
            }
        }


        if ( n != array.length )
        {
            T[] temp = (T[]) Array.newInstance(array.getClass().getComponentType(),n);
            for ( int i = 0; i < n; i++ ) {
                temp[i] = array[i];
            }

            array = temp;
        }

        return array;
    }

    public static void main(String[] args) {
	// write your code here
        Integer[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 1, 2, 3, 3};
        Integer[] arr2 = {3, 4, 5, 6, 7, 11, 14};
        System.out.println(Arrays.toString(compare(arr1, arr2, true)));
        System.out.println(Arrays.toString(delateDuplicate(arr1, 2)));

        String[] arr3 = {"a", "b", "c", "d"};
        String[] arr4 = {"F","b", "c", };
        System.out.println(Arrays.toString(compare(arr3, arr4, true)));

    }
}
