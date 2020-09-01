package red.felnull.ikisugiutilities.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class TestItem extends Item {
    public TestItem(Properties properties) {
        super(properties);
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote()) {
            playerIn.sendStatusMessage(new StringTextComponent("イキスギ"), false);
        }
        return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
    }
}
