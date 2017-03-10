package task2;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File file = new File("a.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("ERROR!");
		}
		File newFolder = new File("example");
		CopiedFile copy = new CopiedFile(file);
		copy.setDirectory("example");
		copy.setBlock();
		SingleCopyFileThread one = new SingleCopyFileThread(copy, "example");
		Thread first = new Thread(one);
		Thread second = new Thread(one);
		
		first.start();
		second.start();
	}
}
