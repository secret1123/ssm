package mw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import mw.model.Work;
import mw.service.WorkService;

@Controller
@RequestMapping("work")
public class WorkController extends BaseController {

private final WorkService workService;

@Autowired
public WorkController(WorkService workService) {
this.workService = workService;
}

@RequestMapping("create")
private String create(Work work) {
workService.create(work);
return "redirect:/work/queryAll";
}

@RequestMapping("remove/{id}")
private String remove(@PathVariable("id") Integer id) {
workService.remove(id);
return "redirect:/work/queryAll";
}

@RequestMapping("modify")
private String modify(Work work) {
workService.modify(work);
return "redirect:/work/queryAll";
}

@RequestMapping("queryAll/{page}")
private String queryAll(@PathVariable int page) {
session.setAttribute("pagination", workService.queryAll(page));
return "redirect:/work/list.jsp";
}

@RequestMapping("queryAll")
private String queryAll() {
return queryAll(1);
}

@RequestMapping("queryById/{id}")
private String queryById(@PathVariable("id") Integer id) {
session.setAttribute("work", workService.queryById(id));
return "redirect:/work/edit.jsp";
}
}