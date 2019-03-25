package com.hef.spittr.web;

import com.hef.spittr.entities.Spittle;
import com.hef.spittr.service.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    public static final String MAX_LONG_AS_STRING=Long.MAX_VALUE + "";

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    /**
     * 将spittle添加到模型中
     * 返回视图名
     * @param model
     * @return
     */
//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Model model) {
//        List<Spittle> spittles = spittleRepository.findSpittles(Long.MAX_VALUE, 20);
//        model.addAttribute(spittles);
//        return "spittles";
//    }

    /**
     * 分页查询
     * @param max  id的最大值
     * @param count  spittle的数量
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
                                  @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value = "/spittles2",method = RequestMethod.GET)
    public String spittles2(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
                                  @RequestParam(value = "count", defaultValue = "20") int count, Model model) {
        List<Spittle> spittleList=spittleRepository.findSpittles(max, count);
        model.addAttribute(spittleList);
        return "/jsplibview/spittles";
    }


    /**
     *   根据id查询Spittle
     * @param spittleId
     * @param model
     * @return
     */
    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId,
                          Model model) {
        Spittle spittle = spittleRepository.findOne(spittleId);
        if (spittle == null){
            throw new SpittleNotFoundException();
        }
        model.addAttribute(spittle);
        return "spittle";
    }

    @RequestMapping(value = "/spittle2/{spittleId}", method = RequestMethod.GET)
    public String spittle2(@PathVariable("spittleId") long spittleId,
                          Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "/jsplibview/spittle";
    }


    @RequestMapping(value = "/spittleForm" , method = RequestMethod.GET)
    public String spittleForm(){
        return "spittleForm";
    }

    @RequestMapping(value = "/saveSpittle", method = RequestMethod.POST)
    public String saveSpittle(Spittle spittle, Model model) {
        System.out.println(spittle);
        if (spittle.getId() == null){
            throw new DuplicateSpittleException();
        }else {
            spittleRepository.save(spittle);
            return "redirect:/spittles";
        }
    }

    // 控制器通知取代该方法
//    @ExceptionHandler(value = DuplicateSpittleException.class)
//    public String handleDuplicateSpittle(){
//        return "/error/duplicate";
//    }
}
