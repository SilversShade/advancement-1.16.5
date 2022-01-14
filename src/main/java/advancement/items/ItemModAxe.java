package advancement.items;

import advancement.AdvancementMod;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;

public class ItemModAxe extends AxeItem {
    public ItemModAxe (IItemTier tier, String name, float attackSpeedModifier) {
        super(tier, 0, attackSpeedModifier, new Item.Properties().tab(AdvancementMod.ADVANCEMENT_TAB));
        setRegistryName(name);
    }
}
