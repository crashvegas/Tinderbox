package net.inabsentia.bukkit.Tinderbox;

import java.io.File;
import org.bukkit.util.config.Configuration;

public class TinProperties {

	public static double LEFTCLICK,RIGHTCLICK;

	private static String dir = "plugins/Tinderbox/";
	private static File ConfigFile;

	public static void reload(){
		load();
	}

	private static void load(){
		ConfigFile = new File(dir + "config.yml");
		checkForConfig();

		loadConfig(new Configuration(ConfigFile));
	}


	private static void checkForConfig(){
		try{
			if(!ConfigFile.exists()){
				ConfigFile.getParentFile().mkdirs();
				ConfigFile.createNewFile();
				Configuration config = new Configuration(ConfigFile);

				String tag = "Global.";
				config.setProperty(tag + "left-click-ability", 4);
				config.setProperty(tag + "right-click-ability", 1);

				config.save();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void loadConfig(Configuration config){
		try{
			config.load();

			String tag = "Global.";
			LEFTCLICK = config.getDouble(tag + "left-click-ability", 4);
			RIGHTCLICK = config.getDouble(tag + "right-click-ability", 1);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
