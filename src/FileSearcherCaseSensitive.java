import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileSearcherCaseSensitive implements FileSearch {

	@Override
	public void searchFile(String basePath, String keyWord, ArrayList<FileProperty> fileList) {
		// TODO Auto-generated method stub
		String tempName = null; 
		File baseDir = new File(basePath);
		if (!baseDir.exists() || !baseDir.isDirectory()){  
			System.out.println("�ļ�����ʧ�ܣ�" + basePath + "����һ��Ŀ¼��");  
	    } else {
	    	String[] filelist = baseDir.list();
	    	for (int i = 0; i < filelist.length; i++) {  
                File readfile = new File(basePath + "\\" + filelist[i]);  
                if(!readfile.isDirectory()) {  
                    tempName =  readfile.getName();   
                   // if (fileNameMatch(keyWord, tempName)) {  
                        //ƥ��ɹ������ļ�����ӵ������  
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
	
	//�ļ���ƥ��
	public boolean fileNameMatch(String keyWord, String tempName) {
		if(tempName.indexOf(keyWord) != -1) {
			return true;
		} else {
			
			return false;
		}
		
	}
	
	
	//�ļ�������������������
	public boolean fileContentMatch(String filePath,String keyWord) {
		boolean result = false;
		File f = new File(filePath);
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String s = br.readLine();
			while (s != null) {
				int num = s.indexOf(keyWord);// ���s���ڵ��±꣬
				if(num != -1) {
					result = true;
					break;
				}
				s = br.readLine();
			}

			br.close();// �رջ�����������ļ�������������.
		} catch (FileNotFoundException e1) {
			System.err.println("File not found: " + filePath);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		return result;
	}

}
