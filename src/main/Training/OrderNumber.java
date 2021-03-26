/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.Training;

import java.util.Arrays;

/**
 *
 * @author Jimy Joaquin Huacho Dolores
 */
public class OrderNumber {

    public int[] orderNumber(int[] numbers) {

        if (existNumberNegative(numbers)) {
            return numbers;
        }

        Arrays.sort(numbers);
        int end = numbers[numbers.length - 1];
        int sizeArray = numbers[numbers.length - 1];
        int start = 1;

        boolean contentZero = numbers[0] == 0;
        if (contentZero) {
            start = 0;
            sizeArray++;
        }

        int array[] = new int[sizeArray];

        for (int i = start; i <= end; i++) {
            array[contentZero ? i : i - 1] = i;
        }

        return array;
    }

    private boolean existNumberNegative(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                return true;
            }
        }

        return false;
    }
}
