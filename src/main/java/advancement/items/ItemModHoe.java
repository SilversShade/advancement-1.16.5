package advancement.items;

import advancement.AdvancementMod;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class ItemModHoe extends HoeItem {
    public ItemModHoe (IItemTier tier, Rarity rarity, String name, float attackSpeedModifier) {
        super(tier, 0, attackSpeedModifier, new Item.Properties().tab(AdvancementMod.ADVANCEMENT_TAB).rarity(rarity));
        setRegistryName(name);
    }
}
