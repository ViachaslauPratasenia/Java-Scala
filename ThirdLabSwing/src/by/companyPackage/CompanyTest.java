package by.companyPackage;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CompanyTest {
    @Test
    public void testAdding(){
        Company company = new Company();
        String str1 = "Задача 1";
        company.setTasks();
        ArrayList<String> list = company.getTasks();
        assertEquals("Error", str1, list.get(0));
    }
}
