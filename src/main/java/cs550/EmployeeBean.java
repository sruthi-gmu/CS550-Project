package cs550;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EmployeeBean {
    private String firstName;
    private String middleInitials;
    private String lastName;
    private String ssn;
    private String dateOfBirth;
    private String address;
    private String sex;
    private String salary;
    private String supervisorSsn;
    private String departmentNumber;
    private ProjectBean project;
    private String workHours;
    private String haveDependent;
    private List<DependentBean> dependentList = new ArrayList<DependentBean>();

    public void makeList(DependentBean dependent) {
        dependentList.add(dependent);
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitials() {
        return middleInitials;
    }

    public void setMiddleInitials(String middleInitials) {
        this.middleInitials = middleInitials;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSupervisorSsn() {
        return supervisorSsn;
    }

    public void setSupervisorSsn(String supervisorSsn) {
        this.supervisorSsn = supervisorSsn;
    }

    public String getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public ProjectBean getProject() {
        return project;
    }

    public void setProject(ProjectBean project) {
        this.project = project;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public String getHaveDependent() {
        return haveDependent;
    }

    public void setHaveDependent(String haveDependent) {
        this.haveDependent = haveDependent;
    }

    public List<DependentBean> getDependentList() {
        return dependentList;
    }

    public void setDependentList(List<DependentBean> dependentList) {
        this.dependentList = dependentList;
    }
}
