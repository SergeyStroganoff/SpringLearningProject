package org.example.controller;


import org.example.entity.dto.DetailDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping("/detail")
public class DetailController {

    @RequestMapping("/add")
    public String getDetailFromUI(Model model) {
        model.addAttribute("detail", new DetailDTO());
        return "askDetail";
    }

    @RequestMapping("/showResult")
    public String showResult(@Valid @ModelAttribute("detail") DetailDTO detailDTO,
                             BindingResult bindingResult, Model model) { // BindingResult goes after @ModelAttribute !!!
        if (bindingResult.hasErrors()) { // validation
            return "askDetail";
        }
        model.addAttribute("operationResult", "successfully"); // another way validation
        if (Objects.equals(detailDTO.getCity(), "") || detailDTO.getCity() == null) {
            System.out.println("Input is incorrect");
            throw new IllegalArgumentException("Error input detail data");
        }
        return "deatailResult";
    }
}
