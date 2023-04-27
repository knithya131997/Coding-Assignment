package TestVagrant.MusicPlayer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MusicPlayer {

	// Declaration of initial Capacity and Map
	private final int playListMaxCapacityOfList;
	private final Map<String, LinkedList<String>> recentlyPlayedSongs; // String for Key,LinkedList<String> for
																		// Value-Need to store no.of Songs

	// User-Defined Constructor
	public MusicPlayer(int playListMaxCapacityOfList) {

		this.playListMaxCapacityOfList = playListMaxCapacityOfList;
		this.recentlyPlayedSongs = new HashMap<String, LinkedList<String>>();

	}

	public void addSongsToList(String user, String selectedSong) {
		LinkedList<String> playedSongs = recentlyPlayedSongs.get(user); // Get the value

		if (null == playedSongs) {
			playedSongs = new LinkedList<String>(); // If playedSongs is Null. We need to Initialize the value
			recentlyPlayedSongs.put(user, playedSongs);
		}

		playedSongs.addLast(selectedSong); // Add the recently played songs

		if (playedSongs.size() > this.playListMaxCapacityOfList) { // Check if it is greater than the initial capacity
			playedSongs.removeFirst(); // Remove the least recently played songs
		}
	}

	public LinkedList<String> getRecentSongs(String user) {

		LinkedList<String> playedSongs = recentlyPlayedSongs.get(user);

		if (null == playedSongs) {
			return new LinkedList<String>(); // If playedSongs is Null. We need to Initialize the value
		}

		return new LinkedList<>(playedSongs); // If playedSongs is not Null. It Prints the playedSongs value
	}

	public static void main(String[] args) {

		MusicPlayer memoryStore = new MusicPlayer(3);

		memoryStore.addSongsToList("FirstUser", "S1"); // Instance Method. So, we need to create an object
		memoryStore.addSongsToList("FirstUser", "S2");
		memoryStore.addSongsToList("FirstUser", "S3");

		System.out.println(memoryStore.getRecentSongs("FirstUser"));

		memoryStore.addSongsToList("FirstUser", "S4");

		System.out.println(memoryStore.getRecentSongs("FirstUser"));

		memoryStore.addSongsToList("FirstUser", "S2");

		System.out.println(memoryStore.getRecentSongs("FirstUser"));

		memoryStore.addSongsToList("FirstUser", "S1");

		System.out.println(memoryStore.getRecentSongs("FirstUser"));
	}
}
