package org.finalproject.input;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/*Much code in this class is borrowed from the textbook "Head First Design Patterns" page #102 ISBN: 0-596-00712-4*/
public class InputDecoraterRemovePunctuation extends FilterInputStream {


	/**
	 * Creates a {@code FilterInputStream}
	 * by assigning the  argument {@code in}
	 * to the field {@code this.in} so as
	 * to remember it for later use.
	 *
	 * @param in the underlying input stream, or {@code null} if
	 *           this instance is to be created without an underlying stream.
	 */
	public InputDecoraterRemovePunctuation(InputStream in) {
		super(in);
	}

	public int read() throws IOException {
		int c = super.read();
		return (c == -1 ? c: Character.toLowerCase((char)c));
	}

	public int read(byte[] b, int offset, int len) throws IOException {
		int result = super.read(b, offset, len);
		for (int i = offset; i < offset+result; i++) {
			b[i] = (byte) Character.toLowerCase((char)b[i]);
		}
		return result;
	}
}
