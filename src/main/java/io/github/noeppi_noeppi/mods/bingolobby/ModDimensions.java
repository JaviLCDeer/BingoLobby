package io.github.noeppi_noeppi.mods.bingolobby;

import io.github.noeppi_noeppi.mods.bingolobby.dimension.BingoLobbyGenerator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;

public class ModDimensions {
   public static final ResourceKey<Level> LOBBY_DIMENSION;

   public static void init() {
      BingoLobby.getInstance().register(Registries.f_256783_, "lobby_generator", BingoLobbyGenerator.CODEC);
   }

   public static void teleportToLobby(ServerPlayer player, boolean yp) {
      player.m_150109_().m_6211_();
      if (player.m_9236_().m_46472_().equals(LOBBY_DIMENSION)) {
         player.m_6021_(582.5D, 117.0D, 1315.5D);
         player.m_7678_(582.5D, 117.0D, 1315.5D, 0.0F, 0.0F);
      } else {
         ServerLevel destination = player.m_284548_().m_7654_().m_129880_(LOBBY_DIMENSION);
         if (destination == null) {
            player.f_8906_.m_9942_(Component.m_237113_("BingoLobby failed to load. Please restart server."));
         } else {
            float yRot = yp ? 0.0F : player.m_146908_();
            float xRot = yp ? 0.0F : player.m_146909_();
            player.m_8999_(destination, 582.5D, 117.0D, 1315.5D, yRot, xRot);
         }
      }

      player.m_9158_(LOBBY_DIMENSION, new BlockPos(582, 117, 1315), 0.0F, true, false);
   }

   static {
      LOBBY_DIMENSION = ResourceKey.m_135785_(Registries.f_256858_, new ResourceLocation(BingoLobby.getInstance().modid, "lobby"));
   }
}
