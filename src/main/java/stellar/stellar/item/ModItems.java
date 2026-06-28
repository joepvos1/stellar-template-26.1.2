package stellar.stellar.item;

import java.util.function.Function;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import stellar.stellar.Stellar;
//import net.minecraft.component.DataComponents;


public class ModItems {
    public static final Item LEMON = registerItem("lemon_lemon", properties -> new Item(properties.food(new FoodProperties.Builder().nutrition(4).saturationModifier(2.4f).build())));

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
    return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Stellar.MOD_ID, name), function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Stellar.MOD_ID, name)))));
    }

    public static void registerModItems() {
        System.out.println("Registering Mod Items for " + stellar.stellar.Stellar.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(LEMON);
        });
    }
    
}
