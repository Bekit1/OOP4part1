package task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiedFile {
	private File file;
	private Block[] array = new Block[10];
	private boolean turn = false;
	private String directory;
	private int switcher;

	public CopiedFile(File file, String directory) {
		super();
		this.file = file;
		this.directory = directory;
	}

	public CopiedFile(File file) {
		super();
		this.file = file;
	}

	public CopiedFile() {
		super();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public int getSwitcher() {
		return switcher;
	}

	public void setSwitcher(int switcher) {
		this.switcher = switcher;
	}

	public Block[] getArray() {
		return array;
	}

	public void setArray(Block[] array) {
		this.array = array;
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public void setArray() {
		for (int i = 0; i < 10; i++) {
			array[i] = new Block(0, 0);
		}
	}

	public long getAvailable() throws IOException {
		FileInputStream fis = new FileInputStream(file);

		long c = fis.available();
		fis.close();
		return c;
	}

	public void setBlock() throws IOException {
		this.setArray();
		long residual = this.getAvailable() % 10;
		long blockLength = (this.getAvailable() - residual) / 10;
		for (int i = 0; i < 10; i++) {
			if (i == 9) {
				array[i].setBegin(i * blockLength);
				array[i].setEnd((i + 1) * blockLength + residual);
			} else {
				array[i].setBegin(i * blockLength);
				array[i].setEnd((i + 1) * blockLength);
			}
		}
	}

	public synchronized void copy(long begin, long end) {
		switcher = 1;
		for (; turn == true;) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		try (FileInputStream fis = new FileInputStream(file);
				FileOutputStream fos = new FileOutputStream(directory + "/copy" + file.getName())) {
			byte[] buffer = new byte[1024];

			long byteread = begin;
			for (; (byteread = fis.read(buffer)) > begin && byteread <= end && byteread > 0;) {
				fos.write(buffer, (int)begin-1,  (int)byteread);

			}
		} catch (IOException e) {
			System.out.println(e);
		}
		turn = true;
		System.out.println("Progress"+Thread.currentThread().getName());
		switcher = 0;
		notifyAll();
	}
}
