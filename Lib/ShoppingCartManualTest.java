package Lib;

import java.util.ArrayList;

public class ShoppingCartManualTest {
     public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));      // 15 , 50+ 15 =65
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }

        // Test 4 คำนวณ สินค้าที่มีโค้ดส่วนลด BOGO
        ArrayList<CartItem> BOGOCart = new ArrayList<>();
        BOGOCart.add(new CartItem("BOGO", "Bread", 25.0, 2)); // 25
        BOGOCart.add(new CartItem("BOGO", "Milk", 15.0, 2));      // 15,25+15 =40
        double total4 = ShoppingCartCalculator.calculateTotalPrice(BOGOCart);
        if (total4 == 40.0 ) {
            System.out.println("PASSED: BOGOCart cart total is correct (40.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: BOGOCart total expected 40.0 but got " + total4);
            failedCount++; 
        }
      
        // Test 5 คำนวณ สินค้าที่มีโค้ดส่วนลด BULK 
      ArrayList<CartItem> BULKCart = new ArrayList<>();
      BULKCart.add(new CartItem("BULK", "Milk", 15.0, 6));   // 90-9=81
      double total5 = ShoppingCartCalculator.calculateTotalPrice(BULKCart);
      if (total5 == 81.0 ) {
          System.out.println("PASSED: BULK cart total is correct (81.0)");
          passedCount++;
      } else {
          System.out.println("FAILED: BULK cart total expected 81.0 but got " + total5);
          failedCount++; 
      }
       // Test 6 คำนวณ สินค้าที่มีโค้ดส่วนลด BOGO และจำนวนสินค้าเป็นจำนวคี่
       ArrayList<CartItem> BOGOCart1 = new ArrayList<>();
       BOGOCart1.add(new CartItem("BOGO", "Bread", 25.0, 3)); // 50
       BOGOCart1.add(new CartItem("BOGO", "Milk", 15.0, 3));      // 30 ,50+30 =80
       double total6 = ShoppingCartCalculator.calculateTotalPrice(BOGOCart1);
       if (total6 == 80.0 ) {
           System.out.println("PASSED: BOGOCart cart total is correct (80.0)");
           passedCount++;
       } else {
           System.out.println("FAILED: BOGOCart total expected 80.0 but got " + total6);
           failedCount++; 
       }

        // Test 7 คำนวณ สินค้าที่มีโค้ดส่วนลด BULK แต่มีจำนวนสินค้าน้อยกว่า 6
      ArrayList<CartItem> BULKCart1 = new ArrayList<>();
      BULKCart1.add(new CartItem("BULK", "Milk", 15.0, 5));   // 75
      double total7 = ShoppingCartCalculator.calculateTotalPrice(BULKCart1);
      if (total7 == 75.0 ) {
          System.out.println("PASSED: BULK cart total is correct (75.0)");
          passedCount++;
      } else {
          System.out.println("FAILED: BULK cart total expected 75.0 but got " + total7);
          failedCount++; 
      }
    
       // Test 8 คำนวณ สินค้าที่มีโค้ดส่วนลด BOGO และมีสินค้าที่ไม่มีโค้ด
       ArrayList<CartItem> BOGOCart2 = new ArrayList<>();
       BOGOCart2.add(new CartItem("BOGO", "Bread", 25.0, 3)); // 50
       BOGOCart2.add(new CartItem("์NORMAL", "Milk", 15.0, 3));      // 45 ,50+45 =95
       double total8 = ShoppingCartCalculator.calculateTotalPrice(BOGOCart2);
       if (total8 == 95.0 ) {
           System.out.println("PASSED: BOGOCart cart total is correct (95.0)");
           passedCount++;
       } else {
           System.out.println("FAILED: BOGOCart total expected 95.0 but got " + total8);
           failedCount++; 
       }
        // Test 9 คำนวณ สินค้าที่มีโค้ดส่วนลด BULK และสินค้ามากว่า 6 ชิ้น และมีสินค้าที่ไม่ใส่โค้ด
      ArrayList<CartItem> BULKCart2 = new ArrayList<>();
      BULKCart2.add(new CartItem("BULK", "Milk", 15.0, 8));   // 120-12 =108
      BULKCart2.add(new CartItem("NORMAL", "Apple", 15.0, 5));   // 75 , 108 + 75 = 183
      double total9 = ShoppingCartCalculator.calculateTotalPrice(BULKCart2);
      if (total9 == 183.0 ) {
          System.out.println("PASSED: BULK cart total is correct (183.0)");
          passedCount++;
      } else {
          System.out.println("FAILED: BULK cart total expected 183.0.0 but got " + total9);
          failedCount++; 
      }

        // Test 10 คำนวณ สินค้าที่มีโค้ดส่วนลด BOGO สินค้าที่มีโค้ดส่วนลด BULK และสินค้ามากว่า 6 ชิ้น และมีสินค้าที่ไม่ใส่โค้ด
        ArrayList<CartItem> AllCart = new ArrayList<>();
        AllCart.add(new CartItem("BOGO", "Bread", 50.0, 2)); //50
        AllCart.add(new CartItem("BULK", "Milk", 15.0, 8));   // 120-12 =108
        AllCart.add(new CartItem("NORMAL", "Apple", 15.0, 5));   // 75 , 50+108+75
        double total10 = ShoppingCartCalculator.calculateTotalPrice(AllCart);
        if (total10 == 233.0 ) {
            System.out.println("PASSED: All cart total is correct (233.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: All cart total expected 233.0 but got " + total10);
            failedCount++; 
        }

        // Test 11 price หรือ quantity ติดลบ ให้ข้าม
        ArrayList<CartItem> ErrorCart = new ArrayList<>();
        ErrorCart.add(new CartItem("NORMAL", "Bread", 50.0, -2)); // ข้าม
        ErrorCart.add(new CartItem("NORMAL", "Milk", -15, 8));   // ข้าม
        ErrorCart.add(new CartItem("NORMAL", "Apple", 15.0, 3));   // 45
        double total11 = ShoppingCartCalculator.calculateTotalPrice(ErrorCart);
        if (total11 == 45.0 ) {
            System.out.println("PASSED: Error cart total is correct (45.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Error cart total expected 45.0 but got " + total11);
            failedCount++; 
        }


        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }

}
