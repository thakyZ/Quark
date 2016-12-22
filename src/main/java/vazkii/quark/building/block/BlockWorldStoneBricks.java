/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 *
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 *
 * File Created @ [20/03/2016, 19:58:13 (GMT)]
 */
package vazkii.quark.building.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import vazkii.arl.block.BlockMetaVariants;
import vazkii.quark.base.block.IQuarkBlock;
import vazkii.quark.base.module.Feature;
import vazkii.quark.base.module.ModuleLoader;
import vazkii.quark.building.feature.WorldStoneBricks;
import vazkii.quark.world.feature.Basalt;
import vazkii.quark.world.feature.RevampStoneGen;

public class BlockWorldStoneBricks extends BlockMetaVariants implements IQuarkBlock {

	public BlockWorldStoneBricks() {
		super("world_stone_bricks", Material.ROCK, Variants.class);
		setHardness(1.5F);
		setResistance(10.0F);
		setSoundType(SoundType.STONE);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	@Override
	public boolean shouldDisplayVariant(int variant) {
		return Variants.class.getEnumConstants()[variant].isEnabled();
	}

	public enum Variants implements EnumBase {
		
		STONE_GRANITE_BRICKS(WorldStoneBricks.class),
		STONE_DIORITE_BRICKS(WorldStoneBricks.class),
		STONE_ANDESITE_BRICKS(WorldStoneBricks.class),
		STONE_BASALT_BRICKS(Basalt.class),
		STONE_MARBLE_BRICKS(RevampStoneGen.class),
		STONE_LIMESTONE_BRICKS(RevampStoneGen.class);
		
		private Variants(Class<? extends Feature> clazz) {
			featureLink = clazz;
		}
		
		public final Class<? extends Feature> featureLink;

		public boolean isEnabled() {
			return ModuleLoader.isFeatureEnabled(featureLink);
		}
		
	}

}
