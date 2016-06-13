package com.rustedbrain.util;

import com.rustedbrain.model.Accessory;
import com.rustedbrain.model.Item;
import com.rustedbrain.model.Watches;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by Alexey on 13.06.2016.
 */
public class TestEntitys {

    private static final Random random = new Random();
    private static final int DEFAULT_EARINGS_COUNT = 10;
    private static final int DEFAULT_WATCHES_COUNT = 10;
    private static final List<Item> earings = getEarings();
    private static final List<Item> watches = getWatches();

    public static final List<Item> getEarings() {
        List<Item> items = new ArrayList<>();
        IntStream.range(0, DEFAULT_EARINGS_COUNT).forEach(x -> items.add(createAccessory(x)));
        return items;
    }

    private static Accessory createAccessory(int i) {
        Accessory accessory = new Accessory();
        accessory.setName("Accessory[" + i + "]");
        accessory.setSize(i);
        accessory.setPrice(i);
        accessory.setCategory(Item.ItemCategory.values()[random.nextInt(Item.ItemCategory.values().length)]);
        accessory.setStyle(Item.ItemStyle.values()[random.nextInt(Item.ItemStyle.values().length)]);
        accessory.setColor(Item.ItemColor.values()[random.nextInt(Item.ItemColor.values().length)]);
        accessory.setDescription("Description[" + i + "]");
        accessory.setDiscount(i - i / 10);
        accessory.setId(i);
        accessory.setMale(random.nextBoolean());
        accessory.setRegistrationDate(new Date(System.currentTimeMillis()));
        accessory.setWeight(i);
        return accessory;
    }

    public static List<Item> getWatches() {
        List<Item> items = new ArrayList<>();
        IntStream.range(0, DEFAULT_WATCHES_COUNT).forEach(x -> items.add(createWatches(x)));
        return items;
    }

    private static Watches createWatches(int i) {
        Watches watches = new Watches();
        watches.setName("Watches[" + i + "]");
        watches.setType(Watches.ClockType.values()[random.nextInt(Watches.ClockType.values().length)]);
        watches.setPrice(i);
        watches.setCategory(Item.ItemCategory.values()[random.nextInt(Item.ItemCategory.values().length)]);
        watches.setStyle(Item.ItemStyle.values()[random.nextInt(Item.ItemStyle.values().length)]);
        watches.setColor(Item.ItemColor.values()[random.nextInt(Item.ItemColor.values().length)]);
        watches.setDescription("Description[" + i + "]");
        watches.setDiscount(i - i / 10);
        watches.setId(i);
        watches.setMale(random.nextBoolean());
        watches.setRegistrationDate(new Date(System.currentTimeMillis()));
        watches.setWeight(i);
        return watches;
    }
}
