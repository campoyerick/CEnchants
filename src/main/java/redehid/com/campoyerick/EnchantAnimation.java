package redehid.com.campoyerick;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EnchantAnimation {
    private final Player player;
    private final String[] titles; // Lista de títulos aleatórios
    private boolean animationRunning = false;
    private long lastAnimationEndTime = 0;
    private static final long COOLDOWN_DURATION = 10 * 20; // 10 segundos em ticks

    private final Map<String, ItemStack> titleToItemMap = new HashMap<>();
    private String currentTitle; // Variável para armazenar o título atual

    public EnchantAnimation(Player player) {
        this.player = player;
        this.titles = new String[] {
                "§6Proteção I",
                "§6Proteção II",
                "§6Proteção III",
                "§6Proteção IV",
                "§6Proteção Contra Fogo I",
                "§6Proteção Contra Fogo II",
                "§6Proteção Contra Fogo III",
                "§6Proteção Contra Fogo IV",
                "§6Proteção De Pena I",
                "§6Proteção De Pena II",
                "§6Proteção De Pena III",
                "§6Proteção De Pena IV",
                "§6Afiação I",
                "§6Afiação II",
                "§6Afiação III",
                "§6Afiação IV",
                "§6Afiação V",
                "§6Espada De Fogo I",
                "§6Espada De Fogo II",
                "§6Eficiencia I",
                "§6Eficiencia II",
                "§6Eficiencia III",
                "§6Eficiencia IV",
                "§6Eficiencia V",
                // Adicione mais títulos aleatórios aqui
        };

        // Preencha o mapa com os itens correspondentes aos títulos
        titleToItemMap.put("§6Proteção I", CustomProtectionEnchantment.getProtection1Book());
        titleToItemMap.put("§6Proteção II", CustomProtectionEnchantment.getProtection2Book());
        titleToItemMap.put("§6Proteção III", CustomProtectionEnchantment.getProtection3Book());
        titleToItemMap.put("§6Proteção IV", CustomProtectionEnchantment.getProtection4Book());
        titleToItemMap.put("§6Proteção Contra Fogo I", CustomProtectionEnchantment.getProtectionFire1Book());
        titleToItemMap.put("§6Proteção Contra Fogo II", CustomProtectionEnchantment.getProtectionFire2Book());
        titleToItemMap.put("§6Proteção Contra Fogo III", CustomProtectionEnchantment.getProtectionFire3Book());
        titleToItemMap.put("§6Proteção Contra Fogo IV", CustomProtectionEnchantment.getProtectionFire4Book());
        titleToItemMap.put("§6Proteção De Pena I", CustomProtectionEnchantment.getProtectionPena1Book());
        titleToItemMap.put("§6Proteção De Pena II", CustomProtectionEnchantment.getProtectionPena2Book());
        titleToItemMap.put("§6Proteção De Pena III", CustomProtectionEnchantment.getProtectionPena3Book());
        titleToItemMap.put("§6Proteção De Pena IV", CustomProtectionEnchantment.getProtectionPena4Book());
        titleToItemMap.put("§6Afiação I", CustomProtectionEnchantment.getSharp1Book());
        titleToItemMap.put("§6Afiação II", CustomProtectionEnchantment.getSharp2Book());
        titleToItemMap.put("§6Afiação III", CustomProtectionEnchantment.getSharp3Book());
        titleToItemMap.put("§6Afiação IV", CustomProtectionEnchantment.getSharp4Book());
        titleToItemMap.put("§6Afiação V", CustomProtectionEnchantment.getSharp5Book());
        titleToItemMap.put("§6Espada De Fogo I", CustomProtectionEnchantment.getFireSword1());
        titleToItemMap.put("§6Espada De Fogo II", CustomProtectionEnchantment.getFireSword2());
        titleToItemMap.put("§6Eficiencia I", CustomProtectionEnchantment.getEffi1());
        titleToItemMap.put("§6Eficiencia II", CustomProtectionEnchantment.getEffi2());
        titleToItemMap.put("§6Eficiencia III", CustomProtectionEnchantment.getEffi3());
        titleToItemMap.put("§6Eficiencia IV", CustomProtectionEnchantment.getEffi4());
        titleToItemMap.put("§6Eficiencia V", CustomProtectionEnchantment.getEffi5());
    }

    public void startAnimation() {
        long currentTime = System.currentTimeMillis() / 1000; // Converte para segundos

        // Verifique o cooldown
        if (animationRunning || (currentTime - lastAnimationEndTime) < COOLDOWN_DURATION) {
            return; // Evite iniciar a animação se uma já estiver em andamento ou dentro do cooldown
        }

        animationRunning = true;

        // Verifique e remova o livro do inventário do jogador com base no nome
        String bookName = "§eLivro de Encantamento Raro";
        int slot = -1; // Defina o slot do livro que você deseja verificar e remover

        for (int i = 0; i < player.getInventory().getSize(); i++) {
            ItemStack itemInSlot = player.getInventory().getItem(i);
            if (itemInSlot != null && itemInSlot.hasItemMeta() && itemInSlot.getItemMeta().hasDisplayName() && itemInSlot.getItemMeta().getDisplayName().equals(bookName)) {
                slot = i;
                break;
            }
        }

        if (slot >= 0) {
            player.getInventory().setItem(slot, new ItemStack(Material.AIR)); // Remove o livro do slot
            player.sendMessage("§aUUOOH! Parabéns, você usou a magia dos deuses!");
        }

        // Agende uma tarefa para alterar o título rapidamente
        BukkitRunnable titleChangeTask = new BukkitRunnable() {
            int ticks = 0;

            @Override
            public void run() {
                if (ticks < 20) { // Altera o título a cada 2 segundos (40 ticks)
                    currentTitle = titles[new Random().nextInt(titles.length)]; // Armazene o título atual
                    player.sendTitle("", ChatColor.translateAlternateColorCodes('&', currentTitle));
                    ticks++;
                } else {
                    animationRunning = false;
                    this.cancel(); // Pare a animação após 2 segundos (40 ticks)
                    lastAnimationEndTime = System.currentTimeMillis() / 1000; // Registre o tempo de término da animação
                    giveRandomItemToPlayer(player);
                }
            }
        };

        // Agende a tarefa
        titleChangeTask.runTaskTimer(Main.getPlugin(Main.class), 0L, 6L); // 6L é o atraso em ticks entre cada alteração de título (0.3 segundos)
    }

    // Método para dar um item aleatório ao jogador com base no título atual
    private void giveRandomItemToPlayer(Player player) {
        ItemStack item = titleToItemMap.get(currentTitle); // Use o título atual para buscar o item correspondente
        if (item != null) {
            player.getInventory().addItem(item);
        }
    }
}
