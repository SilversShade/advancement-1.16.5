package advancement.registries;

import advancement.AdvancementMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class AdvancementTab {
    public static final ItemGroup advancement_tab = new ItemGroup("AdvancementMod") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.amethyst);
        }
    };
}
