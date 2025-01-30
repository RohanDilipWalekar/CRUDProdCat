package com.book.BookManagementSystem.model;

public class BookDesc {
	    private int BId;
	    public BookDesc() {
			super();
		}

		public BookDesc(int bId, String bName, String bAuthor, String bPublish, int bPrice) {
			super();
			BId = bId;
			BName = bName;
			this.bAuthor = bAuthor;
			BPublish = bPublish;
			BPrice = bPrice;
		}

		private String BName;
	    private String bAuthor;
	    private String BPublish;
	    private int BPrice;

	    // Getters and Setters
	    public int getBId() {
	        return BId;
	    }

	    public void setBId(int BId) {
	        this.BId = BId;
	    }

	    public String getBName() {
	        return BName;
	    }

	    public void setBName(String BName) {
	        this.BName = BName;
	    }

	    public String getBAuthor() {
	        return bAuthor;
	    }

	    public void setBAuthor(String bAuthor) {
	        this.bAuthor = bAuthor;
	    }

	    public String getBPublish() {
	        return BPublish;
	    }

	    public void setBPublish(String BPublisher) {
	        this.BPublish = BPublisher;
	    }

	    public int getBPrice() {
	        return BPrice;
	    }

	    public void setBPrice(int BPrice) {
	        this.BPrice = BPrice;
	    }
	
}
