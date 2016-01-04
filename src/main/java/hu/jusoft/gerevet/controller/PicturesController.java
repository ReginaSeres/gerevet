package hu.jusoft.gerevet.controller;

import com.mongodb.gridfs.GridFSDBFile;
import hu.jusoft.gerevet.service.ExaminationManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import static hu.jusoft.gerevet.controller.ControllerConstants.*;

/**
 * Created by Regina Seres on 1/4/2016.
 */
@Controller
public class PicturesController {

    @Autowired
    private ExaminationManagerService examinationManagerService;

    @RequestMapping(value = PICTURES_PARAMETERIZED_URL, method = RequestMethod.GET)
    public @ResponseBody
    void getPhoto(@PathVariable(PICTURES_INDEX_VARIABLE) String id, HttpServletRequest request,
                  HttpServletResponse response) {
        try {
            GridFSDBFile imageForOutput = examinationManagerService.findImageById(id);
            InputStream is = imageForOutput.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] data = new byte[16384];
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            byte[]imagenEnBytes = buffer.toByteArray();

            response.setHeader("Accept-ranges","bytes");
            response.setContentType( "image/jpeg" );
            response.setContentLength(imagenEnBytes.length);
            response.setHeader("Expires","0");
            response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Content-Description","File Transfer");
            response.setHeader("Content-Transfer-Encoding:","binary");

            OutputStream out = response.getOutputStream();
            out.write( imagenEnBytes );
            out.flush();
            out.close();
        } catch (Exception e) {


        }
    }
}
