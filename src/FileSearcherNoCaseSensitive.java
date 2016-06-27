import java.io.File;
import java.util.ArrayList;

public class FileSearcherNoCaseSensitive implements FileSearch{

	@Override
	public void searchFile(String basePath, String keyWord, ArrayList<FileProperty> fileList) {
		// TODO Auto-generated method stub
		String tempName = null; 
		File baseDir = new File(basePath);
		if (!baseDir.exists() || !baseDir.isDirectory()){  
			System.out.println("文件查找失败：" + basePath + "不是一个目录！");  
	    } else {
	    	String[] filelist = baseDir.list();
	    	for (int i = 0; i < filelist.length; i++) {  
                File readfile = new File(basePath + "\\" + filelist[i]);  
                if(!readfile.isDirectory()) {  
                    tempName =  readfile.getName();   
                   // if (fileNameMatch(keyWord, tempName)) {  
                        //匹配成功，将文件名添加到结果集  
                    	String FilePath = readfile.getAbsolutePath();
                    	String FileName = readfile.getName();
                    	FileProperty targetFile = new FileProperty(FileName,FilePath);
                        fileList.add(targetFile);   
                    //}  
                } else if(readfile.isDirectory()){  
                	searchFile(basePath + "\\" + filelist[i],keyWord,fileList);  
                }  
            }  
	    	
	    }
		
	}
	
	public boolean fileNameMatch(String keyWord, String fileName) {
		String tempKeyWord = keyWord.toLowerCase();
		String tempName = fileName.toLowerCase();
		
		if(tempName.indexOf(tempKeyWord) != -1) {
			return true;
		} else {
			
			return false;
		}
	}

}
