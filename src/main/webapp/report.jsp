<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<title>employee_report</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="project.css">
</head>
<body>
<div class="container">
  <h1> EMPLOYEE REPORT </h1>
  <form method = "post" action = "/project/newEmployee">
    <h3> Employee </h3>
    <div class="row">
      <div class="col-25">
        <label for="fname" id="fname">First Name:</label>
      </div>
      <div class="col-75">
        <span>${employeeDetails.firstName}</span>
      </div>
    </div>
      
      <div class="row">
      <div class="col-25">
        <label for="minit" id="minit">Middle Initials:</label>
      </div>
      <div class="col-75">
        <span>${employeeDetails.middleInitials}</span>
      </div>
    </div>

    <div class="row">
      <div class="col-25">
        <label for="lname" id="lname">Last Name:</label>
      </div>
      <div class="col-75">
        <span>${employeeDetails.lastName}</span>
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="ssn" id="ssn">SSN:</label>
      </div>
      <div class="col-75">
        <span>${employeeDetails.ssn}</span>
      </div>
    </div>
    
    <div class="row">
    <div class="col-25">
      <label for="bdate" id="bdate"> Date of Birth:</label>
    </div>
    <div class="col-75">
      <span>${employeeDetails.dateOfBirth}</span>
    </div>
    </div>

    <div class="row">
      <div class="col-25">
        <label for="address"> Address</label>
      </div>
      <div class="col-75">
        <span>${employeeDetails.address}</span>
      </div>
    </div>
      
    <div class="row">
    <div class="col-25">
      <label for="sex">Sex</label>
    </div>
    <div class="col-75">
      <span>${employeeDetails.sex}</span>
    </div>
    </div>

  <div class="row">
    <div class="col-25">
      <label for="salary" id="salary"> Salary</label>
    </div>
    <div class="col-75">
      <span>${employeeDetails.salary}</span>
    </div>
  </div>

  <div class="row">
    <div class="col-25">
      <label for="superssn" id="superssn"> Supervisor SSN</label>
    </div>
    <div class="col-75">
      <span>${employeeDetails.supervisorSsn}</span>
    </div>
  </div>
      
  <div class="row">
    <div class="col-25">
      <label for="dno" id="dno"> Department Number</label>
    </div>
    <div class="col-75">
      <span>${employeeDetails.departmentNumber}</span>
    </div>
  </div>
      
    <h3> Projects and Hours</h3>
       
    <c:if test='${!employeeDetails.project.hr1.equals("0")}'>
    <div class="row">
    <div class="col-25">
      <label for="pno"> Product X</label>
    </div>
    <div class="col-75">
        <span>${employeeDetails.project.hr1}</span>
    </div>
    </div>
    </c:if>
      
    <c:if test='${!employeeDetails.project.hr2.equals("0")}'>
    <div class="row">
    <div class="col-25">
      <label for="pno"> Product Y</label>
    </div>
    <div class="col-75">
        <span>${employeeDetails.project.hr2}</span>
    </div>
    </div>
    </c:if>
      
    <c:if test='${!employeeDetails.project.hr3.equals("0")}'>
    <div class="row">
    <div class="col-25">
      <label for="pno"> Product Z</label>
    </div>
    <div class="col-75">
        <span>${employeeDetails.project.hr3}</span>
    </div>
    </div>
    </c:if>
      
    <c:if test='${!employeeDetails.project.hr10.equals("0")}'>
    <div class="row">
    <div class="col-25">
      <label for="pno"> Computerization</label>
    </div>
    <div class="col-75">
        <span>${employeeDetails.project.hr10}</span>
    </div>
    </div>
    </c:if>
      
    <c:if test='${!employeeDetails.project.hr20.equals("0")}'>
    <div class="row">
    <div class="col-25">
      <label for="pno"> Reorganization</label>
    </div>
    <div class="col-75">
        <span>${employeeDetails.project.hr20}</span>
    </div>
    </div>
    </c:if>
      
    <c:if test='${!employeeDetails.project.hr30.equals("0")}'>
    <div class="row">
    <div class="col-25">
      <label for="pno">Newbenifits</label>
    </div>
    <div class="col-75">
        <span>${employeeDetails.project.hr30}</span>
    </div>
    </div>
    </c:if>
      
    <h3> Dependents </h3>
    <c:forEach var="item" items="${employeeDetails.dependentList}">
      <div class="row">
      <div class="col-25">
        <label for="dependent_name" id="dependent_name">Dependent Name</label>
      </div>
      <div class="col-75">
        <span>${item.name}</span>
      </div>
      </div>
        
      <div class="row">
      <div class="col-25">
        <label for="sex" id="sex">Sex</label>
      </div>
      <div class="col-75">
        <span>${item.sex}</span>
      </div>
      </div>
        
      <div class="row">
      <div class="col-25">
        <label for="bdate" id="bdate">Date of Birth</label>
      </div>
      <div class="col-75">
        <span>${item.dateOfBirth}</span>
      </div>
      </div>
        
      <div class="row">
      <div class="col-25">
        <label for="relationship" id="relationship">Relationship</label>
      </div>
      <div class="col-75">
        <span>${item.relationship}</span>
      </div>
      </div>
    </c:forEach>
        
</form>
</div>
</body>
</html>
