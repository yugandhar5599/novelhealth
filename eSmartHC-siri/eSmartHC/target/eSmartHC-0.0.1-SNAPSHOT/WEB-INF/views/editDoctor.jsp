<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div class="modal-dialog">
   
          <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
        <h4 class="modal-title custom_align" id="Heading">Edit Doctor Detail</h4>
      </div> 
      <form:form action="updateDoctor" modelAttribute="doctorBean">
          <div class="modal-body">
          
          <div class="form-group">
        <label>DocId:</label>
        <form:input class="form-control " type="text" path="docId" />
        </div>
        <label>DoctorName:</label>
        <div class="form-group">
        <form:input class="form-control " type="text" path="docName" />
        </div>
        <label>Gender:</label>
         <div class="form-group">
        <form:input class="form-control " type="text" path="gender" />
        </div>
         <label>Email:</label>
         <div class="form-group">
        <form:input class="form-control" type="text" path="email" />
        </div>
        <!-- <div class="form-group">
        <input class="form-control " type="button" value="update">
        </div>
        <div class="form-group">
        <input class="form-control " type="button" value="cancel">
        </div> -->
      </div>
          <div class="modal-footer ">
        <button type="submit" class="btn btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Update</button>
      </div>
       </form:form>
        </div>
       
    <!-- /.modal-content --> 
  </div>
      <!-- /.modal-dialog --> 
</body>
</html>