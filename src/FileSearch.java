import java.util.ArrayList;
//�ļ������ӿ�
public interface FileSearch {
	public void searchFile(String basePath, String keyWord, ArrayList<FileProperty> fileList);
	public boolean fileNameMatch(String keyWord, String fileName);
}
