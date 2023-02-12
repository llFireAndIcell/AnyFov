package me.fireandice.anyfov

import net.minecraftforge.client.ClientCommandHandler
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(
    modid = AnyFov.MODID,
    name = AnyFov.NAME,
    version = AnyFov.VERSION,
    modLanguageAdapter = "cc.polyfrost.oneconfig.utils.KotlinLanguageAdapter"
)
object AnyFov {

    const val MODID = "@ID@"
    const val NAME = "@NAME@"
    const val VERSION = "@VER@"

    @EventHandler
    fun onInit(event: FMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(this)
        ClientCommandHandler.instance.registerCommand(ChangeFovCommand)
    }
}