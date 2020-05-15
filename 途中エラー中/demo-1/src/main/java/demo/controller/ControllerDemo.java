package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.model.ModelData;
import demo.repository.RepositoryData;
import demo.request.RequestDemo;

@Controller
public class ControllerDemo {

	@Autowired
    RepositoryData repositoryData;

    @GetMapping("/")
    public String index(Model model) {


    	//個別表示
    	ModelData displayData = repositoryData.selectByPrimaryKey(1);
    	model.addAttribute("displayId",displayData.getId());
    	model.addAttribute("displayDataDB",displayData.getDatadb());


    	//新規入力画面
    	model.addAttribute("requestData", new RequestDemo());


        return "index";
    }

    @RequestMapping(value="/add")
    public String add(@ModelAttribute ModelData insertData, Model model) {

    	ModelData data = new ModelData();
    	data.setDatadb(insertData.getDatadb());

    	repositoryData.insert(data);

    	return "redirect:";

    }
}














