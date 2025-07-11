package Lib;

import java.util.ArrayList;

public class ShoppingCartCalculator {
    /**
     * เขียน Javadoc ที่นี่เพื่ออธิบายกฎการทำงานและกรณีพิเศษ:
     * โปรแกรมนี้ใช้สำหรับการคำนวณราคาสุทธิสินค้าในตะกร้าและมีกฏการคำนวณสินค้าบ้างชิ้นที่มีโค้ด
     * 1."BOGO"เป็นกฏการคำนวณสิ้นค้าแบบ 1 แถม 1
     * 2."BULK"เป็นกฏส่วนลด โดย หากมีสินค้ามีโค้ด "BULK" สินค้าที่มีมากกว่าหรือเท่ากับ 6 ชิ้น ราคาจะลดลง 10%
     * - จะทำอย่างไรถ้า items เป็น null หรือ empty?  =  จะส่งราคาสิ้นค้าในตะกร้าเป็น 0.0
     * - จะทำอย่างไรถ้า CartItem มี price หรือ quantity ติดลบ? = หาก price และ quantity ติดลบ จะข้าม
     * - กฎส่วนลด BOGO (ซื้อ 1 แถม 1)
     * หากใส่โค้ด จะคำนวณราคาสิ้นค้า แบบ ซื้อ 2 จ่าย 1 ซื้อ 3 จ่าย 2
     * - กฎส่วนลด BULK (ซื้อ >= 6 ชิ้น ลด 10%)
     *  หากใส่โค้ด จะคำนวณราคาสิ้นค้า แบบ ซื้อ 6 หรือมากกว่า จะลด ราคา 10%
     * 
     * @param items รายการสิ้นค้าทั้งหมดในตะกร้า
     * @return total ราคาสิ้นค้าทั้งหมด
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        double total = 0.0;
        for(CartItem item : items){
        if (item.price()<0 || item.quantity()<0 || items == null || items.isEmpty()) {
            continue; //หาก price และ quantity ติดลบ และ items เป็น null หรือ Empty
        }
        if (item.sku().equals("NORMAL")) {
            total += item.price()*item.quantity();
        }else if(item.sku().equals("BOGO")){
            int itempromo = (item.quantity()/2)+(item.quantity()%2);
            total += itempromo*item.price();
        }else if (item.sku().equals("BULK") && item.quantity()>=6) {
             total += item.price()*item.quantity()*0.9;
            
        }else{
            total += item.price()*item.quantity();
        }
        

    }
   
        
        
        return total;
    }
}
