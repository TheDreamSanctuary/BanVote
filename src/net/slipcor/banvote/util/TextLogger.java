package net.slipcor.banvote.util;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.slipcor.banvote.BanVotePlugin;

import org.bukkit.plugin.Plugin;

public class TextLogger {
	
	private Plugin p;
	
	public TextLogger(){
		this.p = BanVotePlugin.instance;
	}
	
	public void logToFile(String message)
	 
    {
 
        try
        {
            File folder = p.getDataFolder();
            if(!folder.exists())
            {
                folder.mkdir();
            }

            File target = new File(p.getDataFolder(), "log.txt");
            if (!target.exists())
            {
                target.createNewFile();
            }
 
            PrintWriter print = new PrintWriter(new FileWriter(target, true));
 
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            System.out.println();
            
            print.println("["+dateFormat.format(date)+"]"+message);
            print.flush();
            print.close();
            
 
        } catch (Exception e)
        {
 
            e.printStackTrace();
 
        }
 
    }

}
