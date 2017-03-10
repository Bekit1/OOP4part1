package task2;

import java.io.File;


public class SingleCopyFileThread implements Runnable {
	private CopiedFile file;
	private String directory;


	public SingleCopyFileThread(CopiedFile file, String directory) {
		super();
		this.file = file;
		this.directory = directory;

	}

	public CopiedFile getFile() {
		return file;
	}

	public void setFile(CopiedFile file) {
		this.file = file;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	

	public SingleCopyFileThread() {
		super();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 10; i++) {
			if(file.getSwitcher()==1){
				continue;
			}
			file.copy(file.getArray()[i].getBegin(), file.getArray()[i].getEnd());
			file.setTurn(false);
		}
		
	}

}
