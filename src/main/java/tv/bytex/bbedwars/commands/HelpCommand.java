package tv.bytex.bbedwars.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Hier fügst du den Code hinzu, der beim Ausführen des Befehls ausgeführt werden soll
        // Zum Beispiel könntest du eine Liste von Hilfetexten anzeigen
        sender.sendMessage("Willkommen zur Hilfe!");
        sender.sendMessage("/command1 - Beschreibung von Befehl 1");
        sender.sendMessage("/command2 - Beschreibung von Befehl 2");
        // ...
        return true;
    }
}
