package org.example.EX2;

import java.util.LinkedList;
import java.util.List;


public class  FizzBuzz {
    private List<String> listOfNumbers = new LinkedList<>();
    private int n;
    private int index = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public synchronized void fizz() throws InterruptedException{
        while (index <= n){
            if (index % 3 ==0 && index % 5 != 0){
                listOfNumbers.add("fizz");
                index++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
    public synchronized void buzz() throws InterruptedException{
        while (index <= n){
            if (index % 5 ==0 && index % 3 != 0){
                listOfNumbers.add("buzz");
                index++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void fizzbuzz() throws InterruptedException{
        while (index <= n){
            if (index % 3 ==0 && index % 5 == 0){
                listOfNumbers.add("fizzbuzz");
                index++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void number() throws InterruptedException{
        while (index <= n){
            if (index % 3 !=0 && index % 5 != 0){
                listOfNumbers.add(String.valueOf(index));
                index++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(76);

        Thread A = new Thread(()-> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread B = new Thread(()-> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread C = new Thread(()-> {
            try {
                fizzBuzz.fizzbuzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread D = new Thread(()-> {
            try {
                fizzBuzz.number();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        A.start();
        B.start();
        C.start();
        D.start();

        try {
            A.join();
            B.join();
            C.join();
            D.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(String.join(", ", fizzBuzz.listOfNumbers));
    }

}