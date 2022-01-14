package advancement.items;

import advancement.AdvancementMod;
import net.minecraft.item.*;

public class ItemModPickaxe extends PickaxeItem {
    public ItemModPickaxe (IItemTier tier, String name, float attackSpeedModifier) {
        super(tier, 0, attackSpeedModifier, new Item.Properties().tab(AdvancementMod.ADVANCEMENT_TAB));
        setRegistryName(name);
    }
}
