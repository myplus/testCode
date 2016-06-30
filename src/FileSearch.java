import java.util.ArrayList;
//文件搜索接口
public interface FileSearch {
	public void searchFile(String basePath, String keyWord, ArrayList<FileProperty> fileList);
	public boolean fileNameMatch(String keyWord, String fileName);
	public boolean fileContentMatch(String filePath, String keyWord);
}
