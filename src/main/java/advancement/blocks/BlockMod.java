package advancement.blocks;

import advancement.registries.AdvancementTab;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class BlockMod extends Block {

    public BlockMod(String name, Block.Properties properties) {
        super(properties);
        setRegistryName(name);
    }
}
