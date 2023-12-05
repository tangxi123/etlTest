package testcase.base.mapper.ods;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
@Mapper
public interface OdsMetadataMapper {
    @Select("SELECT TABLE_NAME,\n" +
            "       COLUMN_NAME,\n" +
            "       IS_NULLABLE,\n" +
            "       DATA_TYPE,\n" +
            "       if(CHARACTER_MAXIMUM_LENGTH is null,0,CHARACTER_MAXIMUM_LENGTH) AS MAX_LENGTH\n" +
            "FROM information_schema.COLUMNS\n" +
            "where TABLE_NAME in (\n" +
            "                     'case_base_info',\n" +
            "                    'case_diagnosis_record',\n" +
            "                    'case_extend_record',\n" +
            "                    'case_operation_record',\n" +
            "                    'case_residence_record',\n" +
            "                    'cl_cec_hosp_org',\n" +
            "                    'dict_staff_dict',\n" +
            "                    'inp_diagnosis_record',\n" +
            "                    'inp_order_record',\n" +
            "                    'inp_visit_record',\n" +
            "                    'lis_report_detail',\n" +
            "                    'lis_report_master',\n" +
            "                    'outp_diagnosis_record',\n" +
            "                    'outp_medical_record',\n" +
            "                    'outp_order_detail',\n" +
            "                    'outp_order_master',\n" +
            "                    'outp_register_record',\n" +
            "                    'outp_visit_record',\n" +
            "                    'patient_basic_info',\n" +
            "                    'T_Person'\n" +
            "                    );\n")
    ArrayList<HashMap<String,Object>> getOdsMetaData();

    @Select("SELECT TABLE_NAME,\n" +
            "       COLUMN_NAME,\n" +
            "       IS_NULLABLE,\n" +
            "       DATA_TYPE,\n" +
            "       if(CHARACTER_MAXIMUM_LENGTH is null,0,CHARACTER_MAXIMUM_LENGTH) AS MAX_LENGTH\n" +
            "FROM information_schema.COLUMNS\n" +
            "where TABLE_NAME in (\n" +
            "                     'case_base_info',\n" +
            "                    'case_diagnosis_record',\n" +
            "                    'case_extend_record',\n" +
            "                    'case_operation_record',\n" +
            "                    'case_residence_record',\n" +
            "                    'cl_cec_hosp_org',\n" +
            "                    'dict_staff_dict',\n" +
            "                    'inp_diagnosis_record',\n" +
            "                    'inp_order_record',\n" +
            "                    'inp_visit_record',\n" +
            "                    'lis_report_detail',\n" +
            "                    'lis_report_master',\n" +
            "                    'outp_diagnosis_record',\n" +
            "                    'outp_medical_record',\n" +
            "                    'outp_order_detail',\n" +
            "                    'outp_order_master',\n" +
            "                    'outp_register_record',\n" +
            "                    'outp_visit_record',\n" +
            "                    'patient_basic_info',\n" +
            "                    'T_Person'\n" +
            "                    );\n")
    HashMap<String,Object> getOdsMetaData1();

}
