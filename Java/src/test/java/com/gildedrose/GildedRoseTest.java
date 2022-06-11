package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    int days = 2;

    Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6) };

    GildedRose app = new GildedRose(items);

    @Test
    void sellingTest() {
        for (int i = 0; i < days; i++) {

            app.updateQuality();
        }

        assertEquals(8, app.items[0].sellIn);
    }

    @Test
    void qualityTest() {
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals(18, app.items[0].quality);
    }

    @Test
    void nameTest() {
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        assertEquals("+5 Dexterity Vest", app.items[0].name);
    }

}