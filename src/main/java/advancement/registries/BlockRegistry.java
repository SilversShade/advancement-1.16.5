package advancement.registries;

import advancement.AdvancementMod;
import advancement.blocks.BlockMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
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
    public static List<Item> blockItems = new ArrayList<>();
    private static final List<Block> blocks = new ArrayList<>();

    //ore
    @ObjectHolder("amethyst_ore")
    public static final Block amethyst_ore = null;
    @ObjectHolder("ruby_ore")
    public static final Block ruby_ore = null;
    @ObjectHolder("sapphire_ore")
    public static final Block sapphire_ore = null;
    @ObjectHolder("platinum_ore")
    public static final Block platinum_ore = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> e) {
        AdvancementMod.LOGGER.info("[Advancement Mod] Registering Blocks");

        register(e, new BlockMod("amethyst_ore", Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().harvestLevel(IRON_HARV).harvestTool(ToolType.PICKAXE).strength(2.0F, 2000.0f).sound(SoundType.METAL)));
        register(e, new BlockMod("ruby_ore", Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().harvestLevel(IRON_HARV).harvestTool(ToolType.PICKAXE).strength(2.0F, 2000.0f).sound(SoundType.METAL)));
        register(e, new BlockMod("sapphire_ore", Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().harvestLevel(IRON_HARV).harvestTool(ToolType.PICKAXE).strength(2.0F, 2000.0f).sound(SoundType.METAL)));
        register(e, new BlockMod("platinum_ore", Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().harvestLevel(IRON_HARV).harvestTool(ToolType.PICKAXE).strength(3.0F, 2000.0f).sound(SoundType.METAL)));
    }

    private static void register(RegistryEvent.Register<Block> event, Block block) {
        event.getRegistry().register(block);
        blocks.add(block);
    }

    @SubscribeEvent
    public static void registerBlocksAsItems(final RegistryEvent.Register<Item> registry) {
        Item.Properties properties = new Item.Properties().tab(AdvancementMod.ADVANCEMENT_TAB);
        for (Block block : blocks) {
            Item itemBlock = new BlockItem(block, properties).setRegistryName(block.getRegistryName());
            blockItems.add(itemBlock);
            registry.getRegistry().register(itemBlock);
        }
    }
}
