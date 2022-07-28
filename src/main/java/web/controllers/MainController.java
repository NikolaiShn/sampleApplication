package web.controllers;

import exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import web.services.RecordsService;

import java.io.IOException;


@Controller
public class MainController {

    @Autowired
    private RecordsService recordsService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/addOne")
    public String addOnePage() {
        return "addOne";
    }

    @GetMapping("/getRecords")
    public String getRecords(ModelMap records) {
        records.addAttribute("records", recordsService.loadRecords());
        return "records";
    }

    @PostMapping(value = "/addOneRecord")
    public String addOne(@RequestParam("number") Double number, @RequestParam("text") String text, @RequestParam("time") String time,
                         @RequestParam("file") MultipartFile file) throws MultipartFileException, BigLengthException, IncorrectFileFormat, IOException, BlankException, IncorrectDataInput {
        if(file.isEmpty()) {
            throw new MultipartFileException("Файла нет");
        }
        recordsService.saveRecords(number, text, time, file);
        return "index";
    }
}
