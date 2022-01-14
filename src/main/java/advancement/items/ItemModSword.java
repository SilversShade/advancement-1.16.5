package advancement.items;

import advancement.AdvancementMod;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class ItemModSword extends SwordItem {
    public ItemModSword (IItemTier tier, String name) {
        super(tier, 3, 1.6f, new Item.Properties().tab(AdvancementMod.ADVANCEMENT_TAB));
        setRegistryName(name);
    }
}
