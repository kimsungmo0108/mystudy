package bitcamp.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DataInputStream extends FileInputStream {

  public DataInputStream(String name) throws FileNotFoundException {
    super(name);
  }

  public short readShort() throws IOException {
    return (short) (read() << 8 | read());
  }

  public int readInt() throws IOException {
    return read() << 8 | read();
  }

  public long readLong() throws IOException {
    return (long) read() << 56 |
        (long) read() << 48 |
        (long) read() << 40 |
        (long) read() << 32 |
        (long) read() << 24 |
        (long) read() << 16 |
        (long) read() << 8 |
        (long) read();
  }

  public String readUTF() throws IOException {
    byte[] bytes = new byte[60000];
    int len = readInt();
    read(bytes, 0, len);
    return new String(bytes, 0, len, StandardCharsets.UTF_8);
  }

  public boolean readBoolean() throws IOException {
    return read() == 1;
  }
}
