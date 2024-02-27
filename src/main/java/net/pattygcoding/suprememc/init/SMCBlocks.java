package net.pattygcoding.suprememc.init;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pattygcoding.suprememc.SupremeMC;
import net.pattygcoding.suprememc.blocks.BookshelfBlockSMC;
import net.pattygcoding.suprememc.blocks.SlimeBlockSMC;
import net.pattygcoding.suprememc.blocks.freezer.FreezerBlockSMC;

import java.util.function.Supplier;

public class SMCBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SupremeMC.MOD_ID);

    public static final RegistryObject<Block> AQUAMARINE_BLOCK = registerBlock("aquamarine_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BURNING_DIAMOND_BLOCK = registerBlock("burning_diamond_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.METAL)));
    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.METAL)));
    public static final RegistryObject<Block> COBBLED_ANDESITE = registerBlock("cobbled_andesite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COBBLED_DIORITE = registerBlock("cobbled_diorite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COBBLED_GRANITE = registerBlock("cobbled_granite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ANDESITE_BRICKS = registerBlock("andesite_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));
    public static final RegistryObject<Block> DIORITE_BRICKS = registerBlock("diorite_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));
    public static final RegistryObject<Block> GRANITE_BRICKS = registerBlock("granite_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SALT_BLOCK = registerBlock("salt_block",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.SAND).sound(SoundType.SAND)));
    public static final RegistryObject<Block> SALT_STONE = registerBlock("salt_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> AQUAMARINE_ORE = registerBlock("aquamarine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).sound(SoundType.STONE), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_AQUAMARINE_ORE = registerBlock("deepslate_aquamarine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE).sound(SoundType.DEEPSLATE), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> EXPERIENCE_ORE = registerBlock("experience_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.STONE), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_EXPERIENCE_ORE = registerBlock("deepslate_experience_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.DEEPSLATE), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> QUARTZ_ORE = registerBlock("quartz_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.STONE), UniformInt.of(1, 5)));
    public static final RegistryObject<Block> DEEPSLATE_QUARTZ_ORE = registerBlock("deepslate_quartz_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.DEEPSLATE), UniformInt.of(1, 5)));
    public static final RegistryObject<Block> PRISMARINE_ORE = registerBlock("prismarine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.STONE), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> DEEPSLATE_PRISMARINE_ORE = registerBlock("deepslate_prismarine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.DEEPSLATE), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> SALT_ORE = registerBlock("salt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.STONE), UniformInt.of(0, 2)));
    public static final RegistryObject<Block> DEEPSLATE_SALT_ORE = registerBlock("deepslate_salt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.DEEPSLATE), UniformInt.of(0, 2)));

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).sound(SoundType.STONE), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE).sound(SoundType.DEEPSLATE), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> BURNING_DIAMOND_ORE = registerBlock("burning_diamond_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE).sound(SoundType.NETHER_GOLD_ORE), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> LOGO_BLOCK = registerBlock("logo_block",
                    () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> FREEZER = registerBlock("freezer",
            () -> new FreezerBlockSMC(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL)));
    public static final RegistryObject<Block> SPRUCE_BOOKSHELF = registerBlock("spruce_bookshelf",
            () -> new BookshelfBlockSMC(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BIRCH_BOOKSHELF = registerBlock("birch_bookshelf",
            () -> new BookshelfBlockSMC(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> JUNGLE_BOOKSHELF = registerBlock("jungle_bookshelf",
            () -> new BookshelfBlockSMC(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ACACIA_BOOKSHELF = registerBlock("acacia_bookshelf",
            () -> new BookshelfBlockSMC(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_OAK_BOOKSHELF = registerBlock("dark_oak_bookshelf",
            () -> new BookshelfBlockSMC(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CRIMSON_BOOKSHELF = registerBlock("crimson_bookshelf",
            () -> new BookshelfBlockSMC(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WARPED_BOOKSHELF = registerBlock("warped_bookshelf",
            () -> new BookshelfBlockSMC(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MANGROVE_BOOKSHELF = registerBlock("mangrove_bookshelf",
            () -> new BookshelfBlockSMC(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BAMBOO_BOOKSHELF = registerBlock("bamboo_bookshelf",
            () -> new BookshelfBlockSMC(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CHERRY_BOOKSHELF = registerBlock("cherry_bookshelf",
            () -> new BookshelfBlockSMC(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WHITE_GLOWBLOCK = registerBlock("white_glowblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.GLASS)
                    .lightLevel((x) -> 15).mapColor(DyeColor.WHITE)));
    public static final RegistryObject<Block> ORANGE_GLOWBLOCK = registerBlock("orange_glowblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.GLASS)
                    .lightLevel((x) -> 15).mapColor(DyeColor.ORANGE)));
    public static final RegistryObject<Block> MAGENTA_GLOWBLOCK = registerBlock("magenta_glowblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.GLASS)
                    .lightLevel((x) -> 15).mapColor(DyeColor.MAGENTA)));
    public static final RegistryObject<Block> LIGHT_BLUE_GLOWBLOCK = registerBlock("light_blue_glowblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.GLASS)
                    .lightLevel((x) -> 15).mapColor(DyeColor.LIGHT_BLUE)));
    public static final RegistryObject<Block> YELLOW_GLOWBLOCK = registerBlock("yellow_glowblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.GLASS)
                    .lightLevel((x) -> 15).mapColor(DyeColor.YELLOW)));
    public static final RegistryObject<Block> LIME_GLOWBLOCK = registerBlock("lime_glowblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.GLASS)
                    .lightLevel((x) -> 15).mapColor(DyeColor.LIME)));
    public static final RegistryObject<Block> PINK_GLOWBLOCK = registerBlock("pink_glowblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.GLASS)
                    .lightLevel((x) -> 15).mapColor(DyeColor.PINK)));
    public static final RegistryObject<Block> GRAY_GLOWBLOCK = registerBlock("gray_glowblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.GLASS)
                    .lightLevel((x) -> 15).mapColor(DyeColor.GRAY)));
    public static final RegistryObject<Block> LIGHT_GRAY_GLOWBLOCK = registerBlock("light_gray_glowblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.GLASS)
                    .lightLevel((x) -> 15).mapColor(DyeColor.LIGHT_GRAY)));
    public static final RegistryObject<Block> CYAN_GLOWBLOCK = registerBlock("cyan_glowblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.GLASS)
                    .lightLevel((x) -> 15).mapColor(DyeColor.CYAN)));
    public static final RegistryObject<Block> PURPLE_GLOWBLOCK = registerBlock("purple_glowblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.GLASS)
                    .lightLevel((x) -> 15).mapColor(DyeColor.PURPLE)));
    public static final RegistryObject<Block> BLUE_GLOWBLOCK = registerBlock("blue_glowblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.GLASS)
                    .lightLevel((x) -> 15).mapColor(DyeColor.BLUE)));
    public static final RegistryObject<Block> BROWN_GLOWBLOCK = registerBlock("brown_glowblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.GLASS)
                    .lightLevel((x) -> 15).mapColor(DyeColor.BROWN)));
    public static final RegistryObject<Block> GREEN_GLOWBLOCK = registerBlock("green_glowblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.GLASS)
                    .lightLevel((x) -> 15).mapColor(DyeColor.GREEN)));
    public static final RegistryObject<Block> RED_GLOWBLOCK = registerBlock("red_glowblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.GLASS)
                    .lightLevel((x) -> 15).mapColor(DyeColor.RED)));
    public static final RegistryObject<Block> BLACK_GLOWBLOCK = registerBlock("black_glowblock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.GLASS)
                    .lightLevel((x) -> 15).mapColor(DyeColor.BLACK)));
    public static final RegistryObject<Block> WHITE_SLIME_BLOCK = registerBlock("white_slime_block",
            () -> new SlimeBlockSMC(DyeColor.WHITE));
    public static final RegistryObject<Block> ORANGE_SLIME_BLOCK = registerBlock("orange_slime_block",
            () -> new SlimeBlockSMC(DyeColor.ORANGE));
    public static final RegistryObject<Block> MAGENTA_SLIME_BLOCK = registerBlock("magenta_slime_block",
            () -> new SlimeBlockSMC(DyeColor.MAGENTA));
    public static final RegistryObject<Block> LIGHT_BLUE_SLIME_BLOCK = registerBlock("light_blue_slime_block",
            () -> new SlimeBlockSMC(DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> YELLOW_SLIME_BLOCK = registerBlock("yellow_slime_block",
            () -> new SlimeBlockSMC(DyeColor.YELLOW));
    public static final RegistryObject<Block> LIME_SLIME_BLOCK = registerBlock("lime_slime_block",
            () -> new SlimeBlockSMC(DyeColor.LIME));
    public static final RegistryObject<Block> PINK_SLIME_BLOCK = registerBlock("pink_slime_block",
            () -> new SlimeBlockSMC(DyeColor.PINK));
    public static final RegistryObject<Block> GRAY_SLIME_BLOCK = registerBlock("gray_slime_block",
            () -> new SlimeBlockSMC(DyeColor.GRAY));
    public static final RegistryObject<Block> LIGHT_GRAY_SLIME_BLOCK = registerBlock("light_gray_slime_block",
            () -> new SlimeBlockSMC(DyeColor.LIGHT_GRAY));
    public static final RegistryObject<Block> CYAN_SLIME_BLOCK = registerBlock("cyan_slime_block",
            () -> new SlimeBlockSMC(DyeColor.CYAN));
    public static final RegistryObject<Block> PURPLE_SLIME_BLOCK = registerBlock("purple_slime_block",
            () -> new SlimeBlockSMC(DyeColor.PURPLE));
    public static final RegistryObject<Block> BLUE_SLIME_BLOCK = registerBlock("blue_slime_block",
            () -> new SlimeBlockSMC(DyeColor.BLUE));
    public static final RegistryObject<Block> BROWN_SLIME_BLOCK = registerBlock("brown_slime_block",
            () -> new SlimeBlockSMC(DyeColor.BROWN));
    public static final RegistryObject<Block> GREEN_SLIME_BLOCK = registerBlock("green_slime_block",
            () -> new SlimeBlockSMC(DyeColor.GREEN));
    public static final RegistryObject<Block> RED_SLIME_BLOCK = registerBlock("red_slime_block",
            () -> new SlimeBlockSMC(DyeColor.RED));
    public static final RegistryObject<Block> BLACK_SLIME_BLOCK = registerBlock("black_slime_block",
            () -> new SlimeBlockSMC(DyeColor.BLACK));
    public static final RegistryObject<Block> COBBLED_ANDESITE_STAIRS = registerBlock("cobbled_andesite_stairs",
            () -> new StairBlock(() -> SMCBlocks.COBBLED_ANDESITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> STONE_WALL = registerBlock("stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SMOOTH_STONE_STAIRS = registerBlock("smooth_stone_stairs",
            () -> new StairBlock(Blocks.SMOOTH_STONE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SMOOTH_STONE_WALL = registerBlock("smooth_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.NETHERRACK)));
    public static final RegistryObject<Block> NETHERRACK_STAIRS = registerBlock("netherrack_stairs",
            () -> new StairBlock(Blocks.NETHERRACK::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.NETHERRACK).sound(SoundType.NETHERRACK)));
    public static final RegistryObject<Block> NETHERRACK_SLAB = registerBlock("netherrack_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).sound(SoundType.NETHERRACK)));
    public static final RegistryObject<Block> NETHERRACK_WALL = registerBlock("netherrack_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).sound(SoundType.NETHERRACK)));
    public static final RegistryObject<Block> END_STONE_STAIRS = registerBlock("end_stone_stairs",
            () -> new StairBlock(Blocks.END_STONE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> END_STONE_SLAB = registerBlock("end_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> END_STONE_WALL = registerBlock("end_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> POLISHED_ANDESITE_WALL = registerBlock("polished_andesite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> POLISHED_DIORITE_WALL = registerBlock("polished_diorite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DIORITE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> POLISHED_GRANITE_WALL = registerBlock("polished_granite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_GRANITE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COBBLED_ANDESITE_SLAB = registerBlock("cobbled_andesite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COBBLED_ANDESITE_WALL = registerBlock("cobbled_andesite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COBBLED_DIORITE_STAIRS = registerBlock("cobbled_diorite_stairs",
            () -> new StairBlock(() -> SMCBlocks.COBBLED_DIORITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COBBLED_DIORITE_SLAB = registerBlock("cobbled_diorite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COBBLED_DIORITE_WALL = registerBlock("cobbled_diorite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COBBLED_GRANITE_STAIRS = registerBlock("cobbled_granite_stairs",
            () -> new StairBlock(() -> SMCBlocks.COBBLED_GRANITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COBBLED_GRANITE_SLAB = registerBlock("cobbled_granite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COBBLED_GRANITE_WALL = registerBlock("cobbled_granite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ANDESITE_BRICK_STAIRS = registerBlock("andesite_brick_stairs",
            () -> new StairBlock(() -> SMCBlocks.ANDESITE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ANDESITE_BRICK_SLAB = registerBlock("andesite_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ANDESITE_BRICK_WALL = registerBlock("andesite_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));
    public static final RegistryObject<Block> DIORITE_BRICK_STAIRS = registerBlock("diorite_brick_stairs",
            () -> new StairBlock(() -> SMCBlocks.DIORITE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));
    public static final RegistryObject<Block> DIORITE_BRICK_SLAB = registerBlock("diorite_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));
    public static final RegistryObject<Block> DIORITE_BRICK_WALL = registerBlock("diorite_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));
    public static final RegistryObject<Block> GRANITE_BRICK_STAIRS = registerBlock("granite_brick_stairs",
            () -> new StairBlock(() -> SMCBlocks.GRANITE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));
    public static final RegistryObject<Block> GRANITE_BRICK_SLAB = registerBlock("granite_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));
    public static final RegistryObject<Block> GRANITE_BRICK_WALL = registerBlock("granite_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return SMCItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
