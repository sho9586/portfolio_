package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Notice;
import com.example.demo.form.Loginform;
import com.example.demo.form.NoticePostForm;
import com.example.demo.service.LoginService;

@Controller
public class LoginController {

    @Autowired
     LoginService loginService;
    
    
    @GetMapping("/login")
    public String showSearchForm() {
        return "login_pege";
    }
        
    @PostMapping("/login/action")
        public String login(
        		@Validated @ModelAttribute Loginform form,
        		BindingResult result,
        		org.springframework.ui.Model model) {
        
        if (result.hasErrors()) {
            // バリデーションエラーがあった場合、エラーメッセージを返す
        		model.addAttribute("validationErrors", result.getAllErrors());
        		return "login_pege"; // エラーがある場合、フォームに戻す    
        	}
            
            String loginResult = loginService.doLogin(form.getUserId(), form.getPassword());
            
        if(loginResult == null) {
        	//ログインに失敗した場合、ログインに失敗したメッセージを設定し、ログイン画面に返す
        	model.addAttribute("message","ユーザーIDまたはパスワードが異なります。");
            return "login_pege";     
        }
        
        //ログインに成功した場合、グループIDをもとにお知らせ情報を取得する
        List<Notice> noticeList = loginService.searchNotice(loginResult);
        
        //お知らせ情報を画面用の変数に設定する
        model.addAttribute("noticeLists",noticeList);
        
        //グループIDを画面に渡す
        model.addAttribute("groupId",loginResult);
        
        //お知らせ描画画面を表示
        return "pege_form";
    }

/**
 * お知らせ登録処理
 * 
 * ＠perm form
 * ＠return
 */

@PostMapping("/postNotice")
public String postNotice(@ModelAttribute NoticePostForm osirase2) {
	
	//フォームをもとにEntityを取得
	Notice noticeEntity = new Notice(osirase2);
			
	//お知らせ情報登録処理にエンティティを渡して設定する
	 loginService.saveNotice(noticeEntity);
	
	//ログイン画面に戻す
	return "login_pege";
    }
}
