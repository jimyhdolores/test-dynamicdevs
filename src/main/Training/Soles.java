/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.Training;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jimy Joaquin Huacho Dolores
 */
public class Soles {

    private static final double[] DENOMINATIONS = {0.20, 0.50, 1, 2, 5, 10, 20, 50, 100, 200};

    public List<List<Double>> combinationSum(double mount) {
        List<List<Double>> result = new ArrayList<>();
        recursive(result, new ArrayList<>(), DENOMINATIONS, mount, 0, 0);
        return result;
    }

    private void recursive(List<List<Double>> result, List<Double> combination, double[] candidates, double mount, double sum, int start) {
        if (sum == mount) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (sum > mount) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            recursive(result, combination, candidates, mount, sum + candidates[i], i);
            combination.remove(combination.size() - 1);
        }
    }

}
