/**
 * Copyright 2020 RedstonecraftHD, VisionVenue
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.visionvenue.demoji4j.api.DiscordEmoji;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.visionvenue.demoji4j.api.emoji.DEmoji;
import de.visionvenue.demoji4j.api.user.DEUser;

public class DiscordEmoji {

	int emojis;
	int users;
	int faves;
	int pendingEmojis;

	/**
	 * The DiscordEmoji Statistics Object
	 * 
	 * @since 1.0
	 */
	public DiscordEmoji() {
		try {
			URL url = new URL("https://discordemoji.com/api/?request=stats");

			URLConnection connection = url.openConnection();

			connection.connect();

			JsonElement element = JsonParser.parseReader(new InputStreamReader((InputStream) connection.getContent()));
			JsonObject rootobj = element.getAsJsonObject();
			users = rootobj.get("users").getAsInt();
			faves = rootobj.get("faves").getAsInt();
			emojis = rootobj.get("emoji").getAsInt();
			pendingEmojis = rootobj.get("pending_approvals").getAsInt();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Gets the total amount of emojis listed on Discordemoji.com
	 * 
	 * @return The amount of {@link DEmoji} listed on Discordemoji.com
	 * @since 1.0
	 */
	public int getEmojiAmount() {
		return emojis;
	}

	/**
	 * Gets the total amount of users registered on Discordemoji.com
	 * 
	 * @return The amount of {@link DEUser} registered on Discordemoji.com
	 * @since 1.0
	 */
	public int getUserAmount() {
		return users;
	}

	/**
	 * Gets the total amount of favorites on emojis that are listed on
	 * Discordemoji.com
	 * 
	 * @return The amount of favorites on Discordemoji.com
	 * @since 1.0
	 */
	public int getTotalFavorites() {
		return faves;
	}

	/**
	 * Gets the amount of the current pending emojis on Discordemoji.com
	 * @return The amount of pending emojis on Discordemoji.com
	 * @since 1.0
	 */
	
	public int getPendingEmojis() {
		return pendingEmojis;
	}

}
