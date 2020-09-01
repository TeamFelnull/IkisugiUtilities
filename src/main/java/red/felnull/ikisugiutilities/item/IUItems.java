package red.felnull.ikisugiutilities.item;


import net.minecraft.item.Item;
import red.felnull.ikisugiutilities.IkisugiUtilities;

import java.util.ArrayList;
import java.util.List;

public class IUItems {
    public static List<Item> MOD_ITEMS = new ArrayList<Item>();
    public static final Item TEST = register("test", new TestItem(new Item.Properties().group(IUItemGroup.MOD_TAB)));

    private static Item register(String name) {
        return register(name, new Item(new Item.Properties().group(IUItemGroup.MOD_TAB)));
    }

    private static Item register(String name, Item item) {
        MOD_ITEMS.add(item.setRegistryName(IkisugiUtilities.MODID, name));
        return item;
    }
}
