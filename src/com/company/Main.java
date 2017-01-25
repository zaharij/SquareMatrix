package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        resultMatrix(3, 10);
    }

    /**
     * initializes current matrix
     * @param n
     * @param randomNumber
     * @return
     */
    private static int[][] getSquareMatrix(int n, int randomNumber){
        if (n % 2 == 0){
            return null;
        }
        int[][] matrix = new int[n][n];
        int[] numbers = getDifNumbers(n*n, randomNumber);

        for (int i = 0, k = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = numbers[k++];
            }
        }
        printMatrix(matrix);
        return matrix;
    }

    /**
     * returns unrepeated numbers
     * @param n
     * @param randomNumber
     * @return
     */
    private static int[] getDifNumbers(int n, int randomNumber) {
        if (n >= randomNumber){
            return null;
        }

        Random random = new Random();
        int[] numbers = new int[n];
        int currentNumber;

        outerLoop:for (int i = 0; i < numbers.length; i++){
            currentNumber = random.nextInt(randomNumber);
            for (int j = 0; j <= i; j++){
                if(currentNumber == numbers[j]){
                    i--;
                    continue outerLoop;
                }
            }
            numbers[i] = currentNumber;
        }

        return numbers;
    }

    /**
     * calculates result matrix
     * @param n
     * @param randomNumber
     */
    private static void resultMatrix(int n, int randomNumber){
        int [][] matrix = getSquareMatrix(n, randomNumber);
        int[] coordinate = new int[2];
        int maxNumber = 0;

        for (int i = 0 , q = 0, w = matrix.length - 1; i < matrix.length; i++, q++){
            for (int j = i; j < i+1; j++, w--){
                if (maxNumber < matrix[i][j]){
                    maxNumber = matrix[i][j];
                    coordinate[0] = i;
                    coordinate[1] = j;
                }
                if (maxNumber < matrix[q][w] && q != w){
                    maxNumber = matrix[q][w];
                    coordinate[0] = q;
                    coordinate[1] = w;
                }
            }
        }
        int center = n/2;
        matrix[coordinate[0]][coordinate[1]] = matrix[center][center];
        matrix[center][center] = maxNumber;
        printMatrix(matrix);
    }

    /**
     * prints the matrix
     * @param matrix
     */
    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
