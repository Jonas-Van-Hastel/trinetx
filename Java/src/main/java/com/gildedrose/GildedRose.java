package com.gildedrose;

class GildedRose {
    Item[] items;

    static final String CONJURED = "Aged Brie";
    static final String AGED_BRIE = "Aged Brie";
    static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            // The Quality of an item is never negative
            if (items[i].quality < 0) {
                items[i].quality = 0;
                continue;
            }

            // "Conjured" items degrade in Quality twice as fast as normal items
            if (items[i].name.contains(CONJURED)) {
                // The Quality of an item is never more than 50
                if (items[i].quality < 50) {
                    items[i].quality -= 2;
                }

            } else if (!items[i].name.equals(AGED_BRIE)
                    && !items[i].name.equals(BACKSTAGE_PASSES)) {
                if (!items[i].name.equals(SULFURAS)) {
                    items[i].quality -= 1;
                }
            } else {

                /*
                 * "Backstage passes", like aged brie, increases in Quality as its SellIn value
                 * approaches,
                 * Quality increases by 2 when there are 10 days or less and by 3 when there are
                 * 5 days or less but
                 * Quality drops to 0 after the concert
                 */

                // The Quality of an item is never more than 50
                if (items[i].quality < 50) {
                    // "Aged Brie" actually increases in Quality the older it gets
                    items[i].quality += 1;

                    if (items[i].name.equals(BACKSTAGE_PASSES)) {
                        if (items[i].sellIn < 11) {
                            items[i].quality += 1;
                        }

                        if (items[i].sellIn < 6) {
                            items[i].quality += 1;
                        }
                    }

                }
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(AGED_BRIE)) {
                    if (!items[i].name.equals(BACKSTAGE_PASSES)) {
                        if (!items[i].name.equals(SULFURAS)) {
                            // Once the sell by date has passed, Quality degrades twice as fast
                            items[i].quality -= 1;
                        }
                    } else {
                        items[i].quality -= items[i].quality;
                    }
                } else {
                    // The Quality of an item is never more than 50
                    if (items[i].quality < 50) {
                        items[i].quality += 1;
                    }
                }
            }

            // "Sulfuras", being a legendary item, never has to be sold
            if (!items[i].name.equals(SULFURAS)) {
                items[i].sellIn -= 1;
            }
        }
    }
}