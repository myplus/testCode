//文件属性，用于记录搜索结果
public class FileProperty {
	private String fileName;
	private String filePath;
	public FileProperty(String FileName, String FilePath){
		this.fileName = FileName;
		this.filePath = FilePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


}
