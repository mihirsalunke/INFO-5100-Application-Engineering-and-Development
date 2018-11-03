package question2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Question2 {

	public static void parse(File file) throws IOException {	//added throws IOException in the method signature because the line input.close(); in the finally code block might cause exception.
		RandomAccessFile input = null;
		String line = null;
		try {
			input = new RandomAccessFile(file, "r");
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
			return;
		} 
		catch (FileNotFoundException e) {	//added catch (FileNotFoundException e) because of statement input = new RandomAccessFile(file, "r");
			e.printStackTrace();
		}
		catch (IOException e) {		//added catch (IOException e) because of line = input.readLine()
			e.printStackTrace();
		}
		finally {
			if (input != null) {
				input.close();
			}
		}
	}
}