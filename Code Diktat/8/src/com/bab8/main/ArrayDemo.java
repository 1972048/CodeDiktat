package com.bab8.main;

import com.bab8.data.ArrayOfNumber;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayDemo {

    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        ArrayOfNumber aon= new ArrayOfNumber();
        int c=5,int1=0,int2=0;
        do{
            System.out.println("=".repeat(20));
            System.out.printf("1. Make array%n2. Add length to array%n3. Insert new data to array%n4. Show array%n0. Exit%nChoice : ");
            try{
                c = scanner.nextInt();
            }catch (InputMismatchException e){
                scanner.next();
                System.out.println("Input harus bilangan");
            }
            if(c==1){
                aon.constructArray();
            }
            else if(c==2){
                aon.increaseArrayIndex();
            }
            else if(c==3){
                System.out.print("Index : ");
                try {
                    int1 = scanner.nextInt();
                    System.out.print("Number : ");
                    int2 = scanner.nextInt();
                    aon.addValueToArray(int1,int2);
                }catch (InputMismatchException e){
                    scanner.next();
                    System.out.println("Input harus bilangan");
                }
            }
            else if(c==4){
                aon.showArray();
            }
            else if(c==0){
                scanner.close();
            }
        }
        while(c!=0);
    }
}
