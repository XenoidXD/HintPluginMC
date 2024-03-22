public class Main extends JavaPlugin {

    private static final int INTERVAL_MENIT = 5; // Change this value for set interval time (in minute)
    private static final List<String> HINT = new ArrayList<>();

    static {
        HINT.add("This is First Hint Message"); // Change this value to set the hint messages
        HINT.add("This is Second Hint Message");
        HINT.add("This is Third Hint Message");
        HINT.add("And This is Final Hint Message"); // You can add or delete messages with the same format if you want
    }

    private int indexHint = 0;

    @Override
    public void onEnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (Bukkit.getOnlinePlayers().size() > 0) {
                    String hintSekarang = HINT.get(indexHint);

                    Bukkit.broadcastMessage(ChatColor.GOLD + "[HINT] " + hintSekarang);
                    Bukkit.getServer().playSound(null, Sound.BLOCK_BELL, 1, 1);

                    indexHint = (indexHint + 1) % HINT.size();
                }
            }
        }.runTimer(this, 20L * INTERVAL_MENIT * 60); // Tick server
    }
}
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        File fileConfig = new File(getDataFolder(), "config.yml");
        if (!fileConfig.exists()) {
            try {
                fileConfig.createNewFile();
                YamlConfiguration config = YamlConfiguration.loadConfiguration(fileConfig);

                // Nilai default untuk konfigurasi
                config.set("intervalMenit", 5);
                config.set("hint", Arrays.asList(
                    "This is first hint message", 
                    "This is second hint message",  // Don't change this code. This is default value for declare the function for the first time
                    "This is third hint message",
                    "And this is final hint message"
                ));

                config.save(fileConfig);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
