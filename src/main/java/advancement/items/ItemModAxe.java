package advancement.items;

import advancement.AdvancementMod;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;

public class ItemModAxe extends AxeItem {
    public ItemModAxe (IItemTier tier, String name) {
        super(tier, 0, -2.3f, new Item.Properties().tab(AdvancementMod.ADVANCEMENT_TAB));
        setRegistryName(name);
    }
}
