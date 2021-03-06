package rtg.world.biome.realistic.agriculturalrevolution;

import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

import rtg.api.biome.BiomeConfig;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.gen.surface.agriculturalrevolution.SurfaceARDeepReef;
import rtg.world.gen.terrain.agriculturalrevolution.TerrainARDeepReef;

public class RealisticBiomeARDeepReef extends RealisticBiomeARBase {

    public static Biome river = Biomes.RIVER;

    public RealisticBiomeARDeepReef(Biome biome, BiomeConfig config) {

        super(config, biome, river,
            new TerrainARDeepReef(),
            new SurfaceARDeepReef(config, Blocks.GRAVEL.getDefaultState(), Blocks.GRAVEL.getDefaultState(), Blocks.CLAY.getDefaultState(), 20f, 0.1f)
        );

        this.waterSurfaceLakeChance = 0;
        this.lavaSurfaceLakeChance = 0;
        this.noLakes = true;
        this.noWaterFeatures = true;

        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        this.addDeco(decoBaseBiomeDecorations);
    }
}
