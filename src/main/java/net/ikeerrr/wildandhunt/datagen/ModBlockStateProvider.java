package net.ikeerrr.wildandhunt.datagen;

import net.ikeerrr.wildandhunt.wildandhunt;
import net.ikeerrr.wildandhunt.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper){
        super(output,wildandhunt.MOD_ID,exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.DIRTY_BRICKS_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.DIRTY_BRICKS_STAIRS.get()), blockTexture(ModBlocks.DIRTY_BRICKS_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.DIRTY_BRICKS_SLAB.get()), blockTexture(ModBlocks.DIRTY_BRICKS_BLOCK.get()),blockTexture(ModBlocks.DIRTY_BRICKS_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.DIRTY_BRICKS_WALL.get()), blockTexture(ModBlocks.DIRTY_BRICKS_BLOCK.get()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }
}


