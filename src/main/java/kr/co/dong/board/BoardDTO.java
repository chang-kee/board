/*Table: board
Columns:
bno int AI PK 
bno varchar(45) 
content varchar(45) 
id varchar(45) 
reddate datetime 
readcnt int 
etc varchar(45)
 * 
 * lombok 라이브러리 사용가능
 */
package kr.co.dong.board;

public class BoardDTO {
	private int bno;
	private String title;
	private String content;
	private String id;
	private String reddate;
	private int readcnt;
	private String etc;
	private int page;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReddate() {
		return reddate;
	}
	public void setReddate(String reddate) {
		this.reddate = reddate;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", title=" + title + ", content=" + content + ", id=" + id + ", reddate="
				+ reddate + ", readcnt=" + readcnt + ", etc=" + etc + ", page=" + page + "]";
	}
	

}
