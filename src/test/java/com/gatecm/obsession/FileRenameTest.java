/**
 * 
 */
package com.gatecm.obsession;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年11月23日 上午9:31:54
 *
 */
public class FileRenameTest {

	public static void main(String[] args) throws IOException {
		// 想命名的原文件的路径
		String zipFilePath = "e:" + File.separator + "1511400737586.zip";
		File file = new File(zipFilePath);
		// 将原文件更改为f:\a\b.xlsx，其中路径是必要的。注意

		String zipFilePathNew = "e:" + File.separator + "400737586.zip";

		copyFile(file, new File(zipFilePathNew));
		// //想命名的原文件夹的路径
		// File file1 = new File("f:/A");
		// //将原文件夹更改为A，其中路径是必要的。注意
		// file1.renameTo(new File("f:/B"));
	}

	/**
	 * 复制文件
	 * 
	 * @param fromFile
	 * @param toFile
	 * @throws IOException
	 */
	public static void copyFile(File fromFile, File toFile) throws IOException {
		FileInputStream ins = new FileInputStream(fromFile);
		FileOutputStream out = new FileOutputStream(toFile);
		byte[] b = new byte[1024];
		int n = 0;
		while ((n = ins.read(b)) != -1) {
			out.write(b, 0, n);
		}
		ins.close();
		out.close();
	}

}
