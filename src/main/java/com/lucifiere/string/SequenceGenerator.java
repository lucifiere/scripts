package com.lucifiere.string;

import java.util.Random;
import java.util.UUID;

/**
 * 串工具类
 *
 * @author XD.Wang
 * @date 2018/1/31.
 */
public enum SequenceGenerator {

    /**
     * Use the keyword and system current time to generate ID.
     */
    KEY_WORD_AND_NANO_TIME() {
        @Override
        public String getId(final String keyword) {
            final String prefix = String.format("%8x", keyword.hashCode());
            return prefix.replaceAll(" ", "") + Long.toHexString(System.nanoTime());
        }
    },

    /**
     * Use the keyword and system current time and random number to generate ID.
     */
    KEY_WORD_AND_NANO_TIME_AND_RANDOM() {
        @Override
        public String getId(final String keyword) {
            final Random random = new Random(20000);
            final int value = random.nextInt();
            final String prefix = String.format("%8x", keyword.hashCode());
            final String f = prefix.replaceAll(" ", "") + Long.toHexString(System.nanoTime()) + Long.toHexString(value);
            return f;
        }

    };

    /**
     * Get the ID according to keyword
     *
     * @param keyword the keyword
     * @return the ID
     */
    public abstract String getId(String keyword);

    /**
     * Get the ID according to UUID
     *
     * @param uuid the UUID as keyword
     * @return the ID
     */
    public String getId(final UUID uuid) {
        return this.getId(uuid.toString());
    }

}
