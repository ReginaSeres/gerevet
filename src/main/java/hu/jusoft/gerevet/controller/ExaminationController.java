package hu.jusoft.gerevet.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import hu.jusoft.gerevet.repository.model.*;
import hu.jusoft.gerevet.service.AnimalManagerService;
import hu.jusoft.gerevet.service.ExaminationManagerService;
import hu.jusoft.gerevet.service.PatientManagerService;
import hu.jusoft.gerevet.view.modelbuilder.ExaminationModelBuilder;
import hu.jusoft.gerevet.view.modelbuilder.PatientModelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static hu.jusoft.gerevet.controller.ControllerConstants.*;

/**
 * Created by Regina Seres on 12/11/2015.
 */
@Controller
public class ExaminationController {

    @Autowired
    private ExaminationModelBuilder examinationModelBuilder;

    @Autowired
    private ExaminationManagerService examinationManagerService;

    @Autowired
    private PatientManagerService patientManagerService;

    @Autowired
    private PatientModelBuilder patientModelBuilder;

    @Autowired
    private AnimalManagerService animalManagerService;

    @Autowired
    private PDFExportingController pdfExportingController;

    @RequestMapping(value = EXAMINATION_PARAMETERIZED_URL)
    public ModelAndView examination(@PathVariable(EXAMINATION_INDEX_VARIABLE) String id) {
        Examination examination = examinationManagerService.findExaminationByExaminationId(id);

        ModelAndView mav = new ModelAndView(EXAMINATION);
        mav.addAllObjects(examinationModelBuilder.buildExaminationMap(examination));

        return mav;
    }

    @RequestMapping(value = ADD_EXAMINATION_URL)
    public ModelAndView addExamination() {
        List<Patient> listOfPatients = patientManagerService.findAllPatient();

        ModelAndView mav = new ModelAndView(ADD_EXAMINATION);
        mav.addAllObjects(patientModelBuilder.buildPatientModelMap(listOfPatients));

        return mav;
    }
}
