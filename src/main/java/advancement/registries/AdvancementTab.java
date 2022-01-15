package advancement.registries;

import advancement.AdvancementMod;
import jdk.nashorn.internal.ir.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.omg.CORBA.PUBLIC_MEMBER;

public class AdvancementTab extends ItemGroup {

    public AdvancementTab (String name) {
        super(name);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemRegistry.amethyst);
    }

    @Override
    public void fillItemList (NonNullList<ItemStack> itemsToFill) {
        for (Item itemBlock : BlockRegistry.blockItems)
            itemsToFill.add(itemBlock.getDefaultInstance());
        itemsToFill.add(ItemRegistry.amethyst.getDefaultInstance());
        itemsToFill.add(ItemRegistry.ruby.getDefaultInstance());
        itemsToFill.add(ItemRegistry.sapphire.getDefaultInstance());
        itemsToFill.add(ItemRegistry.celestial_crystal.getDefaultInstance());
        itemsToFill.add(ItemRegistry.platinum_ingot.getDefaultInstance());
        itemsToFill.add(ItemRegistry.three_crystal_sword.getDefaultInstance());
        itemsToFill.add(ItemRegistry.three_crystal_pickaxe.getDefaultInstance());
        itemsToFill.add(ItemRegistry.three_crystal_axe.getDefaultInstance());
        itemsToFill.add(ItemRegistry.three_crystal_shovel.getDefaultInstance());
        itemsToFill.add(ItemRegistry.three_crystal_hoe.getDefaultInstance());
    }
}
