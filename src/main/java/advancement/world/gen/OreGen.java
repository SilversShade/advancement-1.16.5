package advancement.world.gen;

import advancement.registries.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGen {
    public static final RuleTest END_STONE_FILLER = new BlockMatchRuleTest(Blocks.END_STONE);

    public static void generateOres(final BiomeLoadingEvent event) {
        if (event.getCategory().equals(Biome.Category.THEEND)) {
            oreGen(event.getGeneration(), END_STONE_FILLER, BlockRegistry.celestial_ore.defaultBlockState(), 3, 5, 80, 40);
        }
        else if (event.getCategory().equals(Biome.Category.NETHER)) {

        }
        else {
            oreGen(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                    BlockRegistry.amethyst_ore.defaultBlockState(), 3, 10, 35, 6);
            oreGen(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                    BlockRegistry.ruby_ore.defaultBlockState(), 3, 10, 35, 6);
            oreGen(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                    BlockRegistry.sapphire_ore.defaultBlockState(), 3, 10, 35, 6);
            oreGen(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                    BlockRegistry.platinum_ore.defaultBlockState(), 3, 5, 20, 5);
        }
    }

    private static void oreGen (BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state,
                                int veinSize, int minHeight, int maxHeight, int amount) {
        settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(new OreFeatureConfig(fillerType, state, veinSize))
                        .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
                        .squared().count(amount));
    }
}
