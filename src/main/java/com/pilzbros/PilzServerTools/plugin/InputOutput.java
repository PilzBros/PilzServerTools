package com.pilzbros.PilzServerTools.plugin;

import com.pilzbros.PilzServerTools.PilzServerTools;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class InputOutput {
    public static YamlConfiguration global;
    public static HashMap<Integer, String[]> jailStickParameters = new HashMap();

    public InputOutput(PilzServerTools pst) {
        if (!PilzServerTools.instance.getDataFolder().exists()) {
            try {
                PilzServerTools.instance.getDataFolder().mkdir();
            } catch (Exception var3) {
                var3.printStackTrace();
            }
        }

        global = new YamlConfiguration();
    }

    public void LoadSettings() {
        try {
            if (!(new File(PilzServerTools.instance.getDataFolder(), "global.yml")).exists()) {
                global.save(new File(PilzServerTools.instance.getDataFolder(), "global.yml"));
            }

            global.load(new File(PilzServerTools.instance.getDataFolder(), "global.yml"));
            Setting[] var4;
            int var3 = (var4 = Setting.values()).length;

            for(int var2 = 0; var2 < var3; ++var2) {
                Setting s = var4[var2];
                if (global.get(s.getString()) == null) {
                    global.set(s.getString(), s.getDefault());
                }
            }

            global.save(new File(PilzServerTools.instance.getDataFolder(), "global.yml"));
        } catch (FileNotFoundException var5) {
            var5.printStackTrace();
        } catch (IOException var6) {
            var6.printStackTrace();
        } catch (InvalidConfigurationException var7) {
            var7.printStackTrace();
        }

    }
}
