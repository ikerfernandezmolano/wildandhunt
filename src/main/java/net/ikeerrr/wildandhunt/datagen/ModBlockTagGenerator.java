package net.ikeerrr.wildandhunt.datagen;

import net.ikeerrr.wildandhunt.block.ModBlocks;
import net.ikeerrr.wildandhunt.wildandhunt;
import net.ikeerrr.wildandhunt.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper){
        super(output,lookupProvider, wildandhunt.MOD_ID,existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.DIRTY_BRICKS_BLOCK.get(),
                        ModBlocks.DIRTY_BRICKS_SLAB.get(),
                        ModBlocks.DIRTY_BRICKS_STAIRS.get(),
                        ModBlocks.DIRTY_BRICKS_WALL.get(),
                        ModBlocks.DIRTY_ROCK.get());

        this.tag(Tags.Blocks.NEEDS_WOOD_TOOL)
                .add(ModBlocks.DIRTY_BRICKS_BLOCK.get(),
                        ModBlocks.DIRTY_BRICKS_WALL.get(),
                        ModBlocks.DIRTY_BRICKS_STAIRS.get(),
                        ModBlocks.DIRTY_BRICKS_SLAB.get(),
                        ModBlocks.DIRTY_ROCK.get());

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.DIRTY_BRICKS_WALL.get());
    }
}
