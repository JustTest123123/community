package life.majiang.community.community.mycontroller;

import life.majiang.community.community.dto.PaginationDTO;
import life.majiang.community.community.dto.QuestionDTO;
import life.majiang.community.community.model.User;
import life.majiang.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private QuestionService questionService;


    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action")String action, Model model
    , HttpServletRequest request,@RequestParam(name = "page",defaultValue = "1")Integer page,
                          @RequestParam(name = "size",defaultValue = "5")Integer size){
        System.out.println("进入到我的" + action);
        User user = null;
        user = (User) request.getSession().getAttribute("user");
        if(user == null){
            return "redirect:/";
        }
        if("questions".equals(action)){
            model.addAttribute("section","question");
            model.addAttribute("sectionName","我的问题");
        }else if ("replies".equals(action)){
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","最新回复");
        }
        PaginationDTO paginationDTO = (PaginationDTO) questionService.list(user.getId().intValue(), page, size);
        paginationDTO.setPagination(paginationDTO.getTotalpage(),page,size);
        model.addAttribute("pagination",paginationDTO);
        List<QuestionDTO> questions = paginationDTO.getQuestions();
        for (QuestionDTO question : questions) {
            System.out.println(question.toString());
        }
        System.out.println("userID\t"+user.getId());
        return "profile";
    }
}
