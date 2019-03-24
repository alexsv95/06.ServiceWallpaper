package ru.itpark.servicewallpapaer.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import ru.itpark.servicewallpapaer.service.WallpaperService;

@Controller
public class WallpaperController {
    private WallpaperService service;

    public WallpaperController(WallpaperService service) { this.service = service; }

    @RequestMapping
    public String Index(Model model) {
        model.addAttribute("title", "some value");
        return "Index";
    }

    @RequestMapping(params = {"wallWidth", "wallLength", "ceilingHeight"})
    public String calculate(Model model, @RequestParam int wallWidth, @RequestParam double wallLength, @RequestParam double ceilingHeight) {
        double summ = service.calculate(wallWidth, wallLength, ceilingHeight);
        model.addAttribute("result", summ);
        return "Index";
    }
}
