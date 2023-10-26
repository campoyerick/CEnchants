package redehid.com.campoyerick;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
public final class Main extends JavaPlugin {
    private Economy economy; // Declaração da instância do Vault Economy
    private PlayerDataManager playerDataManager;
    @Override
    public void onEnable() {
        playerDataManager = new PlayerDataManager(getDataFolder());
        if (!setupEconomy()) {
            getLogger().severe("Vault or an Economy plugin is not present!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getCommand("encantamentos").setExecutor(new EnchantCommand(this, playerDataManager));
        getServer().getPluginManager().registerEvents(new EnchantmentMenu(this, playerDataManager), this);
        getServer().getPluginManager().registerEvents(new EnchantEvents(), this);
    }

    @Override
    public void onDisable() {
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false; // Vault não está instalado
        }

        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false; // Nenhum plugin de economia compatível encontrado
        }

        economy = rsp.getProvider();
        return economy != null;
    }

    // Métodos getter para obter a instância do Economy
    public Economy getEconomy() {
        return economy;
    }

}
