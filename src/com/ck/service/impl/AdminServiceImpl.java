package com.ck.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.dao.AdminDao;
import com.ck.po.Admin;
import com.ck.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	public Integer login(Admin admin) {
		return this.adminDao.login(admin);
	}

	public List<Admin> findAdmin() {
		return this.adminDao.findAdmin();
	}

	public Admin findAdminById(Integer id) {
		return this.adminDao.findAdminById(id);
	}

	public List<Admin> findAdminByIdList(List<Integer> list) {
		return this.adminDao.findAdminByIdList(list);
	}

	public Integer addAdmin(Admin admin) {
		return this.adminDao.addAdmin(admin);
	}

	public Integer delAdmin(Integer id) {
		return this.adminDao.delAdmin(id);
	}

	public Integer delAdminList(List<Integer> list) {
		return this.adminDao.delAdminList(list);
	}

	public Integer changeAdmin(Admin admin) {
		return this.adminDao.changeAdmin(admin);
	}

}
