package all_info;

import java.util.List;

public class upload_info {
	private int user_id;//�û�id
	private int group_id;//�û��ķ���id
	private int note_id;//������ıʼ�id
	private String html_path;//�ʼǵ�html�ļ���·��
	private List<String> pic_list;//�ʼǵ�ͼƬ·��
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int userId) {
		user_id = userId;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int groupId) {
		group_id = groupId;
	}
	public int getNote_id() {
		return note_id;
	}
	public void setNote_id(int noteId) {
		note_id = noteId;
	}
	public String getHtml_path() {
		return html_path;
	}
	public void setHtml_path(String htmlPath) {
		html_path = htmlPath;
	}
	public List<String> getPic_list() {
		return pic_list;
	}
	public void setPic_list(List<String> picList) {
		pic_list = picList;
	}
}
