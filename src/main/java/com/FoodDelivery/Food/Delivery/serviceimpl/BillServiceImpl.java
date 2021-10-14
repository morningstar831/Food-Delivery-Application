package com.FoodDelivery.Food.Delivery.serviceimpl;

import com.FoodDelivery.Food.Delivery.entity.Bill;
import com.FoodDelivery.Food.Delivery.entity.FoodCart;
import com.FoodDelivery.Food.Delivery.entity.Item;
import com.FoodDelivery.Food.Delivery.entity.OrderDetail;
import com.FoodDelivery.Food.Delivery.repository.BillRepository;
import com.FoodDelivery.Food.Delivery.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public abstract class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Override
    public Set<Bill> getAllBills() {
        return (Set<Bill>) billRepository.findAll();
    }

    @Override
    public Bill getBillById(int billId) {
        return billRepository.getBillById(billId);

    }

//    @Override
//    public double calculateBill(List<Item> items) {
//
//        return billRepository.calculate;
//    }

    @Override
    public Bill saveOrUpdate(Bill bill) {

        return billRepository.save(bill);
    }

    @Override
    public void deleteBill(int billId) {
        billRepository.deleteById(billId);

    }

    @Override
    public int calculateBill(int billId) {
        int sum = 1;
        Bill bill = getBillById(billId);
        OrderDetail order = bill.getOrder();
        FoodCart cart = order.getCart();
        Set<Item> itemlist = cart.getItemList();
        for (Item item : itemlist) {
            sum = (int) (sum + (item.getCost() * item.getQuantity()));
            System.out.println(sum);
            System.out.print(order);
        }

        cart.getItemList();
        return sum;
    }
}





