package com.myexample.demo.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "STOCK_MST")
public class StockMstEntity {
//	@NamedNativeQuery(
//			  name = "FridayEmployees",
//			  query = "SELECT employeeId FROM schedule_days WHERE dayOfWeek = 'FRIDAY'",
//			  resultSetMapping = "FridayEmployeeResult");
//	@SqlResultSetMapping(
//			  name="FridayEmployeeResult",
//			  columns={@ColumnResult(name="employeeId")});
	
	public StockMstEntity() {

	}
	
	@Id
	@Column(name = "STOCK_ID")
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STOCK_MST_SEQ")
	@SequenceGenerator(sequenceName = "STOCK_MST_SEQ", allocationSize = 1, name = "STOCK_MST_SEQ")
	private Long stockId;
	@Column(name = "MATCODE")
	private String matcode;
	@Column(name = "QTY")
	private Long qty;
	@Column(name = "CREATE_DATE")
	private Date createDate;
	@Column(name = "UPDATE_DATE")
	private Date updateDate;
	
	public Long getStockId() {
		return stockId;
	}
	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}
	public String getMatcode() {
		return matcode;
	}
	public void setMatcode(String matcode) {
		this.matcode = matcode;
	}
	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
