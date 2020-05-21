package de.visionvenue.demoji4j.api.enums;

import java.util.HashMap;

public enum EmojiLicense {
	
	BASIC(0), CC_BY_4_0(1), WTFPL(2);

	private int license;
	private static HashMap<Integer, EmojiLicense> map = new HashMap<Integer, EmojiLicense>();

	// getter method
	public int getLicenseId() {
		return this.license;
	}

	// enum constructor - cannot be public or protected
	private EmojiLicense(int license) {
		this.license = license;
	}
	
	static {
        for (EmojiLicense ELicense : EmojiLicense.values()) {
            map.put(ELicense.getLicenseId(), ELicense);
        }
    }

    public static EmojiLicense valueOf(int id) {
        return (EmojiLicense) map.get(id);
    }
}
