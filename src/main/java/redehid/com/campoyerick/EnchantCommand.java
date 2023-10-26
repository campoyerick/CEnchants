package redehid.com.campoyerick;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnchantCommand implements CommandExecutor {

    private final Main plugin; // Variável para armazenar a referência do plugin
    private final PlayerDataManager playerDataManager; // Variável para armazenar a referência do plugin

    public EnchantCommand(Main plugin, PlayerDataManager playerDataManager) {
        this.plugin = plugin; // Armazene a referência do plugin
        this.playerDataManager = playerDataManager; // Atribua o playerDataManager
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("encantamentos")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                // Agora você pode usar this.plugin para acessar o plugin
                new EnchantmentMenu(this.plugin, this.playerDataManager).abrirMenu(player);
            } else {
                sender.sendMessage("Este comando só pode ser usado por jogadores.");
            }
            return true;
        }
        return false;
    }
}

