package teamrtg.rtg.modules.bop.biomes;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import teamrtg.rtg.api.util.BiomeUtils;
import teamrtg.rtg.api.world.RTGWorld;
import teamrtg.rtg.api.world.biome.TerrainBase;
import teamrtg.rtg.api.world.biome.deco.DecoBaseBiomeDecorations;
import teamrtg.rtg.api.world.biome.surface.part.CliffSelector;
import teamrtg.rtg.api.world.biome.surface.part.SurfacePart;
import teamrtg.rtg.modules.vanilla.RTGBiomeVanilla;

public class RTGBiomeBOPOrchard extends RTGBiomeVanilla {
    public static Biome standardBiome = Biomes.PLAINS;
    public static Biome mutationBiome = Biome.getBiome(BiomeUtils.getId(standardBiome) + MUTATION_ADDEND);

    public RTGBiomeBOPOrchard() {
        super(
                mutationBiome,
            Biomes.RIVER
        );
    }

    @Override
    public TerrainBase initTerrain() {
        return new TerrainBase() {

            private float minHeight = 58f;
            private float maxHeight = 67f;
            private float hillStrength = 25f;

            {
                this.minHeight = minHeight;
                this.maxHeight = (maxHeight > rollingHillsMaxHeight) ? rollingHillsMaxHeight : ((maxHeight < this.minHeight) ? rollingHillsMaxHeight : maxHeight);
                this.hillStrength = hillStrength;
            }

            @Override
            public float generateNoise(RTGWorld rtgWorld, int x, int y, float biomeWeight, float border, float river) {
                return terrainRollingHills(x, y, rtgWorld.simplex, river, hillStrength, maxHeight, groundNoise, groundNoiseAmplitudeHills, 4f);
            }
        };
    }

    @Override
    public SurfacePart initSurface() {
        SurfacePart surface = new SurfacePart();
        surface.add(new CliffSelector(1.5f)
            .add(PARTS.STONE_OR_COBBLE));
        surface.add(PARTS.surfaceGeneric());
        return surface;
    }

    @Override
    public void initDecos() {
		DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
		this.addDeco(decoBaseBiomeDecorations);
    }

    @Override
    public void initConfig() {

    }
}
