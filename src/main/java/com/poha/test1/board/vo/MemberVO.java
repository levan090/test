package com.poha.test1.board.vo;

import java.util.Date;

public class MemberVO {

		private String userId;
		private String userPass;
		private String userName;
		
		
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserPass() {
			return userPass;
		}
		public void setUserPass(String userPass) {
			this.userPass = userPass;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		
		@Override
		public String toString() {
			return "MemberVO [userId=" + userId + ", userPass=" + userPass + ", userName=" + userName + "]";
		}
		
		
		
}
