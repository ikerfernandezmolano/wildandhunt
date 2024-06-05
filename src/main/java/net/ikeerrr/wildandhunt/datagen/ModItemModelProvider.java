package net.ikeerrr.wildandhunt.datagen;

import net.ikeerrr.wildandhunt.block.ModBlocks;
import net.ikeerrr.wildandhunt.item.ModItems;
import net.ikeerrr.wildandhunt.wildandhunt;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper){
        super(output, wildandhunt.MOD_ID,existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.STRAWBERRY);
        simpleItem(ModItems.DIRTY_BRICK);
        simpleItem(ModItems.DIRTY_STONE);

        evenSimplerBlockItem(ModBlocks.DIRTY_ROCK);

        evenSimplerBlockItem(ModBlocks.DIRTY_BRICKS_STAIRS);
        evenSimplerBlockItem(ModBlocks.DIRTY_BRICKS_SLAB);
        wallItem(ModBlocks.DIRTY_BRICKS_WALL,ModBlocks.DIRTY_BRICKS_BLOCK);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(wildandhunt.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(wildandhunt.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(wildandhunt.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void wallItem(RegistryObject<Block> block,RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(wildandhunt.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}
