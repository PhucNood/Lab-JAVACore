/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author ACER
 */
public class CaculatorController {

    public CaculatorController() {
        program();
    }

    public void program() {
     
        while (true) {
               System.out.println("========= Calculator Program =========\n"
                + "1. Normal Calculator\n"
                + "2. BMI Calculator\n"
                + "3. Exit");
        int choice = Validation.checkInt("Please choice one option:", 1, 3);
            switch (choice) {
                case 1:
                    normalCaculator();
                    break;
                case 2:
                    bmiCaculator();
                    break;
                case 3:
                    return;

            }
        }

    }

    private void normalCaculator() {
        System.out.println("----- Normal Calculator -----");
        double firstNumber = Validation.checkDouble("Enter number: ", Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        while (true) {
            String opertor = Validation.CheckOperator("Enter Operator: ");
            if (opertor.equalsIgnoreCase("=")) {
                System.out.println("Result= " + firstNumber);
                break;

            }
            double secondNumber = Validation.checkDouble("Enter number: ", Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);

            if (opertor.equalsIgnoreCase("+")) {
                firstNumber += secondNumber;
                System.out.println("Memory:" + firstNumber);
            }
            if (opertor.equalsIgnoreCase("-")) {
                firstNumber -= secondNumber;
                System.out.println("Memory:" + firstNumber);
            }
            if (opertor.equalsIgnoreCase("/")) {
                while (secondNumber == 0) {
                    System.out.println("Cannot device for zero");
                    secondNumber = Validation.checkDouble("Enter number: ", Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
                }
                firstNumber /= secondNumber;
                System.out.println("Memory:" + firstNumber);
            }
            if (opertor.equalsIgnoreCase("*")) {
                firstNumber *= secondNumber;
                System.out.println("Memory:" + firstNumber);
            }
            if (opertor.equalsIgnoreCase("^")) {
                firstNumber = Math.pow(firstNumber, secondNumber);
                System.out.println("Memory:" + firstNumber);
            }

        }

    }

    private void bmiCaculator() {
        System.out.println("----- BMI Calculator -----");
        double weight = Validation.checkDouble("Enter Weight(kg):", 0, Double.POSITIVE_INFINITY);
        double height = Validation.checkDouble("Enter Height(cm)):", 0, Double.POSITIVE_INFINITY) / 100; //change cm -->m
        double bmi = weight / (height * height);
        if (bmi < 19) {
            System.out.print("Under-standard.");
        } else if (bmi >= 19 && bmi < 25) {
            System.out.print(" Standard.");
        } else if (bmi >= 25 && bmi < 30) {
            System.out.print(" Overweight.");
        } else if (bmi >= 30 && bmi < 40) {
            System.out.print("Fat - should lose weight.");
        } else {
            System.out.print("Very fat - should lose weight immediately.");
        }
    }

}
