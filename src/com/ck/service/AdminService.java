package com.ck.service;

import java.util.List;

import com.ck.po.Admin;

public interface AdminService {
	public Integer login(Admin admin);

	public List<Admin> findAdmin();

	public Admin findAdminById(Integer id);

	public List<Admin> findAdminByIdList(List<Integer> list);

	public Integer addAdmin(Admin admin);

	public Integer delAdmin(Integer id);

	public Integer delAdminList(List<Integer> list);

	public Integer changeAdmin(Admin admin);

}
