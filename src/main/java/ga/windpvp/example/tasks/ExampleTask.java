package ga.windpvp.example.tasks;

import org.bukkit.Bukkit;

import ga.windpvp.example.ExamplePlugin;

public class ExampleTask implements Runnable {
    @Override
    public void run() {
        final String message = ExamplePlugin.getInstance().getConfig().getString("messages.from-task");
        Bukkit.getServer().broadcastMessage(message);
    }
}