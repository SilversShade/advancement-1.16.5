package advancement.registries;

import advancement.AdvancementMod;
import advancement.items.ItemMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = AdvancementMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(AdvancementMod.MOD_ID)
public class ItemRegistry {

    //overworld ore
    @ObjectHolder("amethyst")
    public static final Item amethyst = null;
    @ObjectHolder("platinum_ingot")
    public static final Item platinum_ingot = null;
    @ObjectHolder("ruby")
    public static final Item ruby = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> e) {
        AdvancementMod.LOGGER.info("[Advancement Mod] Registering Items");

        register(e, new ItemMod("amethyst"));
        register(e, new ItemMod("ruby"));
        register(e, new ItemMod("platinum_ingot"));
    }

    private static void register(RegistryEvent.Register<Item> event, Item item) {
        event.getRegistry().register(item);
    }
}
