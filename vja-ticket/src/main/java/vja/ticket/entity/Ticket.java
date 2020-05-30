package vja.ticket.entity;



public class Ticket {
    private int id;
    private String ngaydi;
    private String ngayve;
    private String noidi;
    private String noiden;
    private Integer nguoilon;
    private Integer treem;
    private Integer embe;

    public Ticket(int id, String ngaydi, String ngayve, String noidi,String noiden, Integer nguoilon,Integer treem,Integer embe) {
		super();
		this.id = id;
		this.ngaydi = ngaydi;
		this.ngayve = ngayve;
		this.noidi = noidi;
		this.noiden = noiden;
		this.nguoilon = nguoilon;
		this.treem = treem;
		this.embe = embe;
		
	}
	public Ticket() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNgaydi() {
		return ngaydi;
	}
	public void setNgaydi(String ngaydi) {
		this.ngaydi = ngaydi;
	}
	public String getNgayve() {
		return ngayve;
	}
	public void setNgayve(String ngayve) {
		this.ngayve = ngayve;
	}
	public String getNoidi() {
		return noidi;
	}
	public void setNoidi(String noidi) {
		this.noidi = noidi;
	}
	public String getNoiden() {
		return noiden;
	}
	public void setNoiden(String noiden) {
		this.noiden = noiden;
	}
	public Integer getNguoilon() {
		return nguoilon;
	}
	public void setSonguoi(Integer nguoilon) {
		this.nguoilon = nguoilon;
	}	
	public Integer getTreem() {
		return treem;
	}
	public void setTreem(Integer treem) {
		this.treem = treem;
	}
	public Integer getEmbe() {
		return embe;
	}
	public void setEmbe(Integer embe) {
		this.embe = embe;
	}
	
	
}
