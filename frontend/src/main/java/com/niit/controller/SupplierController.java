package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.supplierDao;
import com.niit.model.supplier;

@Controller
public class SupplierController {
@Autowired
supplierDao supplierdao;
boolean flag=true;
@RequestMapping("/supplier")
public String showSupplier(Model m)
{
	List<supplier> listsuppliers=supplierdao.getsuppliers();
	m.addAttribute("listsuppliers", listsuppliers);
	
	for(supplier Supplier : listsuppliers)
	{
		System.out.println(Supplier.getSupplierName()+",");
	}
	flag=false;
	return "supplierpage";
}
@RequestMapping(value="/InsertSupplier",method=RequestMethod.POST)
public String insertSupplierData(@RequestParam("supname")String supname,@RequestParam("supadd")String supadd,Model m){
	supplier s=new supplier();
	s.setSupplierName(supname);
	s.setSupplierAddress(supadd);
	supplierdao.addsupplier(s);
	List<supplier> listsuppliers=supplierdao.getsuppliers();
	m.addAttribute("listsuppliers", listsuppliers);
	flag=false;
	return "supplierpage";	
}
@RequestMapping("/deleteSupplier/{supplierId}")
public String deleteSupplierData(@PathVariable("supplierId")int supplierId,Model m)
{
	supplier s=supplierdao.getsupplier(supplierId);
	supplierdao.deletesupplier(s);
	List<supplier> listsuppliers=supplierdao.getsuppliers();
	m.addAttribute("listsuppliers", listsuppliers);
	flag=false;
	return "supplierpage";
	
}
@RequestMapping("/updateSupplier/{supplierId}")
public String updateSupplierData(@PathVariable("supplierId")int supplierId,Model m)
{
	supplier s=supplierdao.getsupplier(supplierId);
	supplierdao.updatesupplier(s);
	List<supplier> listsuppliers=supplierdao.getsuppliers();
	m.addAttribute("listsuppliers", listsuppliers);
	m.addAttribute("supplierInfo",s);
	return "updateSupplier";
	
}
@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
public String updateSupplierInDB(@RequestParam("supid") int supplierId,@RequestParam("supname") String supplierName,
		@RequestParam("supadd") String supplierAddress,Model m)
{
	supplier s=supplierdao.getsupplier(supplierId);
	s.setSupplierName(supplierName);
	s.setSupplierAddress(supplierAddress);
	supplierdao.updatesupplier(s);
	List<supplier> listsuppliers=supplierdao.getsuppliers();
	m.addAttribute("listsuppliers", listsuppliers);
	return "supplierpage";
	
}

}
