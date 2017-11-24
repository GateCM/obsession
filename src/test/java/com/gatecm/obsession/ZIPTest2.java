///**
// * 
// */
//package com.gatecm.obsession;
//
//import java.io.BufferedInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipOutputStream;
//
//import org.springframework.util.StringUtils;
//
///**
// * @Description: TODO()
// * @author chenxiaohui
// * @date 2017年11月22日 下午7:16:50
// *
// */
//public class ZIPTest2 {
//
//	/**
//	 * 下载附件
//	 * 
//	 * @return
//	 */
//	public String finalAuditBookFilesDownload() {
//		try {
//			Map<String, Object> params = new HashMap<>();
//			if (StringUtils.isNotEmpty(batchIds)) {
//				String[] batIds = batchIds.split(",");
//				params.put("batchIds", batIds);
//			} else {
//				if (batchId != null) {
//					params.put("batchIds", batchId);
//				}
//			}
//			List<ReviewAccessory> reviewAccessoryList = QueryUtil.getInstance()
//					.findByNq("auditBook.checkAccessoryExist", params, ReviewAccessory.class);
//			int len = reviewAccessoryList.size();
//			if (reviewAccessoryList != null && len > 0) {
//				if (len == 1) { // 只有一条数据，无需压缩，直接下载
//					String rootPath = reviewAccessoryList.get(0).getPath();
//					// 仅本地测试
//					File file = new File(rootPath);
//					if (!file.getParentFile().exists()) {
//						file.getParentFile().mkdirs();
//					}
//					if (!file.exists()) {
//						file.createNewFile();
//					}
//
//					String zipName = new String(
//							rootPath.substring(rootPath.lastIndexOf("/") + 1, rootPath.length()).getBytes("GBK"),
//							"iso8859-1");
//					this.downloadFileStream = new FileInputStream(rootPath);
//					this.downloadFileName = zipName;
//					return "downloadZip";
//				}
//				// 否则，将多个zip再次进行打包
//				File[] tempZipfiles = new File[len];
//				String zipName = new String(
//						("StorageBookAuditFile" + DateUtils.yyyyMMddHHmmss() + ".zip").getBytes("GBK"), "iso8859-1");
//				for (int i = 0; i < len; i++) {
//					ReviewAccessory accessory = reviewAccessoryList.get(i);
//					String path = accessory.getPath();
//					File file = new File(path);
//					String newName = new String((accessory.getObjectId() + ".zip").getBytes("GBK"), "iso8859-1");
//					String newPath = path.substring(0, path.lastIndexOf("/")) + "/" + newName;
//					File tmpZipFile = new File(newPath);
//					//复制文件
//					copyFile(file, tmpZipFile);
//					// 添加复制的zip文件
//					tempZipfiles[i] = file;
//				}
//				// 创建root文件夹
//				String dir = ConfigManageUtil.STORAGE_BOOK_DEPOTS_PATH;
//				File fileDir = new File(dir);
//				if (!fileDir.exists()) {
//					fileDir.mkdirs();
//				}
//				// 将复制的zip文件压缩成zip
//				zipFile(dir + File.separator + zipName, tempZipfiles);
//				// 删除临时filezip
//				for (int i = 0; i < tempZipfiles.length; i++) {
//					tempZipfiles[i].delete();
//				}
//
//				this.downloadFileStream = new FileInputStream(
//						ConfigManageUtil.STORAGE_BOOK_DEPOTS_PATH + "/" + zipName);
//				this.downloadFileName = zipName;
//				return "downloadZip";
//			}
//		} catch (Exception e) {
//			 logger.error("【图书库】-审核记录下载附件失败",e);
//		}
//		 this.addActionError("该批次没有评审附件可供下载!");
//		return "downloadFail";
//	}
//
//	/**
//	 * 压缩文件到指定文件中（按指定文件路径）
//	 * 
//	 * @param filePath
//	 *            zip输出文件
//	 * @param fileList
//	 *            被压缩文件
//	 * @throws Exception
//	 */
//	private static void zipFile(String filePath, File... fileList) throws Exception {
//		ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(filePath));
//		byte[] buf = new byte[1024];
//		int readLen = 0;
//		for (int i = 0; i < fileList.length; i++) {
//			File file = fileList[i];
//			InputStream is = new BufferedInputStream(new FileInputStream(file));
//			zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
//			while ((readLen = is.read(buf, 0, 1024)) != -1) {
//				zipOutputStream.write(buf, 0, readLen);
//			}
//			is.close();
//		}
//		zipOutputStream.close();
//
//	}
//	
//	
//	/**
//	 * 复制文件
//	 * 
//	 * @param fromFile
//	 * @param toFile
//	 * @throws IOException
//	 */
//	public static void copyFile(File fromFile, File toFile) throws IOException {
//		FileInputStream ins = new FileInputStream(fromFile);
//		FileOutputStream out = new FileOutputStream(toFile);
//		byte[] b = new byte[1024];
//		int n = 0;
//		while ((n = ins.read(b)) != -1) {
//			out.write(b, 0, n);
//		}
//		ins.close();
//		out.close();
//	}
//
//
//	/**
//	 * @param args
//	 * @throws Exception
//	 */
//	public static void main(String[] args) throws Exception {
//		String tempDir = "e:" + File.separator + "tes";
//		String accessoryPath1 = "e:" + File.separator + "1511400737586.zip";
//		String accessoryPath2 = "e:" + File.separator + "400737586.zip";
//		String[] batIds = { "12313", "22342344" };
//		String[] pathArr = { accessoryPath1, accessoryPath2 };
//		int len = 2;
//
//		String zipName = new String(("StorageBookAuditFile" + System.currentTimeMillis() + ".zip").getBytes("GBK"),
//				"iso8859-1");
//		File[] tempZipfiles = new File[len];
//		for (int i = 0; i < len; i++) {
//			// ReviewAccessory accessory = reviewAccessoryList.get(i);
//			// String path = accessory.getPath();
//			String path = pathArr[i];
//			File file = new File(path);
//			// String newName = new String((accessory.getObjectId() +
//			// ".zip").getBytes("GBK"), "iso8859-1");
//			String newName = new String((batIds[i] + ".zip").getBytes("GBK"), "iso8859-1");
//			String newPath = path.substring(0, path.lastIndexOf(File.separator)) + File.separator + newName;
//			File tmpZipFile = new File(newPath);
//			copyFile(file, tmpZipFile);
//			// 添加复制的zip文件
//			tempZipfiles[i] = tmpZipFile;
//		}
//		// 创建root文件夹
//		String dir = tempDir;
//		File fileDir = new File(dir);
//		if (!fileDir.exists()) {
//			fileDir.mkdirs();
//		}
//		// 将复制的zip文件压缩成zip
//		zipFile(dir + File.separator + zipName, tempZipfiles);
//		// 删除临时filezip
//		for (int i = 0; i < tempZipfiles.length; i++) {
//			tempZipfiles[i].delete();
//		}
//	}
//
//	
//}
