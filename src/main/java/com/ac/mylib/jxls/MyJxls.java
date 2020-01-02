package com.ac.mylib.jxls;

import com.ac.mylib.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class MyJxls {

    public static List<Employee> generateSampleEmployeeData() {
        List<Employee> value = new ArrayList<>();
        BigDecimal payment = new BigDecimal(3.14);
        BigDecimal bonus = new BigDecimal(8.00);
        Employee ada = new Employee("ada", new Date(), payment, bonus);
        Employee bob = new Employee("bob", new Date(), payment, bonus);
        Employee cat = new Employee("cat", new Date(), payment, bonus);
        value.add(ada);
        value.add(bob);
        value.add(cat);
        return value;
    }

    public static void main(String[] args) {
        log.info("Running Object Collection demo");
        List<Employee> employees = generateSampleEmployeeData();
        try (InputStream is = MyJxls.class.getResourceAsStream("object_collection_template.xls")) {
            try (OutputStream os = new FileOutputStream("target/object_collection_output.xls")) {
                Context context = new Context();
                context.putVar("employees", employees);
                JxlsHelper.getInstance().processTemplate(is, os, context);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
