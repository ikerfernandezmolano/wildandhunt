package net.ikeerrr.wildandhunt.datagen;

import net.ikeerrr.wildandhunt.wildandhunt;
import net.ikeerrr.wildandhunt.block.ModBlocks;
import net.ikeerrr.wildandhunt.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DIRTY_BRICKS_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.DIRTY_BRICK.get())
                .unlockedBy(getHasName(ModItems.DIRTY_BRICK.get()),has(ModItems.DIRTY_BRICK.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIRTY_BRICK.get())
                .pattern("   ")
                .pattern("## ")
                .pattern("## ")
                .define('#', ModItems.DIRTY_STONE.get())
                .unlockedBy(getHasName(ModItems.DIRTY_STONE.get()),has(ModItems.DIRTY_STONE.get()))
                .save(pRecipeOutput);
    }
}
