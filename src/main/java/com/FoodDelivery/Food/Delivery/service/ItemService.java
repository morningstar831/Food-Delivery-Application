package com.FoodDelivery.Food.Delivery.service;

import com.FoodDelivery.Food.Delivery.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    public Item saveOrUpdate(Item item);
    public Item getItemById(int id);
    public List<Item> getAllItems();
    public void deleteItemById(int id);
    public List<Item> getItemByCategoryName(String name);
    //public  List<Item> getAllItemsByRestaurantName(String name);
    //@Query("select ri.item, ri.cost,ri.restaurant from RestaurantItem ri where ri.item=(select i from Item i where i.itemName=?1)")
    public List<Item> getItemsByRestaurantName(String name);

}
