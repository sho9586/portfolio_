package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.demo.Util.Util;
import com.example.demo.entity.Notice;
import com.example.demo.entity.Users;
import com.example.demo.repository.NoticeRepository;
import com.example.demo.repository.UsersRepository;

@Service
public class LoginService {

	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	NoticeRepository noticeRepository;	
	
	public String doLogin(String userId, String password) {
	
		String md5Password = Util.toMd5(password);
		
		List<Users> result = usersRepository.findByActiveFlagAndUserIdAndPassword(true,userId,md5Password);
		
		if (!CollectionUtils.isEmpty(result)) {
			return result.get(0).getGroupId();
		}	
			return null;
			
	}
	public List<Notice> searchNotice(String groupId){
		return noticeRepository.findByActiveFlagAndGroupId(true,groupId);
		
	}
	
	/**
	 * お知らせ情報登録処理
	 */
	public void saveNotice(Notice osirase2){
		//Entityを渡して登録をしてくれる処理（自動実装のため、NoticeRepositoryに追加処理は不要）
		noticeRepository.save(osirase2);
	}
}