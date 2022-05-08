package com.corejava.multithreading.deadlock;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        List<Item> itemList=dataFromDB();

        itemList.stream()
                .filter(item->item.getPrice()>200)
                .collect(Collectors.toList())
                .forEach(item->System.out.println("item price having more than 200 item=="+item));


        Map<String,List<Item>> groupByItemName= itemList.stream()
                .collect(Collectors.groupingBy(Item::getItemName));
        for (Map.Entry<String,List<Item>> entry:groupByItemName.entrySet()) {
           System.out.println("itemName=  "+entry.getKey()+"  count= "+entry.getValue().size());
        }

    }
    public static List<Item> dataFromDB(){
        return Arrays.asList(
          new Item(1,"Apple",250),
                new Item(2,"Mango",120),
                new Item(3,"Apple",280),
                new Item(4,"Banana",15)

        );
    }
}

class Item{
    private Integer id;
    private String itemName;
    private Integer price;

    public Item(Integer id, String itemName, Integer price) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getPrice() {
        return price;
    }
}
