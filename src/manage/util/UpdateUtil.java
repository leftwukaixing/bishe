package manage.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class UpdateUtil {
	public static void update(File file,File newfile) throws IOException{

		//创建新文件
		newfile.createNewFile();
		InputStream is = new FileInputStream(file);
		OutputStream os = new FileOutputStream(newfile);
		byte[] buffer = new byte[1024];
		int length = 0;
		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		is.close();
		os.close();
	}
}
