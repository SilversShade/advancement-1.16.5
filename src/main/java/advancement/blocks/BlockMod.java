package advancement.blocks;

import advancement.AdvancementMod;
import advancement.registries.AdvancementTab;
import net.minecraft.block.Block;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class BlockMod extends Block {
    public BlockMod(String name, Block.Properties properties) {
        super(properties);
        setRegistryName(name);
    }
}
