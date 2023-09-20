package bean;

public class Note {
	protected int noteID;
	protected String author;
	protected String noteTitle;
	protected String noteContent;
	protected int visit;
	protected String categoryName;
	protected String createTime;
	protected String updateTime;
	public int getNoteID() {
		return noteID;
	}
	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	public int getVisit() {
		return visit;
	}
	public void setVisit(int visit) {
		this.visit = visit;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
}
