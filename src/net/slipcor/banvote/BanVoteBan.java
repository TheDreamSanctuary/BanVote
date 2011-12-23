package net.slipcor.banvote;

/**
 * ban vote ban class
 * 
 * @version v0.0.1
 * 
 * @author slipcor
 * 
 */

public class BanVoteBan {
	private final long timestamp;
	private final String voter;
	private final String target;
	private final int interval;
	private final boolean result;
	
	/**
	 * construct a ban vote ban instance
	 * @param uid the case unique ID
	 * @param sVoter the voting player
	 * @param sTarget the player that has been voted on
	 * @param lTimestamp the ban timestamp (in seconds)
	 * @param iInterval ban length (in seconds)
	 * @param bResult true: target banned, false: 
	 */
	public BanVoteBan(int uid, String sVoter, String sTarget, long lTimestamp, int iInterval, boolean bResult) {
		voter = sVoter;
		target = sTarget;
		timestamp = lTimestamp;
		interval = iInterval;
		result = bResult;
		BanVotePlugin.instance.getConfig().set("bans.b"+uid, getContents());
		BanVotePlugin.instance.saveConfig();
	}
	
	/**
	 * check who was banned
	 * @return result true: target, else: voter name
	 */
	protected String getBanned() {
		return result?target:voter;
	}
	
	/**
	 * check if the ban has expired
	 * @return true if the ban has expired, false otherwise
	 */
	protected boolean over() {
		return (timestamp+interval)>System.currentTimeMillis()/1000d;
	}
	
	/**
	 * combine the ban information to a string
	 * @return a string of all information, joined with ":"
	 */
	private String getContents() {
		return voter+":"+target+":"+timestamp+":"+interval+":"+result;
	}
}
