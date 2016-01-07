package hu.jusoft.gerevet.service;

import hu.jusoft.gerevet.view.model.ExaminationPageModel;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Regina Seres on 12/11/2015.
 */
public interface ListingExaminationService {

    List<ExaminationPageModel> getListOfExaminations();

    Page<hu.jusoft.gerevet.repository.model.Examination> getNExamiationsInActualPage(int actPage, int countExaminationsOnOnePage);
}
