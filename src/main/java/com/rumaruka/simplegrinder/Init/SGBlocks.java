package com.rumaruka.simplegrinder.init;

import com.rumaruka.simplegrinder.ModSetup;
import com.rumaruka.simplegrinder.common.blocks.EnegyGrinderBlock;
import com.rumaruka.simplegrinder.common.blocks.GrinderBlock;
import com.rumaruka.simplegrinder.common.blocks.MachineCoreBlock;
import com.rumaruka.simplegrinder.common.container.GrinderContainer;
import com.rumaruka.simplegrinder.common.tiles.TileEntityAbstractGrinder;
import com.rumaruka.simplegrinder.common.tiles.TileEntityCoalGrinder;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.rumaruka.simplegrinder.SimpleGrinder.MODID;

public class SGBlocks {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> BLOCKITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MODID);
    private static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, MODID);


    public static void setup(){
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<GrinderBlock> COALGRINDERBLOCK = BLOCKS.register("coal_grinder", GrinderBlock::new);
    public static final RegistryObject<Item> GRINDERBLOCK_ITEM = BLOCKITEMS.register("coal_grinder", () -> new BlockItem(COALGRINDERBLOCK.get(), new Item.Properties().group(ModSetup.ITEM_GROUP)));

    public static final RegistryObject<EnegyGrinderBlock> ENERGYGRINDERBLOCK = BLOCKS.register("energy_grinder", EnegyGrinderBlock::new);
    public static final RegistryObject<Item> ENEGYGRINDERBLOCK_ITEM = BLOCKITEMS.register("energy_grinder", () -> new BlockItem(ENERGYGRINDERBLOCK.get(), new Item.Properties().group(ModSetup.ITEM_GROUP)));

    public static final RegistryObject<MachineCoreBlock> MACHINE_CORE = BLOCKS.register("machine_core", MachineCoreBlock::new);
    public static final RegistryObject<Item> MACHINE_CORE_ITEM = BLOCKITEMS.register("machine_core", () -> new BlockItem(MACHINE_CORE.get(), new Item.Properties().group(ModSetup.ITEM_GROUP)));

    public static final RegistryObject<TileEntityType<TileEntityCoalGrinder>> TILE_ENTITY_COAL_GRINDER = TILES.register("coal_grinder", () -> TileEntityType.Builder.create(TileEntityCoalGrinder::new, COALGRINDERBLOCK.get()).build(null));


    public static final RegistryObject<ContainerType<GrinderContainer>> GRINDER_CONTANER = CONTAINERS.register("coal_grinder", () -> IForgeContainerType.create((windowId, inv, data) -> {

        return new GrinderContainer(windowId, inv);
    }));
}
