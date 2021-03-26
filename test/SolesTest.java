/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import main.Training.Soles;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jimy Joaquin Huacho Dolores
 */
public class SolesTest {

    private static Soles soles;

    @BeforeClass
    public static void setUpClass() {
        soles = new Soles();
    }

    /**
     * Validamos que todas las conbinaciones sumen el valor ingresado "10.5"
     */
    @Test
    public void testCombinations() {
        List<List<Double>> list = soles.combinationSum(10.5);

        boolean allEquals = true;
        for (List<Double> list1 : list) {
            double totalevent = list1.stream().mapToDouble(f -> f.doubleValue()).sum();
            if (totalevent != 10.5) {
                allEquals = false;
                break;
            }
        }
        assertEquals(true, allEquals);
    }

}
