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

package de.visionvenue.demoji4j.api.emoji;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.visionvenue.demoji4j.api.enums.EmojiCategory;
import de.visionvenue.demoji4j.api.enums.EmojiLicense;
import de.visionvenue.demoji4j.api.user.DEUser;

public class DEmoji {

	int emojiId;
	String name;
	URL imageUrl;
	URL sourceUrl;
	URL pageUrl;
	EmojiCategory category;
	EmojiLicense license;
	int faves;
	DEUser creator;

	/**
	 * The DEmoji Object
	 * @param id {@link Integer} - The Emoji ID
	 * @since 1.0
	 */
	public DEmoji(int id) {
		this.emojiId = id;

		try {
			URL url = new URL("https://discordemoji.com/api/");

			URLConnection connection = url.openConnection();

			connection.connect();

			JsonElement element = JsonParser.parseReader(new InputStreamReader((InputStream) connection.getContent()));

			for (int i = 0; i < element.getAsJsonArray().size(); i++) {
				JsonObject e = element.getAsJsonArray().get(i).getAsJsonObject();

				if (e.get("id").getAsInt() == id) {
					this.name = e.get("title").getAsString();
					this.faves = e.get("faves").getAsInt();
					this.creator = new DEUser(e.get("submitted_by").getAsString());
					this.category = EmojiCategory.valueOf(e.get("category").getAsInt());
					this.license = EmojiLicense.valueOf(e.get("license").getAsInt());
					this.imageUrl = new URL(e.get("image").getAsString().replace("\\", ""));
					if (e.get("source") != null) {
						this.sourceUrl = new URL(e.get("source").getAsString().replace("\\", ""));
					}
					this.pageUrl = new URL("https://discordemoji.com/emoji/" + e.get("slug").getAsString());
				}
			}

		} catch (IOException e) {

		}

	}

	/**
	 * Gets the ID of the emoji on Discordemoji.com
	 * @return The ID of the emoji
	 * @since 1.0
	 */
	public int getId() {
		return emojiId;
	}

	/**
	 * Gets the name of the emoji on Discordemoji.com
	 * @return The name of the emoji
	 * @since 1.0
	 */
	public String getName() {
		return name;
	}

	public URL getImageUrl() {
		return imageUrl;
	}

	public EmojiCategory getCategory() {
		return category;
	}

	public URL getSourceUrl() {
		return sourceUrl;
	}

	public URL getPageUrl() {
		return pageUrl;
	}

	public EmojiLicense getLicense() {
		return license;
	}

	public int getFavorites() {
		return faves;
	}

	public DEUser getCreator() {
		return creator;
	}

}
