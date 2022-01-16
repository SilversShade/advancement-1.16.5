package advancement.items;

import advancement.AdvancementMod;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class ItemModAxe extends AxeItem {
    public ItemModAxe (IItemTier tier, Rarity rarity, String name, float attackSpeedModifier) {
        super(tier, 0, attackSpeedModifier, new Item.Properties().tab(AdvancementMod.ADVANCEMENT_TAB).rarity(rarity));
        setRegistryName(name);
    }
}
