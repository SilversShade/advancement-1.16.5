package advancement.registries;

import advancement.AdvancementMod;
import advancement.items.*;
import advancement.util.AdvancementTools;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = AdvancementMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(AdvancementMod.MOD_ID)
public class ItemRegistry {

    //overworld ore
    @ObjectHolder("amethyst")
    public static final Item amethyst = null;
    @ObjectHolder("ruby")
    public static final Item ruby = null;
    @ObjectHolder("sapphire")
    public static final Item sapphire = null;
    @ObjectHolder("platinum_ingot")
    public static final Item platinum_ingot = null;

    //end ore
    @ObjectHolder("celestial_crystal")
    public static final Item celestial_crystal = null;

    //three-crystal items
    @ObjectHolder("three_crystal_pickaxe")
    public static final Item three_crystal_pickaxe = null;
    @ObjectHolder("three_crystal_sword")
    public static final Item three_crystal_sword = null;
    @ObjectHolder("three_crystal_axe")
    public static final Item three_crystal_axe = null;
    @ObjectHolder("three_crystal_shovel")
    public static final Item three_crystal_shovel = null;
    @ObjectHolder("three_crystal_hoe")
    public static final Item three_crystal_hoe = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> e) {
        AdvancementMod.LOGGER.info("[Advancement Mod] Registering Items");

        register(e, new ItemMod("amethyst"));
        register(e, new ItemMod("ruby"));
        register(e, new ItemMod("platinum_ingot"));
        register(e, new ItemMod("sapphire"));
        register(e, new ItemMod("celestial_crystal"));
        register(e, new ItemModPickaxe(AdvancementTools.THREE_CRYSTAL_PICKAXE, "three_crystal_pickaxe", -1.4f));
        register(e, new ItemModSword(AdvancementTools.THREE_CRYSTAL_SWORD, "three_crystal_sword", 1.6f));
        register(e, new ItemModAxe(AdvancementTools.THREE_CRYSTAL_AXE, "three_crystal_axe", -2.3f));
        register(e, new ItemModShovel(AdvancementTools.THREE_CRYSTAL_SHOVEL, "three_crystal_shovel", -1.2f));
        register(e, new ItemModHoe(AdvancementTools.THREE_CRYSTAL_PICKAXE, "three_crystal_hoe", -0.6f));
    }

    private static void register(RegistryEvent.Register<Item> event, Item item) {
        event.getRegistry().register(item);
    }
}
