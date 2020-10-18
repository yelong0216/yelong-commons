package test.org.yelong.commons.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.yelong.commons.io.IOUtilsE;

public class IOUtilsETest {

	@Test
	public void read() throws FileNotFoundException, IOException {
		String read = IOUtilsE.readString(new FileInputStream("C:\\Users\\14308\\Desktop\\管理工具.html"));
		System.out.println(read);
	}

}
