package advancement.items;

import advancement.AdvancementMod;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class ItemModSword extends SwordItem {
    public ItemModSword (IItemTier tier, String name, float attackSpeedModifier) {
        super(tier, 3, attackSpeedModifier, new Item.Properties().tab(AdvancementMod.ADVANCEMENT_TAB));
        setRegistryName(name);
    }
}
