package de.visionvenue.demoji4j.test;

import de.visionvenue.demoji4j.api.DiscordEmoji.DiscordEmoji;
import de.visionvenue.demoji4j.api.emoji.DEmoji;
import de.visionvenue.demoji4j.api.packs.DEPack;
import de.visionvenue.demoji4j.api.user.DEUser;

public class Main {

	public static void main(String[] args) {
		DEmoji emoji = new DEmoji(5834);
		System.out.println("Name: " + emoji.getName());
		System.out.println("ID: " + emoji.getId());
		System.out.println("Category: " + emoji.getCategory());
		System.out.println("License: " + emoji.getLicense());
		System.out.println("Creator: " + emoji.getCreator().getName());
		System.out.println("Favorites: " + emoji.getFavorites());
		System.out.println("Page: " + emoji.getPageUrl());
		System.out.println("Image: " + emoji.getImageUrl());
		System.out.println("Source: " + emoji.getSourceUrl());
		
		DEPack pack = new DEPack(4);
		System.out.println("Name: " + pack.getName());
		System.out.println("Description: " + pack.getDescription());
		System.out.println("ID: " + pack.getId());
		System.out.println("Emojis: " + pack.getEmojiAmount());
		System.out.println("Thumbnail: " + pack.getThumbnailUrl());
		System.out.println("Download: " + pack.getDownloadUrl());
		
		DEUser user = new DEUser("christianbale");
		System.out.println("Name: " + user.getName());
		
		DiscordEmoji web = new DiscordEmoji();
		System.out.println("Emojis: " + web.getEmojiAmount());
		System.out.println("Users: " + web.getUserAmount());
		System.out.println("Pending: " + web.getPendingEmojis());
		System.out.println("Favorites: " + web.getTotalFavorites());
		
	}
}
