package com.myspring.stsproject.hosList.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.stsproject.hosList.vo.hospitalVO;

public interface hospitalController {

	public ModelAndView Hospital_detail (@ModelAttribute("hospitalVO") hospitalVO hospitalVO, String hos_code, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
