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

public class RTGBiomeBOPAlps extends RTGBiomeVanilla {
    public static Biome standardBiome = Biomes.PLAINS;
    public static Biome mutationBiome = Biome.getBiome(BiomeUtils.getId(standardBiome) + MUTATION_ADDEND);

    public RTGBiomeBOPAlps() {
        super(
                mutationBiome,
            Biomes.RIVER
        );
    }

    @Override
    public TerrainBase initTerrain() {
        return new TerrainBase(120f) {

            // the BoP version has steep slopes and a flat area on top. The RTG version will
            private float start = 0f;// this puts a minimum on "ruggedness" on the top. We want to allow flats
            private float height = 40f; // sets the variability range
            private float width = 80f; // width of irregularity noise on top. We want low, for a lot of features.

            @Override
            public float generateNoise(RTGWorld rtgWorld, int x, int y, float biomeWeight, float border, float river) {
                return terrainHighland(x, y, rtgWorld.simplex, rtgWorld.cell, river, start, width, height, base - 62f);
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
