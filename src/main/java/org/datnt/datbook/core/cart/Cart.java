/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.datnt.datbook.core.cart;

import java.util.ArrayList;
import java.util.List;
import org.datnt.datbook.core.food.FoodDTO;
import org.datnt.datbook.core.inventory.InventoryDTO;
import org.datnt.datbook.core.item.Item;

/**
 *
 * @author datnt
 */
public class Cart {

    private List<Item> items;   

    public Cart() {
        items = new ArrayList();
    }

    public List<Item> getItems() {
        return items;
    }
//    getItemQuanty

    public int getItemQuantityById(String id) {
        return getItemById(id).getQuantity();
    }

    public Item getItemById(String id) {
        for (Item item : items) {
            if (item.getFood().getFoodId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    // add product to cart
    public void addItemToCart(Item item) {
        if (this.items == null) {
            this.items = new ArrayList();
        }
        if (getItemById(item.getFood().getFoodId()) != null) {
            Item currentItem = getItemById(item.getFood().getFoodId());
            int quantity = 1;
            int currentQuantity = currentItem.getQuantity();
            if (currentQuantity > 0) {
                currentQuantity = currentQuantity + quantity;
                currentItem.setQuantity(currentQuantity);
            }
        } else {
            items.add(item);
        }
    }

    // remove product from cart
    public void removeItemFromCart(Item item) {
        Item currentItem = getItemById(item.getFood().getFoodId());
        int quantity = 1;
        int currentQuantity = currentItem.getQuantity();

        if (currentQuantity >= quantity) {
            currentQuantity = currentQuantity - quantity;
        }
        if (currentQuantity == 0) {
            items.remove(item);
        }

        currentItem.setQuantity(currentQuantity);
    }

    //get total price;
    public double getTotalMoney() {
        double total = 0;
        for (Item item : items) {
            total += (item.getQuantity() * item.getPrice());
        }
        return total;
    }

    public FoodDTO getFoodById(String id, List<FoodDTO> list) {
        for (FoodDTO dto : list) {
            if (dto.getFoodId().equals(id)) {
                return dto;
            }
        }
        return null;
    }

    //get cart by cookie
    public Cart(String txt, List<FoodDTO> list) {
        items = new ArrayList();
        try {
            if (txt != null && txt.length() != 0) {
                String[] listfood = txt.split("/");
                for (String food : listfood) {
                    String[] foodInfo = food.split(":");
                    String id = foodInfo[0];
                    int quantity = Integer.parseInt(foodInfo[1]);
                    FoodDTO fooddto = getFoodById(id, list);
                    Item item = new Item(fooddto, quantity, fooddto.getFoodPrice());
                    addItemToCart(item);
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Cart: Error");
        }

    }

}
