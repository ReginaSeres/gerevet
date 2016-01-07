package hu.jusoft.gerevet.controller;

import com.mongodb.gridfs.GridFSDBFile;
import hu.jusoft.gerevet.repository.model.ExaminationFile;
import hu.jusoft.gerevet.service.ExaminationManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * Created by Regina Seres on 1/2/2016.
 */

@Controller
public class TestController {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private ExaminationManagerService examinationManagerService;

    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public String provideUploadInfo() {
        return "bla";
    }

    @RequestMapping(value="/upload", method= RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
                                                 @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                ExaminationFile picture = new ExaminationFile(file.getName(), file.getContentType(), bytes);

           //     examinationManagerService.addImageToExamination("", picture);

                return "You successfully uploaded " + name + "!";
            } catch (Exception e) {
                e.printStackTrace();
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

    @RequestMapping(value = "/image")
    public String getImages(Model model) {
        GridFSDBFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(
                "56898d739e02acfd10000823")));
        InputStream inputStream = file.getInputStream();

        String name = file.getFilename();

        String fileString = file.toString();

        /*
        organizationFileAttachmentService.setUser(getUser());
    GridFSDBFile file = organizationFileAttachmentService.getGridFSDBFileById(new ObjectId(id), "File");
    if (file != null) {
        try {
            response.setContentType(file.getContentType());
            response.setContentLength((new Long(file.getLength()).intValue()));
            response.setHeader("content-Disposition", "attachment; filename=" + file.getFilename());// "attachment;filename=test.xls"
            // copy it to response's OutputStream
            IOUtils.copyLarge(file.getInputStream(), response.getOutputStream());
        } catch (IOException ex) {
            _logger.info("Error writing file to output stream. Filename was '" + id + "'");
            throw new RuntimeException("IOError writing file to output stream");
        }
    }



         */


        return "image";
    }
}
