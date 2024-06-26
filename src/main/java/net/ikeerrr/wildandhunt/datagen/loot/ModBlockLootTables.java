package net.ikeerrr.wildandhunt.datagen.loot;

import net.ikeerrr.wildandhunt.block.ModBlocks;
import net.ikeerrr.wildandhunt.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables(){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.DIRTY_BRICKS_BLOCK.get());
        this.dropSelf(ModBlocks.DIRTY_BRICKS_STAIRS.get());
        this.dropSelf(ModBlocks.DIRTY_BRICKS_WALL.get());

        this.add(ModBlocks.DIRTY_BRICKS_SLAB.get(),
                block-> createSlabItemTable(ModBlocks.DIRTY_BRICKS_SLAB.get()));

        this.add(ModBlocks.DIRTY_ROCK.get(),
                block-> createLikeOreDrops(ModBlocks.DIRTY_ROCK.get(),ModItems.DIRTY_STONE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    protected LootTable.Builder createLikeOreDrops(Block pBlock,Item pItem) {
        return createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(pItem)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
}
