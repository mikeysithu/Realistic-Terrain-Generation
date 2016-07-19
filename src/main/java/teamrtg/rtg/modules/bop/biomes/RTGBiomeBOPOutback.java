package teamrtg.rtg.modules.bop.biomes;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import teamrtg.rtg.api.tools.terrain.*;
import teamrtg.rtg.api.util.BiomeUtils;
import teamrtg.rtg.api.world.RTGWorld;
import teamrtg.rtg.api.world.biome.TerrainBase;
import teamrtg.rtg.api.world.biome.deco.DecoBaseBiomeDecorations;
import teamrtg.rtg.api.world.biome.surface.part.CliffSelector;
import teamrtg.rtg.api.world.biome.surface.part.SurfacePart;
import teamrtg.rtg.modules.vanilla.RTGBiomeVanilla;

public class RTGBiomeBOPOutback extends RTGBiomeVanilla {
    public static Biome standardBiome = Biomes.PLAINS;
    public static Biome mutationBiome = Biome.getBiome(BiomeUtils.getId(standardBiome) + MUTATION_ADDEND);

    public RTGBiomeBOPOutback() {
        super(
                mutationBiome,
            Biomes.RIVER
        );
    }

    @Override
    public TerrainBase initTerrain() {
        return new TerrainBase() {

            private float minHeight;
            private float mesaWavelength;
            private float hillStrength;
            private float topBumpinessHeight=4;
            private float topBumpinessWavelength = 25;
            private HeightEffect height;
            private HeightEffect groundEffect;

            {
                this.minHeight = 65f;
                this.mesaWavelength = 50f;
                this.hillStrength = 10f;

                groundEffect = new GroundEffect(4f);

                // this is variation in what's added to the top. Set to vary with the "standard" ruggedness
                HeightVariation topVariation = new HeightVariation();
                topVariation.height = hillStrength/2;
                topVariation.octave = 1;
                topVariation.wavelength = VariableRuggednessEffect.STANDARD_RUGGEDNESS_WAVELENGTH;


                // create some bumpiness to disguise the cliff heights
                HeightVariation topBumpiness = new HeightVariation();
                topBumpiness.height = topBumpinessHeight;
                topBumpiness.wavelength = topBumpinessWavelength;
                topBumpiness.octave = 3;


                // now make the top only show up on mesa
                HeightEffect mesaTops = new VariableRuggednessEffect(new RaiseEffect(0f),topVariation.plus(new RaiseEffect(hillStrength)).plus(topBumpiness)
                        ,0.3f,0.15f,mesaWavelength);

                // and make the mesa Tops only show up part of the time, but most of the time,
                // using the standard ruggedness wavelength
                height = new VariableRuggednessEffect(new RaiseEffect(0f),mesaTops,-0.3f,.06f);

            }

            @Override
            public float generateNoise(RTGWorld rtgWorld, int x, int y, float biomeWeight, float border, float river) {
                return riverized(minHeight+groundEffect.added(rtgWorld.simplex, rtgWorld.cell,x, y),river)+height.added(rtgWorld.simplex,rtgWorld.cell, x, y);
                //return terrainRollingHills(x, y, simplex, river, hillStrength, maxHeight, groundNoise, groundNoiseAmplitudeHills, 4f);
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
