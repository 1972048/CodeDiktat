package com.bab8.data;

import com.bab8.exceptions.ArrayMakerException;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfNumber {

    private List<Integer> numbers;

    public void constructArray() {
        try {
            if(numbers==null){
                numbers = new ArrayList<Integer>(0);
                System.out.println("Creating new array");
            }
            else {
                throw new ArrayMakerException("Array sudah dibuat");
            }
        }catch (ArrayMakerException e){
            System.out.println(e.getMessage());
        }
    }

    public void increaseArrayIndex() {
        try {
            numbers.add(0);
            System.out.println("Array berhasil ditambah");
        }
        catch (NullPointerException ex){
            System.out.println("Array belum dibuat");
        }
    }

    public void addValueToArray(int index,int value)throws ArrayIndexOutOfBoundsException{
        try{
            if(index>=numbers.size()) {
                throw new ArrayIndexOutOfBoundsException("Index yang dimasukan tidak ada pada Array");
            }
            else{
                numbers.set(index, value);
            }
        }
        catch (NullPointerException e) {
            System.out.println("Array belum dibuat");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    public void showArray() throws NullPointerException {
        try {
            if(numbers.size()>=0) {
                System.out.print("Isi array : ");
                System.out.println(numbers);
            }
            else{
                System.out.println(numbers);
            }
        }catch(NullPointerException e){
            System.out.println("Array belum dibuat");
        }
    }
}