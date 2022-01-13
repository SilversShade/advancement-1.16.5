package advancement.items;

import advancement.AdvancementMod;
import advancement.registries.AdvancementTab;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemMod extends Item {
    private static final Item.Properties prop = new Item.Properties().tab(AdvancementMod.ADVANCEMENT_TAB);

    public ItemMod(String name) {
        super(prop);
        setRegistryName(name);
    }

}
