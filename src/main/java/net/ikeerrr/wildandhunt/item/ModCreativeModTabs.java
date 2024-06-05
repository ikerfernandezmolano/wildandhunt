package net.ikeerrr.wildandhunt.item;

import net.ikeerrr.wildandhunt.block.ModBlocks;
import net.ikeerrr.wildandhunt.wildandhunt;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS=
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB,wildandhunt.MOD_ID);

    public static final RegistryObject<CreativeModeTab> WILDANDHUNT_TAB=CREATIVE_MODE_TABS.register("wildandhunt_tab",
            ()-> CreativeModeTab.builder().icon(()->new ItemStack(ModItems.STRAWBERRY.get()))
                    .title(Component.translatable("creativetab.wildandhunt"))
                    .displayItems((pParameters,pOutput)->{
                        pOutput.accept(ModItems.STRAWBERRY.get());
                        pOutput.accept(ModItems.DIRTY_STONE.get());
                        pOutput.accept(ModItems.DIRTY_BRICK.get());
                        pOutput.accept(ModBlocks.DIRTY_BRICKS_BLOCK.get());
                        pOutput.accept(ModBlocks.DIRTY_BRICKS_STAIRS.get());
                        pOutput.accept(ModBlocks.DIRTY_BRICKS_SLAB.get());
                        pOutput.accept(ModBlocks.DIRTY_BRICKS_WALL.get());
                        pOutput.accept(ModBlocks.DIRTY_ROCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
