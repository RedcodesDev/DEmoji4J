package de.visionvenue.demoji4j.api.packs;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DEPack {

	int id;
	String name;
	String description;
	URL thumbnail;
	URL download;
	int emojis;

	public DEPack(int id) {
		this.id = id;

		try {
			URL url = new URL("https://discordemoji.com/api/packs");

			URLConnection connection = url.openConnection();

			connection.connect();

			JsonElement element = JsonParser.parseReader(new InputStreamReader((InputStream) connection.getContent()));

			for (int i = 0; i < element.getAsJsonArray().size(); i++) {
				JsonObject e = element.getAsJsonArray().get(i).getAsJsonObject();

				if (e.get("id").getAsInt() == id) {
					this.name = e.get("name").getAsString();
					this.description = e.get("description").getAsString();
					this.emojis = e.get("amount").getAsInt();
					this.thumbnail = new URL(e.get("image").getAsString().replace("\\", ""));
					this.download = new URL(e.get("download").getAsString().replace("\\", ""));
				}
			}

		} catch (IOException e) {

		}
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public URL getThumbnailUrl() {
		return thumbnail;
	}

	public URL getDownloadUrl() {
		return download;
	}

	public int getEmojiAmount() {
		return emojis;
	}

}
