/**
 * 
 */
package com.gatecm.obsession;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年11月22日 下午6:31:04
 *
 */
public class ZipTest {

	public static void main(String[] args) throws IOException {
		
		File file = new File("e:" + File.separator + "testsdff");
		System.err.println(file.mkdir());
		
		String resourceFilePath = "e:" + File.separator + "flag.gif";
		String zipFilePath = "e:" + File.separator + "test1.zip";
		ZipTest.packageZip(zipFilePath, resourceFilePath);

		String resourceFilePath2 = "e:" + File.separator + "flag.gif";
		String zipFilePath2 = "e:" + File.separator + "test2.zip";
		ZipTest.packageZip(zipFilePath2, resourceFilePath2);

		String zipFilePath3 = file.getPath() + File.separator + "test3.zip";
		ZipTest.packageZip(zipFilePath3, zipFilePath, zipFilePath2);

		// 删除内部zip
		(new File(zipFilePath)).delete();
		(new File(zipFilePath2)).delete();


	}

	private static void packageZip(String zipFilePath, String... resourceFilePath) throws IOException {
		File zipFile = new File(zipFilePath);
		ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
		for (int i = 0; i < resourceFilePath.length; i++) {
			File file = new File(resourceFilePath[i]);
			InputStream input = new FileInputStream(file);
			System.err.println(file.getName());
			zipOut.putNextEntry(new ZipEntry(System.currentTimeMillis() + file.getName()));
			int temp = 0;
			while ((temp = input.read()) != -1) {
				zipOut.write(temp);
			}
			input.close();
		}
		zipOut.close();
	}

}
