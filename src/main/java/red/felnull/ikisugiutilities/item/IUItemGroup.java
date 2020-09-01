package red.felnull.ikisugiutilities.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import red.felnull.ikisugiutilities.IkisugiUtilities;

public class IUItemGroup {
    public static final ItemGroup MOD_TAB = new ItemGroup(IkisugiUtilities.MODID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(IUItems.TEST);
        }
    };
}
