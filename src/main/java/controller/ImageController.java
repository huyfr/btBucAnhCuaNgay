package controller;

import model.Image;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.ImageService;

import java.util.List;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    private static Logger logger = LogManager.getLogger(ImageController.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView loadIndex() {
        logger.trace("Vao loadIndex");
        ModelAndView index = null;
        Image image;
        try {
            index = new ModelAndView("index");
            image = new Image();
            index.addObject("image", image);
            logger.info(image);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        logger.trace("Thoat loadIndex");
        return index;
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public ModelAndView loadResult (@ModelAttribute("image") Image image) {
        logger.trace("Vao loadResult");
        ModelAndView result = null;
        List<Image> images;
        try {
            result = new ModelAndView("result");
            imageService.saveComment(image);
            logger.info(image.toString());
            images = imageService.findAll();
            result.addObject("images", images);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        logger.trace("Thoat loadResult");
        return result;
    }
}