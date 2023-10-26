package redehid.com.campoyerick;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerDataManager {
    private final File playerDataFile;
    private final FileConfiguration playerDataConfig;
    private final Map<UUID, Integer> livrosCompradosMap;

    public PlayerDataManager(File dataFolder) {
        playerDataFile = new File(dataFolder, "playerdata.yml");
        playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
        livrosCompradosMap = new HashMap<>();
        loadPlayerData();
    }

    private void loadPlayerData() {
        for (String playerUUID : playerDataConfig.getKeys(false)) {
            UUID uuid = UUID.fromString(playerUUID);
            int livrosComprados = playerDataConfig.getInt(playerUUID);
            livrosCompradosMap.put(uuid, livrosComprados);
        }
    }

    public int getLivrosComprados(Player player) {
        UUID playerUUID = player.getUniqueId();
        return livrosCompradosMap.getOrDefault(playerUUID, 0);
    }

    public void setLivrosComprados(Player player, int quantidade) {
        UUID playerUUID = player.getUniqueId();
        livrosCompradosMap.put(playerUUID, quantidade);
        playerDataConfig.set(playerUUID.toString(), quantidade);

        try {
            playerDataConfig.save(playerDataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
