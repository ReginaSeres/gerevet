package hu.jusoft.gerevet.controller;

/**
 * Created by Regina Seres on 12/30/2015.
 */
public class ControllerConstants {

    public static final String URL = "url";

    public static final String HOME_URL = "";


    public static final String PICTURES_URL = "/getPhoto";
    public static final String PICTURES_INDEX_VARIABLE = "actPhoto";
    public static final String PICTURES_PARAMETERIZED_URL = PICTURES_URL + "/{" + PICTURES_INDEX_VARIABLE + "}";


    public static final String SEARCH_NAME_URL = "/searchName";
    public static final String SEARCH_NAME_JSON_URL = "/searchNameJSON";


    public static final String SEARCH_URL = "/search";
    public static final String SEARCH_INDEX_VARIABLE = "actPage";
    public static final String SEARCH_QUERY_VARIABLE = "query";
    public static final String SEARCH_ONE_PARAMETRIZED_URL = SEARCH_URL + "/{" + SEARCH_INDEX_VARIABLE + "}";
    public static final String SEARCH_TWO_PARAMETRIZED_URL = SEARCH_ONE_PARAMETRIZED_URL + "/{" + SEARCH_QUERY_VARIABLE + "}";


    public static final String ANIMAL_URL = "/animal";
    public static final String ANIMAL_INDEX_VARIABLE = "actAnimal";
    public static final String ANIMAL_PARAMETERIZED_URL = ANIMAL_URL + "/{" +  ANIMAL_INDEX_VARIABLE + "}";
    public static final String ANIMAL = "animal";

    public static final String UPDATE_ANIMAL_URL = "/updateAnimal";

    public static final String ADD_ANIMAL_URL = "/addAnimal";
    public static final String ADD_ANIMAL = "addAnimal";

    public static final String SAVE_ANIMAL_URL = "/saveAnimal";
    public static final String ANIMAL_PAGE_MODEL_NAME = "animalPageModel";


    public static final String EXAMINATION_URL = "/examination";
    public static final String EXAMINATION_INDEX_VARIABLE = "id";
    public static final String EXAMINATION_PARAMETERIZED_URL = EXAMINATION_URL + "/{" +  EXAMINATION_INDEX_VARIABLE + "}";
    public static final String EXAMINATION = "examination";
    public static final String LIST_OF_EXAMINATIONS = "listOfExaminations";
    public static final String EXAMINATIONS_PAGE_COUNT = "pageCount";
    public static final String EXAMINATIONS_ACT_PAGE = "actPage";
    public static final String EXAMINATION_QUERY_NAME = "queryName";

    public static final String ADD_EXAMINATION_URL = "/addExamination";
    public static final String ADD_EXAMINATION = "addExamination";

    public static final String SAVE_EXAMINATION_URL = "/saveExamination";
    public static final String EXAMINATION_PAGE_MODEL_NAME = "examinationPageModel";



    public static final String GET_PATIENT_URL = "/getPatient";
    public static final String PATIENTID_INDEX_VARIABLE = "patientId";
    public static final String PATIENT_PARAMETERIZED_URL = GET_PATIENT_URL + "/{" + PATIENTID_INDEX_VARIABLE + "}";


    public static final String SEARCH_PARAMETERIZED_URL = "/search/*";


    public static final String EDIT_JS = "editJS";
}
