package com.onemount.dungtran8.common;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.rules.TestName;

import com.onemount.dungtran8.utils.StandardText;

public class Assert {

	private FileWriter fileWriter;

	public Assert() {

	}

	public Assert(FileWriter fileWriter) {
		this.fileWriter = fileWriter;

	}

	public FileWriter getFileWriter() {
		return fileWriter;
	}

	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	public void openFileWriter(TestName name, boolean append) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ssmmHHddMMyyyy");
		LocalDateTime now = LocalDateTime.now();
		try {
			fileWriter = new FileWriter("final_result_" + name.getMethodName() + "_test_" + dtf.format(now) + ".txt",
					append);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void assertContains(String actualText, String expectText, TestName name) {
		String nameMethod = StandardText.standardizeString(name.getMethodName());
		try {
			if (actualText.contains(expectText)) {
				fileWriter.write(nameMethod + ":\tPASSED\n");
			} else {
				fileWriter.write(nameMethod + ":\tFAILED \n\t Don't go to the expected page.\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void assertEquals(String actualText, String expectText, TestName name) {
		String nameMethod = StandardText.standardizeString(name.getMethodName());
		try {
			if (actualText.equals(expectText)) {
				fileWriter.write(nameMethod + ":\tPASSED\n");
			} else {
				fileWriter.write(nameMethod + ":\tFAILED \n\t Expect is \"" + expectText + "\" but actual is \""
						+ actualText + "\"\n");
			}
		} catch (IOException e) {
			System.out.println("An error occurred in " + nameMethod);
			e.printStackTrace();
		}
	}

	public void closeFileWriter() {
		try {
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
