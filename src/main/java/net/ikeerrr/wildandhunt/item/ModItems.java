package net.ikeerrr.wildandhunt.item;

import net.ikeerrr.wildandhunt.wildandhunt;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, wildandhunt.MOD_ID);

    public static final RegistryObject<Item> STRAWBERRY =ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));

    public static final RegistryObject<Item> DIRTY_STONE =ITEMS.register("dirty_stone",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIRTY_BRICK =ITEMS.register("dirty_brick",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
