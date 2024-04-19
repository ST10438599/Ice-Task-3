/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ice_task_3;

import java.util.Scanner;

/**
 *
 * @author damia
 */
public class Ice_Task_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner input = new Scanner(System.in);

        System.out.println("ENTER SET OF PARENTHESIS:");
        String user = input.nextLine();

        System.out.println(user + " is " + (isValid(user) ? "valid" : "invalid"));
        
        
        System.out.println("Please enter a limit of the amount of odd multiples you deisre:");
        
         int limit = input.nextInt(); 
        int sum = sumOfOddSquares(limit);
        System.out.println("Sum of squares of odd numbers up to " + limit + ": " + sum);

        
        System.out.println("Please enter your 2 divisors on each line");
        
        int divisor1 = input.nextInt();
        int divisor2 = input.nextInt();
        
        int result = greatestCommonDivisor(divisor1, divisor2);
        System.out.println("Greatest common divisor: " + result); 
        
        
        

    }

    public static boolean isValid(String s) {
        StringBuilder firstSymbol = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                firstSymbol.append(c);
            } else {
                int lastIndex = firstSymbol.length() - 1;
                if (lastIndex < 0) {
                    return false;
                }

                char lastOpen = firstSymbol.charAt(lastIndex);
                if ((c == ')' && lastOpen == '(') || (c == '}' && lastOpen == '{') || (c == ']' && lastOpen == '[')) {
                    firstSymbol.deleteCharAt(lastIndex);
                } else {
                    return false;
                }
            }
        }

        return firstSymbol.length() == 0;

    }
    
    
      public static int sumOfOddSquares(int limit) {
        int sum = 0;
        for (int i = 1; i <= limit; i += 2) { 
            sum += (2 * i - 1) * (2 * i - 1);
        }
        return sum;
    }
      
      
      
    public static int greatestCommonDivisor(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    
    
}
