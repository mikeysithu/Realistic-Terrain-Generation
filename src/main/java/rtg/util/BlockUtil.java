package rtg.util;

import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;

public class BlockUtil {

    public static IBlockState getStateSand(int meta) {

        switch (meta) {
            case 0:
                return Blocks.SAND.getDefaultState();
            case 1:
                return Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND);
            default:
                return Blocks.SAND.getDefaultState();
        }
    }

    public static IBlockState getStateClay(int meta) {
        switch (meta) {
            case 0:
                return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.WHITE);
            case 1:
                return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.ORANGE);
            case 2:
                return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.MAGENTA);
            case 3:
                return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.LIGHT_BLUE);
            case 4:
                return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.YELLOW);
            case 5:
                return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.LIME);
            case 6:
                return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.PINK);
            case 7:
                return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.GRAY);
            case 8:
                return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.SILVER);
            case 9:
                return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.CYAN);
            case 10:
                return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.PURPLE);
            case 11:
                return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.BLUE);
            case 12:
                return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.BROWN);
            case 13:
                return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.GREEN);
            case 14:
                return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.RED);
            case 15:
                return Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.BLACK);
            default:
                return Blocks.HARDENED_CLAY.getDefaultState();
        }
    }

    public static IBlockState getStateLog(int meta) {
        switch (meta) {
            case 0:
                return Blocks.LOG.getDefaultState();
            case 1:
                return Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
            case 2:
                return Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH);
            case 3:
                return Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
            default:
                return Blocks.LOG.getDefaultState();
        }
    }

    public static IBlockState getStateLeaf(int meta) {
        switch (meta) {
            case 0:
                return Blocks.LEAVES.getDefaultState();
            case 1:
                return Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE);
            case 2:
                return Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.BIRCH);
            case 3:
                return Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE);
            default:
                return Blocks.LEAVES.getDefaultState();
        }
    }

    public static IBlockState getStateLog2(int meta) {
        switch (meta) {
            case 0:
                return Blocks.LOG2.getDefaultState();
            case 1:
                return Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK);
            default:
                return Blocks.LOG2.getDefaultState();
        }
    }

    public static IBlockState getStateLeaf2(int meta) {
        switch (meta) {
            case 0:
                return Blocks.LEAVES2.getDefaultState();
            case 1:
                return Blocks.LEAVES2.getDefaultState().withProperty(BlockNewLeaf.VARIANT, BlockPlanks.EnumType.DARK_OAK);
            default:
                return Blocks.LEAVES2.getDefaultState();
        }
    }

    public static IBlockState getStateDirt(int meta) {
        switch(meta) {
            case 0:
                return Blocks.DIRT.getDefaultState();
            case 1:
                return Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
            case 2:
                return Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
            default:
                return Blocks.DIRT.getDefaultState();
        }
    }

    public static IBlockState getStateSapling (int meta) {
        switch (meta) {
            case 0:
                return Blocks.SAPLING.getDefaultState();
            case 1:
                return Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.SPRUCE);
            case 2:
                return Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.BIRCH);
            case 3:
                return Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.JUNGLE);
            case 4:
                return Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.ACACIA);
            case 5:
                return Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.DARK_OAK);
            default:
                return Blocks.SAPLING.getDefaultState();
        }
    }
}