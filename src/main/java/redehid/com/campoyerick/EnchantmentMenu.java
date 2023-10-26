package redehid.com.campoyerick;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import java.util.*;

public class EnchantmentMenu implements Listener {

    private final PlayerDataManager playerDataManager; // Adicione esta linha

    private final Main plugin; // Variável para armazenar a referência do plugin

    public EnchantmentMenu(Main plugin, PlayerDataManager playerDataManager) {
        this.plugin = plugin; // Armazene a referência do plugin
        this.playerDataManager = playerDataManager; // Atribua o playerDataManager

    }

    public void abrirMenu(Player player) {
        // Crie um inventário com um tamanho específico, por exemplo, 27 slots
        Inventory menu = Bukkit.createInventory(null, 27, "Encantamento - Principal");

        // Adicione o item de encantamento ao inventário no slot 13
        ItemStack encantamento = criarItemDeEncantamento();
        menu.setItem(14, encantamento);

        // Obtém a quantidade de livros comprados pelo jogador
        int livrosComprados = playerDataManager.getLivrosComprados(player);

        // Atualize o lore do item da cabeça do jogador com a quantidade de livros comprados
        ItemStack skull = criarCabecaDoJogador(player, livrosComprados);
        menu.setItem(12, skull);

        // Abra o inventário para o jogador
        player.openInventory(menu);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        // Verifique se o jogador clicou no inventário correto
        if (event.getInventory().getTitle().equals("Encantamento - Principal")) {
            // Verifique se o clique foi no slot 13
            if (event.getRawSlot() == 14) {
                // Certifique-se de que o jogador é um jogador (não um NPC, por exemplo)
                if (event.getWhoClicked() instanceof Player) {
                    Player player = (Player) event.getWhoClicked();

                    // Verifique se o jogador tem dinheiro suficiente (por exemplo, 1000 unidades)
                    double precoItem = 1000.0; // Preço do item em dinheiro
                    Economy economy = plugin.getEconomy(); // Obtenha a instância do Vault Economy

                    if (economy.has(player, precoItem)) {
                        // O jogador tem dinheiro suficiente, dê o item e retire o dinheiro
                        ItemStack itemPersonalizado = criarItemPersonalizado();
                        player.getInventory().addItem(itemPersonalizado);
                        EconomyResponse response = economy.withdrawPlayer(player, precoItem);

                        if (response.transactionSuccess()) {
                            player.sendMessage("Você comprou o item por " + precoItem + " dinheiro.");

                            // Atualize a quantidade de livros comprados pelo jogador
                            int livrosComprados = playerDataManager.getLivrosComprados(player); // Obtenha a quantidade atual de livros comprados
                            livrosComprados++; // Aumente em 1

                            // Atualize o lore do item da cabeça do jogador
                            ItemStack skull = criarCabecaDoJogador(player, livrosComprados);
                            player.getOpenInventory().setItem(12, skull);

                            // Atualize a quantidade de livros comprados no playerDataManager
                            playerDataManager.setLivrosComprados(player, livrosComprados);
                        } else {
                            player.sendMessage("Ocorreu um erro ao processar a transação.");
                        }
                    } else {
                        // O jogador não tem dinheiro suficiente
                        player.sendMessage("Você não tem dinheiro suficiente para comprar este item.");
                    }
                }
            }
            event.setCancelled(true); // Impede que os jogadores movam ou retirem os itens do menu
        }
    }


    private ItemStack criarCabecaDoJogador(Player jogador, int livrosComprados) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner(jogador.getName());

        meta.setDisplayName("§aInformações do jogador");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(" §fLivros Comprados: §a" + livrosComprados);
        lore.add("");

        meta.setLore(lore);
        skull.setItemMeta(meta);
        return skull;
    }


    private ItemStack criarItemDeEncantamento() {
        ItemStack encantamento = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta itemMeta = encantamento.getItemMeta();
        itemMeta.setDisplayName("§eEncantamento Raro");
        itemMeta.setLore(Arrays.asList(
                "",
                "§7Com esse livro de encantamento",
                "§7Você poderá receber vários",
                "§7encantamentos level 1.",
                "",
                " §7• §fProteções",
                " §7• §fAfiações",
                " §7• §fMelhorias",
                "",
                "§aClique para comprar"
        ));
        encantamento.setItemMeta(itemMeta);
        return encantamento;
    }

    public static ItemStack criarItemPersonalizado() {
        ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§eLivro de Encantamento Raro");
        List<String> lore = new ArrayList<>();
        lore.add("§7Use este livro para encantar seus itens.");
        lore.add("§7Nível 1: Força, Proteção, Afiação, e mais.");
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}

