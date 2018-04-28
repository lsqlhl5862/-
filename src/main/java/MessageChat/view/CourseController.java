package MessageChat.view;

//这个包手动添加,包含了GET,POST等声明

import MessageChat.service.MessageService;
import MessageChat.service.PtpProducer;
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
	@Autowired
	private MessageService messageService;

	@RequestMapping(value="/add",method=GET)
	public String main(Model model)
	{
		model.addAttribute("MessageList", messageService.ListMessage());
		return "add";
	}
	//可以将post需要传递的数据利用addAttribute函数添加到model中
	@RequestMapping(value="/add",method=POST)
	public String msgSubmit(String text,Model model) throws InterruptedException {
		model.addAttribute(text);
		//调用addCourse()函数
		ptpProducer.convertAndSend(text);
		model.addAttribute("MessageList", messageService.ListMessage());
		return "add";
	}
}
