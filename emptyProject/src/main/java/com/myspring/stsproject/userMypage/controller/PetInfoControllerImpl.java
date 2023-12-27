package com.myspring.stsproject.userMypage.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.stsproject.animal.dao.AnimalDAO;
import com.myspring.stsproject.animal.vo.AnimalVO;
import com.myspring.stsproject.userMypage.dao.PetInfoDAO;
import com.myspring.stsproject.userMypage.dao.UserDAO;
import com.myspring.stsproject.userMypage.service.UserService;
import com.myspring.stsproject.userMypage.vo.PetInfoVO;
import com.myspring.stsproject.userMypage.vo.UserVO;

@Controller("petInfoController")
public class PetInfoControllerImpl implements PetInfoController{

	@Autowired
	PetInfoDAO petInfoDAO;
	
	@Autowired
	PetInfoVO petInfoVO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	UserVO userVO;
	
	@Autowired
	UserService userService;
	
	//pet 추가할때
	@Autowired
	AnimalDAO animalDAO;
	
	
	@Autowired
	AnimalVO animalVO;
	
	
	@Override
	@RequestMapping(value = "/user_Page/myPetList.do", method = RequestMethod.GET)
	public ModelAndView myPetList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName=(String) request.getAttribute("viewName");
		 ModelAndView mav = new ModelAndView(viewName);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8;");
		HttpSession session = request.getSession();
		String user_code=(String) session.getAttribute("user_code");		
		System.out.println("user_code가 뭐냐>>>>>:"+user_code);
		model.addAttribute("user_code",user_code); //jsp로 값 넘겨줘야 할 때 사용
		List<PetInfoVO> petList=petInfoDAO.selectPetList(user_code);		
		mav.addObject("petList", petList);
		return mav;
	}

	@Override
	@RequestMapping(value = "/user_Page/modPet.do", method = RequestMethod.POST)
	public ModelAndView modPet( @ModelAttribute("petInfoVO") PetInfoVO petInfoVO, Model model, HttpServletRequest request,		
		HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8;");
		String viewName=(String) request.getAttribute("viewName");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String user_code=(String) session.getAttribute("user_code");
		
				
		String pet_code=request.getParameter("pet_code");
		String pet_name=request.getParameter("pet_name");
		int pet_age=Integer.parseInt(request.getParameter("pet_age"));
		String pet_sex=request.getParameter("pet_sex");
		String pet_types=request.getParameter("pet_types");
	    String pet_number=request.getParameter("pet_number");
		String b_type=request.getParameter("b_type");
		float pet_weight=Float.parseFloat(request.getParameter("pet_weight"));
		String pet_etc=request.getParameter("pet_etc");
		System.out.println(pet_code);
		System.out.println(pet_name);
		petInfoVO=new PetInfoVO(pet_code, pet_name, pet_age, pet_sex, pet_types, pet_number, b_type, pet_weight, pet_etc);
		
		
		petInfoDAO.updatePet(petInfoVO);
		out=response.getWriter();
		out.print("<script>");
		out.print("alert('동물을 수정했습니다');");
		out.print("location.href='"+request.getContextPath()+"/user_Page/myPetList.do';");
		out.print("</script>");
		
		return null;
	}

	@Override
	@RequestMapping(value = "/user_Page/addPet.do", method = RequestMethod.POST)
	public ModelAndView addPet(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8;");
		HttpSession session = request.getSession();
		String user_code=(String) session.getAttribute("user_code");
		
		String viewName=(String) request.getAttribute("viewName");
		PrintWriter out = response.getWriter();
		String pet_name=request.getParameter("pet_name");
		int pet_age=Integer.parseInt(request.getParameter("pet_age"));
		String pet_sex=request.getParameter("pet_sex");
		String pet_types=request.getParameter("pet_types");
		String pet_number=request.getParameter("pet_number");
		String b_type=request.getParameter("b_type");
		float pet_weight=Float.parseFloat(request.getParameter("pet_weight"));
		String pet_etc=request.getParameter("pet_etc");
		System.out.println(pet_name);
		AnimalVO animalVO = new AnimalVO(user_code, pet_name, pet_age, pet_sex, pet_types, pet_number, b_type, pet_weight, pet_etc);
		animalDAO.addAnimal(animalVO);
		out=response.getWriter();
		out.print("<script>");
		out.print("alert('동물을 추가했습니다');");
		out.print("location.href='"+request.getContextPath()+"/user_Page/myPetList.do';");
		out.print("</script>");
		
		return null;
	}

	@Override
	@RequestMapping(value = "/user_Page/removePetInfo.do", method = RequestMethod.POST)
	public ModelAndView removePetInfo(Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8;");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String pet_code=request.getParameter("pet_code");
		System.out.println("삭제수행");
		petInfoDAO.removePetInfo(pet_code);
		out=response.getWriter();
		out.print("<script>");
		out.print("alert('동물을 삭제했습니다');");
		out.print("location.href='"+request.getContextPath()+"/user_Page/myPetList.do';");
		out.print("</script>");
		return null;
	}

}
