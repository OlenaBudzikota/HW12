package org.example.EX1;

public class Timer {
   public static void main(String[] args) {
      new Thread(()-> {
         int i = 1;
         while (true){
             try {
                System.out.println("Time passed: " + i + " seconds");
                i++;
                 Thread.sleep(1000);

             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }


         }
      }).start();

      new Thread(() -> {
         while (true){
             try {
                 Thread.sleep(5000);
                 System.out.println(" Минуло 5 секунд");
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }

         }
      }).start();

   }
}
