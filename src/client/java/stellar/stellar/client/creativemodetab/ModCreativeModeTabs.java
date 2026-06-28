package stellar.stellar.client.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import stellar.stellar.Stellar;
import stellar.stellar.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;


public class ModCreativeModeTabs {
    public static final CreativeModeTab STELLAR_ITEMS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(Stellar.MOD_ID, "stellar_items"), FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LEMON)).title(Component.translatable("creativemodetab.stellar.stellar_items")).displayItems((parameters, output) -> {
        output.accept(ModItems.LEMON);
    }).build());

    public static void registerCreativeModeTabs() {
        System.out.println("Registering Creative Mode Tabs for " + Stellar.MOD_ID);
    }
}
