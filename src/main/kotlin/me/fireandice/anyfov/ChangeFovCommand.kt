package me.fireandice.anyfov

import cc.polyfrost.oneconfig.libs.universal.ChatColor
import cc.polyfrost.oneconfig.libs.universal.UChat
import cc.polyfrost.oneconfig.libs.universal.UMinecraft
import net.minecraft.command.ICommandSender

object ChangeFovCommand : CommandWrapper("fov") {

    override fun processCommand(sender: ICommandSender?, args: Array<String>?) {
        var newFov: Float
        val min = 0.1f
        val max = 179.9f

        if (args != null) try {
            newFov = args[0].toFloat()
            if (newFov !in min..max) {
                UChat.chat("${ChatColor.RED}Forcing nearest value between $min and $max")
                newFov = newFov.coerceIn(min, max)
            }
            UMinecraft.getSettings().fovSetting = newFov
            UChat.chat("${ChatColor.GOLD}Setting fov to ${ChatColor.AQUA}$newFov")
        } catch (_: Exception) {
            UChat.chat(getCommandUsage(sender))
        }
        else UChat.chat(getCommandUsage(sender))
    }

    override fun getCommandUsage(sender: ICommandSender?): String = "${ChatColor.GOLD}${ChatColor.BOLD}Usage:${ChatColor.RESET}${ChatColor.GOLD} /$commandName <number>"
}