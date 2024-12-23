package com.example.demo.form;


import jakarta.validation.constraints.Size;

public class Loginform {

    @jakarta.validation.constraints.Pattern(regexp = "^[A-Za-z0-9]+$", message = "User IDは英数字のみです。")
    @Size(max=20, message="User IDは最大20文字です。")
    private String userId;

    @jakarta.validation.constraints.Pattern(regexp = "^[A-Za-z0-9]+$", message = "パスワードは英数字のみです。")
    @Size(max=20, message="パスワードは最大20文字です。")
    private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}
