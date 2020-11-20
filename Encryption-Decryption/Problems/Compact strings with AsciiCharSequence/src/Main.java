import java.util.*;

class AsciiCharSequence implements CharSequence {

    private final byte[] bytes;

    public AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes.clone();
    }

    @Override
    public int length() {
        return bytes.length;
    }

    @Override
    public char charAt(int i) {
        return (char) bytes[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        String s = new String(bytes);
        String subS = s.substring(i, i1);
        return new AsciiCharSequence(subS.getBytes());
    }

    @Override
    public String toString() {
        return new String(bytes);
    }
}
