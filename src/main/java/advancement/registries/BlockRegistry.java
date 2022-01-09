package advancement.registries;

import advancement.AdvancementMod;
import advancement.blocks.BlockMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.*;

@Mod.EventBusSubscriber(modid = AdvancementMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(AdvancementMod.MOD_ID)
public class BlockRegistry {
    private static final int IRON_HARV = 2;
    private static final List<Block> blocks = new ArrayList<Block>();

    //ore
    @ObjectHolder("amethyst_ore")
    public static final Block amethyst_ore = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> e) {
        AdvancementMod.LOGGER.info("[Advancement Mod] Registering Blocks");

        register(e, new BlockMod("amethyst_ore", Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().harvestLevel(IRON_HARV).harvestTool(ToolType.PICKAXE).strength(3.0F, 2000.0f)));

    }

    private static void register(RegistryEvent.Register<Block> event, Block block) {
        event.getRegistry().register(block);
        blocks.add(block);
    }

    @SubscribeEvent
    public static void registerBlocksAsItems(final RegistryEvent.Register<Item> registry) {
        Item.Properties properties = new Item.Properties().tab(AdvancementTab.advancement_tab);
        for (Block block : blocks) {
            Item itemBlock = new BlockItem(block, properties).setRegistryName(block.getRegistryName());
            registry.getRegistry().register(itemBlock);
        }
    }
}
