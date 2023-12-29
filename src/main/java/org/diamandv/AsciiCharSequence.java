package org.diamandv;

import org.jetbrains.annotations.NotNull;

public class AsciiCharSequence implements CharSequence {

    private byte[] bytes;

    public AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public int length() {
        return bytes.length;
    }

    @Override
    public String toString() {
        return new String(bytes);
    }

    @Override
    public char charAt(int index) {
        return (char) (bytes[index] & 0xff);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        int length = end - start;
        byte[] bytes1 = new byte[length];
        for (int i = 0, j = start; i < length; i++, j++) {
            bytes1[i] = bytes[j];
        }
        return new AsciiCharSequence(bytes1);
    }
}
