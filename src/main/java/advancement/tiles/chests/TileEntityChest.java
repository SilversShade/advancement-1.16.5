package advancement.tiles.chests;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.*;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value = Dist.CLIENT, _interface = IChestLid.class)
public class TileEntityChest extends LockableLootTileEntity implements IChestLid, ITickableTileEntity {

    private NonNullList<ItemStack> chestItems = NonNullList.withSize(144, ItemStack.EMPTY); // 12x12

    protected TileEntityChest(TileEntityType<?> type) {
        super (type);
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return null;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> p_199721_1_) {

    }

    @Override
    protected ITextComponent getDefaultName() {
        return null;
    }

    @Override
    protected Container createMenu(int p_213906_1_, PlayerInventory p_213906_2_) {
        return null;
    }

    @Override
    public int getContainerSize() {
        return 144;
    }

    @Override
    public float getOpenNess(float p_195480_1_) {
        return 0;
    }

    @Override
    public void tick() {

    }
}
