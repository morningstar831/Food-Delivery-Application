package com.FoodDelivery.Food.Delivery.serviceimpl;

import com.FoodDelivery.Food.Delivery.entity.Item;
import com.FoodDelivery.Food.Delivery.exception.ResourceNotFoundException;
import com.FoodDelivery.Food.Delivery.repository.ItemRepository;
import com.FoodDelivery.Food.Delivery.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item saveOrUpdate(Item item) {

        return itemRepository.save(item);

    }

    @Override
    public Item getItemById(int id) {
        Item item=itemRepository.findById(id);
        if(item==null)
        {
            throw new ResourceNotFoundException("Id does not exist");
        }

        return itemRepository.findById(id);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public void deleteItemById(int id) {
        Item item=itemRepository.findById(id);
        if(item==null)
        {
            throw new ResourceNotFoundException("Id does not exist");
        }
        System.out.print("workinnnnnnn");
        itemRepository.deleteById(id);

    }

    @Override
    public List<Item> getItemByCategoryName(String name) {
        return itemRepository.findAllItemsByCategory(name);
    }



    @Override
    public List<Item> getItemsByRestaurantName(String name) {

        return itemRepository.findItemsByItemName(name);
    }






}
