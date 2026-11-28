class Solution {
    static class Item {
        long price;
        long slots;

        Item(long price, long slots) {
            this.price = price;
            this.slots = slots;
        }
    }

    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] freq = new int[n + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }

        int[] count = new int[n + 1];

        for (int d = 1; d <= n; d++) {
            for (int j = d; j <= n; j += d) {
                count[d] += freq[j];
            }
        }

        Item[] arr = new Item[n];

        long minPrice = Long.MAX_VALUE;
        long minSlots = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            long price = items[i][1];
            long slots = count[items[i][0]] - 1;

            arr[i] = new Item(price, slots);

            if (price < minPrice) {
                minPrice = price;
                minSlots = slots;
            } else if (price == minPrice) {
                minSlots = Math.min(minSlots, slots);
            }
        }

        if (minPrice > budget)
            return 0;

        if ((long) budget < minPrice * minSlots) {
            return (int) (2L * (budget / minPrice));
        }

        Arrays.sort(arr, (a, b) -> {
            int cmp = Long.compare(a.price, b.price);
            if (cmp != 0)
                return cmp;
            return Long.compare(a.slots, b.slots);
        });

        long remaining = budget;
        long bonusCopies = 0;

        for (Item item : arr) {
            if (item.price >= 2 * minPrice)
                break;
            if (item.slots == 0)
                continue;
            
            long canBuy = remaining / item.price;
            long take = Math.min(item.slots, canBuy);

            bonusCopies += take;
            remaining -= take * item.price;

            if (take < item.slots)
                break;

        }
        return (int) (2L * bonusCopies + remaining / minPrice);
    }
}