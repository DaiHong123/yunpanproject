package cn.qst.pojo;

import java.util.List;

/**
 * 查询文件返回的结果对象
 * @author Administrator
 *
 */
public class FileResult {
	private List<TbFile> files;
	private List<TbFile> parent;
	public List<TbFile> getFiles() {
		return files;
	}
	public void setFiles(List<TbFile> files) {
		this.files = files;
	}
	public List<TbFile> getParent() {
		return parent;
	}
	public void setParent(List<TbFile> parent) {
		this.parent = parent;
	}
}
