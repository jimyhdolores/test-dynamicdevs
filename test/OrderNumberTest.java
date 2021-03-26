/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import main.Training.OrderNumber;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jimy Joaquin Huacho Dolores
 */
public class OrderNumberTest {

    private static OrderNumber orderNumber;

    @BeforeClass
    public static void setUpClass() {
        orderNumber = new OrderNumber();
    }

    /**
     * Validamos que se agreguen y orden los números del array
     */
    @Test
    public void testOrderArray() {
        int[] array = {58, 60, 55};
        int[] response = orderNumber.orderNumber(array);
        int[] arrayExpected = new int[60];
        for (int i = 1; i <= 60; i++) {
            arrayExpected[i - 1] = i;
        }

        assertArrayEquals(arrayExpected, response);
    }

    /**
     * Validamos que solo se admita números positivos, si el array contiene un
     * número negativo debe de retornar el mismo array sin ninguna modificacion
     */
    @Test
    public void testPositive() {
        int[] array = {-58, 60, 55};
        int[] response = orderNumber.orderNumber(array);

        assertArrayEquals(array, response);
    }
}
