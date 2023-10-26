package redehid.com.campoyerick;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;

public class EnchantEvents implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getInventory().getItemInHand().isSimilar(EnchantmentMenu.criarItemPersonalizado())) {
                iniciarAnimacaoTituloAleatorio(player);
            }
        }
    }

    private void iniciarAnimacaoTituloAleatorio(Player player) {
        EnchantAnimation titleAnimation = new EnchantAnimation(player);
        titleAnimation.startAnimation();
    }

}
