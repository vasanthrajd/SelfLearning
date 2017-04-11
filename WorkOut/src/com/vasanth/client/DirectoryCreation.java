package com.vasanth.client;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class DirectoryCreation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String tmpPath="E:\\Run Pgms";
		String tmpDir="tmpDirectory";
		String zipFilePath="E:\\DeveloperAutomationTask\\TaskExecutor\\NodeJS\\Nodejs.zip";
		String zipFiles="E:\\DeveloperAutomationTask\\TaskExecutor\\NodeJS\\Nodejs";
		/*Map<String, Object> requestFile=new HashMap<String,Object>();
		File tmpfile=new File(tmpPath+System.getProperty("file.separator")+UUID.randomUUID().toString());
		if(tmpfile.isFile())
				tmpfile.delete();
		else
				tmpfile.mkdirs();
		requestFile.put(tmpDir, tmpfile);
		System.out.println(requestFile.get(tmpDir));*/
		ZipInputStream zipIn=new ZipInputStream(new FileInputStream(zipFilePath));
		
		ZipEntry entry=zipIn.getNextEntry();
		while(entry!=null){
			String filePath=tmpPath+File.separator+entry.getName();
			if(entry.isDirectory()){
				File dir=new File(filePath);
				dir.mkdir();
			}else{
				createFile(zipIn,filePath);
			}
			zipIn.closeEntry();
			entry=zipIn.getNextEntry();
			
		}
		ZipOutputStream zipOut=new ZipOutputStream(new FileOutputStream(zipFiles));
			
		
	}
		private static void createFile(ZipInputStream zipIn,String filePath) throws IOException{
			int buffer_size=4096;
			BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(filePath));
			byte[] byteIn=new byte[buffer_size];
			int read=0;
			while((read=zipIn.read(byteIn))!=-1){
				bos.write(byteIn,0,read);
			}
			bos.close();
		}
		
}
