package course.view;

//这个包手动添加,包含了GET,POST等声明

import course.service.PtpProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

//添加Controller的注解
@Controller
//控制器指定可以处理哪些URL请求
@RequestMapping("/jms")
public class CourseController {


	@Autowired
	private PtpProducer ptpProducer;

	@RequestMapping(value="/add",method=GET)
	public String main()
	{
		return "add";
	}
	//可以将post需要传递的数据利用addAttribute函数添加到model中
	@RequestMapping(value="/add",method=POST)
	public String msgSubmit(String text,Model model) {
		model.addAttribute(text);
		//调用addCourse()函数
		ptpProducer.convertAndSend(text);

		return "add";
	}
}
