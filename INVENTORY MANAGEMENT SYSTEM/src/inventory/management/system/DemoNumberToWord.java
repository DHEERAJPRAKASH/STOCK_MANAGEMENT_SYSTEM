/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.management.system;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author DHEERAJ PRAKASH . S
 */
public class DemoNumberToWord {

    public static final String[] units = { "","ONE","TWO","THREE","FOUR",
            "FIVE","SIX","SEVEN","EIGHT","NINE","TEN","ELEVEN","TWELVE","THIRTEEN",
            "FOURTEEN","FIFTEEN","SIXTEEN","SEVENTEEN","EIGHTEEN","NINETEEN" };

    public static final String[] tens = { "","","TWENTY","THHIRTY","FOURTY",
            "FIFTY","SIXTY","SEVENTY","EIGHTY","NINETY" };

    public static String convert(final int n)
    {
        if(n < 0)
        {
            return "Minus" + convert(-n);
        }
        if(n < 20)
        {
            return units[n];
        }
        if(n < 100)
        {
            return tens[n / 10] + (( n % 10 != 0) ? " " : "") + units[n % 10];
        }
        if(n < 1000)
        {
            return units[n / 100] + " HUNDRED" + (( n % 100 != 0) ? " " : "") + convert(n % 100);
        }
        if(n < 100000)
        {
            return convert(n / 1000) + " THOUSAND" + (( n % 100000 != 0) ? " " : "") + convert(n % 1000);
        }
        if(n < 1000000)
        {
            return convert(n / 100000) + " LAKH" + (( n % 1000000 != 0) ? " " : "") + convert(n % 100000);
        }
        return convert(n / 10000000) + " CRORE" + (( n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
    }

    /*public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Value:");
        int n = sc.nextInt();
        System.out.println(NumberFormat.getInstance().format(n) + " = " + convert(n));

    }*/

}
