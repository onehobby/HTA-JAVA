package kr.co.jhta.di.service;

import java.io.File;
import java.io.PrintWriter;

public class FileOutput implements Output {
	
	private String directory;
	private String filename;
	private PrintWriter writer;
	
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public FileOutput(String directory, String filename) {
		this.directory = directory;
		this.filename = filename;
	}
	
	public FileOutput() {}
	
	private void createWriter() {
		try {
			File file = new File(directory, filename);
			writer = new PrintWriter(file, "utf-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void write(String text) {
		
		if (writer == null ) {
			createWriter();
		}
		
		writer.println(text);
		writer.flush();
	};
}
