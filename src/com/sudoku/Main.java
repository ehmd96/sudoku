package com.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    // Methode qui accepte tous les triplets du fichier en entrée mais ne retourne que les triplets valides
    public static List<String> acceptableTriplets(List<String> triplets) {

        List<String> correctTriplets = new ArrayList<>();

        //On suppose en paramètre la liste des triplets du fichier en entrée

        for (String triplet: triplets) {
            char[] numbers = triplet.toCharArray();

            Integer[] convertedNumbers = new Integer[3];

            for (int i = 0; i < numbers.length; i++){
                convertedNumbers[i] = numbers[i] - '0';
            }

            // Si ni le x, ni le y ne sont égals à 9 (10e position), le triplet est valide
            if( (convertedNumbers[0] != 9) && (convertedNumbers[1] != 9) ) {
                correctTriplets.add(triplet);
            }
        }

        return correctTriplets;
    }

    public static Integer[][] generateSudokuGrid(List<String> validTriplets) {

        // Generation d'une grid 9 sur 9
        Integer[][] sudokuGrid = new Integer[9][9];

        for ( String validTriplet: validTriplets) {

            char[] numbers = validTriplet.toCharArray();

            Integer x = Integer.parseInt(String.valueOf(numbers[0]));
            Integer y = Integer.parseInt(String.valueOf(numbers[1]));

            System.out.println("X: " + x + "\t Y: " + y);

            sudokuGrid[x][y] = Integer.parseInt(String.valueOf(numbers[2]));
        }

        return sudokuGrid;
    }

    public static Integer[][] transposedGrid(List<String> validTriplets) {

        // Generation d'une grid 9 sur 9
        Integer[][] transposedSudokuGrid = new Integer[9][9];

        for (String validTriplet : validTriplets) {

            char[] numbers = validTriplet.toCharArray();

            Integer x = Integer.parseInt(String.valueOf(numbers[0]));
            Integer y = Integer.parseInt(String.valueOf(numbers[1]));

            transposedSudokuGrid[y][x] = Integer.parseInt(String.valueOf(numbers[2]));
        }

        return transposedSudokuGrid;
    }





    public static void main(String[] args) {
	// write your code here

        List<String> data = new ArrayList<>(Arrays.asList("014","116","218","313","411","517","615","712","819","022","127","225","324","428","529","623","726","821","031","133","239","335","436","532","637","734","838","045","148","246","349","447","541","642","743","844","057","159","252","356","454","553","651","758","855","063","161","264","362","465","568","669","767","866","079","174","273","371","472","576","678","775","877","086","182","287","388","489","585","684","781","883","098","195","291","397","493","594","696","799","892"));

        List<String> acceptableTriplets = acceptableTriplets(data);

        Integer[][] matrice = generateSudokuGrid(acceptableTriplets);

        Integer[][] transposed = transposedGrid(acceptableTriplets);

        System.out.println("Acceptable: \n" + acceptableTriplets.toString());

    }
}
