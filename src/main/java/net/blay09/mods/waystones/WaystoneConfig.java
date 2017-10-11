package net.blay09.mods.waystones;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.common.config.Config;

@Config(modid = Waystones.MOD_ID, type = Config.Type.INSTANCE, name = "Waystones", category = "")
@Config.LangKey("waystones.config")
public class WaystoneConfig {

	public static General general = new General();
	public static WorldGen worldGen = new WorldGen();

	public static Client client = new Client();

	public static class General {

		@Config.Name("Teleport Button in GUI")
		@Config.Comment("Should there be a button in the inventory to access the waystone menu?")
		public boolean teleportButton = false;

		@Config.Name("Teleport Button Cooldown")
		@Config.Comment("The cooldown between usages of the teleport button in seconds.")
		public int teleportButtonCooldown = 300;

		@Config.Name("Teleport Button Return Only")
		@Config.Comment("If enabled, the teleport button will only let you return to the last activated waystone, instead of allowing to choose.")
		public boolean teleportButtonReturnOnly = true;

		@Config.Name("Blocks per XP Level")
		@Config.Comment("The amount of blocks per xp level requirement (for inventory button & waystone-to-waystone teleport). Set to 0 to disable xp requirement.")
		public int blocksPerXPLevel = 500;

		@Config.Name("Maximum XP Cost")
		@Config.Comment("The maximum xp cost when Blocks per XP Level is enabled.")
		@Config.RangeInt(min = 1)
		public int maximumXpCost = 3;

		@Config.Name("Warp Stone Costs XP")
		@Config.Comment("If enabled, the warp stone costs experience when used as well. THIS IS FOR THE WARP STONE, NOT WAYSTONES. See blocksPerXPLevel for those.")
		public boolean warpStoneXpCost = false;

		@Config.Name("Warp Stone Cooldown")
		@Config.Comment("The cooldown between usages of the warp stone in seconds.")
		public int warpStoneCooldown = 300;

		@Config.Name("Interdimensional Teleport")
		@Config.Comment("If enabled, all waystones work inter-dimensionally.")
		public boolean interDimension = true;

		@Config.Name("Restrict Rename to Owner")
		@Config.Comment("If enabled, only the owner of a waystone can rename it.")
		public boolean restrictRenameToOwner = false;

		@Config.Name("Creative Mode Only")
		@Config.Comment("If enabled, waystones can only be placed in creative mode.")
		public boolean creativeModeOnly;

		@Config.Name("Set Spawnpoint on Activation")
		@Config.Comment("If enabled, the player's spawnpoint will be set to the last activated waystone.")
		public boolean setSpawnPoint = false;

		@Config.Name("No Cooldown on Global Waystones")
		@Config.Comment("If enabled, waystones marked as global have no cooldown.")
		public boolean globalNoCooldown = true;

		@Config.Name("Interdimensional Teleport on Global Waystones")
		@Config.Comment("If enabled, waystones marked as global work inter-dimensionally.")
		public boolean globalInterDimension = true;

		@Config.Name("Allow Global Waystones for Everyone")
		@Config.Comment("If enabled, everyone can create global waystones, not just players in creative mode.")
		public boolean allowEveryoneGlobal = false;
	}

	public static class WorldGen {
		@Config.Name("Generate in Villages")
		@Config.Comment("The chance for a waystone to generate in a village. Set to 1 to always generate one in villages, set to 0 to disable.")
		@Config.RangeDouble(min = 0, max = 1)
		public float villageChance = 1f;
	}

	public static class Client {
		@Config.Name("Sound Volume")
		@Config.Comment("The volume of the sound played when teleporting.")
		@Config.RangeDouble(min = 0f, max = 1f)
		public float soundVolume = 0.5f;

		@Config.Name("Teleport Button GUI X")
		@Config.Comment("The x position of the warp button in the inventory.")
		public int teleportButtonX = 58;

		@Config.Name("Teleport Button GUI Y")
		@Config.Comment("The y position of the warp button in the inventory.")
		public int teleportButtonY = 60;

		@Config.Name("Disable Particles")
		@Config.Comment("If enabled, activated waystones will not emit particles.")
		public boolean disableParticles = false;

		@Config.Name("Disable Text Glow")
		@Config.Comment("If enabled, the text overlay on waystones will no longer always render at full brightness.")
		public boolean disableTextGlow = false;
	}

	public static void read(ByteBuf buf) {
		general.teleportButton = buf.readBoolean();
		general.teleportButtonCooldown = buf.readInt();
		general.teleportButtonReturnOnly = buf.readBoolean();
		general.warpStoneCooldown = buf.readInt();
		general.interDimension = buf.readBoolean();
		general.creativeModeOnly = buf.readBoolean();
		general.setSpawnPoint = buf.readBoolean();
		general.restrictRenameToOwner = buf.readBoolean();
		general.blocksPerXPLevel = buf.readInt();
		general.maximumXpCost = buf.readInt();
	}

	public static void write(ByteBuf buf) {
		buf.writeBoolean(general.teleportButton);
		buf.writeInt(general.teleportButtonCooldown);
		buf.writeBoolean(general.teleportButtonReturnOnly);
		buf.writeInt(general.warpStoneCooldown);
		buf.writeBoolean(general.interDimension);
		buf.writeBoolean(general.creativeModeOnly);
		buf.writeBoolean(general.setSpawnPoint);
		buf.writeBoolean(general.restrictRenameToOwner);
		buf.writeInt(general.blocksPerXPLevel);
		buf.writeInt(general.maximumXpCost);
	}
}
