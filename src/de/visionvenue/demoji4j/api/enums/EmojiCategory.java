package de.visionvenue.demoji4j.api.enums;

import java.util.HashMap;

public enum EmojiCategory {

	ORIGINAL_STYLE(1), TV_AND_MOVIE(2), MEME(3), ANIME(4), CELEBRITY(5), BLOBS(6), THINKING(7), ANIMATED(8), NSFW(9),
	GAMING(10), LETTERS(11), OTHER(12), PEPE(13), LOGOS(14), CUTE(15), UTILITY(16), ANIMALS(17), RECOLORS(18);

	private int category;
	private static HashMap<Integer, EmojiCategory> map = new HashMap<Integer, EmojiCategory>();

	// getter method
	public int getCategoryId() {
		return this.category;
	}

	// enum constructor - cannot be public or protected
	private EmojiCategory(int category) {
		this.category = category;
	}
	
	static {
        for (EmojiCategory ECategory : EmojiCategory.values()) {
            map.put(ECategory.getCategoryId(), ECategory);
        }
    }

    public static EmojiCategory valueOf(int id) {
        return (EmojiCategory) map.get(id);
    }

	
}
