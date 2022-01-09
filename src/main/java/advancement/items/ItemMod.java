package advancement.items;

import advancement.AdvancementMod;
import advancement.registries.AdvancementTab;
import net.minecraft.item.Item;

public class ItemMod extends Item {
    private static final Item.Properties prop = new Item.Properties().tab(AdvancementTab.advancement_tab);

    public ItemMod(String name) {
        super(prop);
        setRegistryName(name);
    }

}
