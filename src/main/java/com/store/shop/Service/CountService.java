package com.store.shop.Service;


import com.store.shop.Entity.Cart;

import java.util.List;

public class CountService {

    private static Integer sum;
    private static Integer itemCount;

    public CountService(Integer sum, Integer itemCount) {
    }

    public static Integer getSum() {
        return sum;
    }

    public static void setSum(Integer sum) {
        CountService.sum = sum;
    }

    public static Integer getItemCount() {
        return itemCount;
    }

    public static void setItemCount(Integer itemCount) {
        CountService.itemCount = itemCount;
    }

    public static CountService count(List<Cart> cartList){
        sum = 0;
        itemCount = 0;
        itemCount = 0;
        for(Cart c : cartList){
            sum += c.getPrice();
            itemCount++;
        }
        return new CountService(sum,itemCount);
    }
}
